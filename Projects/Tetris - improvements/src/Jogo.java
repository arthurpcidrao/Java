import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Jogo extends JFrame {

	public static File arquivo = new File("C:\\Users\\arthu\\OneDrive\\Área de Trabalho\\Codes\\Java\\Projects\\Tetris - improvements\\Classificacao - jogadores\\Ranking.txt");
  
	private static final long serialVersionUID = 1L;
	private static final int FPS = 1000/20;
	private static final int JANELA_ALTURA = 672;
	public static final int largura_extra = 250;
	private static final int JANELA_LARGURA = largura_extra + 500 + largura_extra;

	private JPanel tela;
	private Graphics2D g2d;
	private BufferedImage buffer;
	private CenarioPadrao cenario;

	public static Ranking classificacao = new Ranking();

	public enum Tecla {
		CIMA, BAIXO, ESQUERDA, DIREITA, Z, W, ENTER, ESC, ESPACO
	}

	public static boolean[] controleTecla = new boolean[Tecla.values().length];

	public static void liberaTeclas() {
		for (int i = 0; i < controleTecla.length; i++) {
			controleTecla[i] = false;
		}
	}

	private void setaTecla(int tecla, boolean pressionada) {
		switch (tecla) {
		case KeyEvent.VK_UP:
			controleTecla[Tecla.CIMA.ordinal()] = pressionada;
			break;
		case KeyEvent.VK_DOWN:
			controleTecla[Tecla.BAIXO.ordinal()] = pressionada;
			break;
		case KeyEvent.VK_LEFT:
			controleTecla[Tecla.ESQUERDA.ordinal()] = pressionada;
			break;
		case KeyEvent.VK_RIGHT:
			controleTecla[Tecla.DIREITA.ordinal()] = pressionada;
			break;
		case KeyEvent.VK_Z:
			controleTecla[Tecla.Z.ordinal()] = pressionada;
			break;
		case KeyEvent.VK_ESCAPE:
			controleTecla[Tecla.ESC.ordinal()] = pressionada;
			break;
		case KeyEvent.VK_SPACE:
			controleTecla[Tecla.ESPACO.ordinal()] = pressionada;
			break;
		case KeyEvent.VK_W:
			controleTecla[Tecla.W.ordinal()] = pressionada;
			break;
		case KeyEvent.VK_ENTER:
			controleTecla[Tecla.ENTER.ordinal()] = pressionada;
		}
	}

	public static int nivel = 1;

	public static boolean pausado;

	public Jogo() {
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				setaTecla(e.getKeyCode(), false);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				setaTecla(e.getKeyCode(), true);
			}
		});

		buffer = new BufferedImage(JANELA_LARGURA, JANELA_ALTURA, BufferedImage.TYPE_INT_RGB);

		g2d = buffer.createGraphics();

		tela = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				g.drawImage(buffer, 0, 0, null);
			}

			@Override
			public Dimension getPreferredSize() {
				return new Dimension(JANELA_LARGURA, JANELA_ALTURA);
			}

			@Override
			public Dimension getMinimumSize() {
				return getPreferredSize();
			}
		};

		setBackground(Color.BLACK);
		setTitle("Tetris - Arthur Paraiba Cidrão");
		getContentPane().add(tela, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();

		setVisible(true);
		tela.repaint();

	}

	private void carregarJogo() {
		cenario = new InicioCenario(tela.getWidth(), tela.getHeight());
		cenario.carregar();
	}

	public void iniciarJogo() {
		long prxAtualizacao = 0;


		while (true) {
			if (System.currentTimeMillis() >= prxAtualizacao) {

				g2d.setColor(Color.BLACK);
				g2d.fillRect(0, 0, JANELA_LARGURA, JANELA_ALTURA);

				if (controleTecla[Tecla.ENTER.ordinal()]) {
					// Pressionou enter
					if (cenario instanceof InicioCenario) {
						cenario.descarregar();
						cenario = null;
						cenario = new JogoCenario(tela.getWidth(), tela.getHeight());

						g2d.setColor(Color.WHITE);
						g2d.drawString("Carregando...", 20, 20);
						tela.repaint();
						

						cenario.carregar();

					} else {
						Jogo.pausado = !Jogo.pausado;
					}

					liberaTeclas();

				} else if (controleTecla[Tecla.ESC.ordinal()]) {
					// Pressionou ESQ
					JogoCenario.pontos = 0;

					if (!(cenario instanceof InicioCenario)) {
						cenario.descarregar();

						cenario = null;
						cenario = new InicioCenario(tela.getWidth(), tela.getHeight());
						cenario.carregar();
					}

					liberaTeclas();

				}

				if (cenario == null) {
					g2d.setColor(Color.WHITE);
					g2d.drawString("O Cenário é uma ilusão...", 20, 20);

				} else {
					if (!Jogo.pausado)
						cenario.atualizar();

					cenario.desenhar(g2d);

					if (Jogo.pausado) {
						g2d.setColor(Color.WHITE);
						g2d.drawString("Pausado", (tela.getWidth()) / 2 - 4, tela.getHeight() / 2);
					}
				}
				// aparentemente deu certo.
				if (!JogoCenario.nome_rank.equals("")){

					classificacao.addJogador(JogoCenario.nome_rank, JogoCenario.pontos);
					classificacao.ordenar();  //ordeno o arraylist

					if(!arquivo.canRead()){
						System.out.println("O arquivo não pode ser lido");
					}else{
						try (FileWriter escritor = new FileWriter(arquivo, false)) { // o append(segundo argumento) diz se é para adicionar ou sobrescrever.
							for(int i = 0; i < classificacao.getTamanho(); i++){
								Jogador dadosJogador = classificacao.getJogador(i);
								String cadeia = dadosJogador.getNome() + ' ' + dadosJogador.getPontuacao();
								escritor.write(cadeia + "\n");
							}
						} catch (IOException e){
							e.printStackTrace();
						}	
					}
					
					//classificacao.imprimeRanking();
					JogoCenario.nome_rank = "";
				}
				
				tela.repaint();
				prxAtualizacao = System.currentTimeMillis() + FPS;
			}
		}
	}

	public static void main(String[] args) throws IOException{
		Jogo jogo = new Jogo();
		// começou a execução, eu venho com a leitura do arquivo.
		try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
    
            String linha;

            while ((linha = leitor.readLine()) != null) {
                String dadosJogador[] = linha.split(" ");
                
                classificacao.addJogador(dadosJogador[0], Integer.parseInt(dadosJogador[1]));
            }
        }

		jogo.carregarJogo();
		jogo.iniciarJogo();
	}

}
