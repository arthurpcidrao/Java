import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.util.Random;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.AudioFileFormat.Type;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class JogoCenario extends CenarioPadrao {

	enum Estado {
		JOGANDO, PERDEU
	}

	private static final int ESPACAMENTO = 2;

	private static final int ESPACO_VAZIO = -1;

	private static final int LINHA_COMPLETA = -2;

	private int largBloco, altBloco; // largura bloco e altura bloco

	private int ppx, ppy; // Posicao peca x e y

	private final int[][] grade = new int[10][16];

	private int temporizador = 0;  // TEMPO DE DESCIDA. Quando chega em 20, zera. nível 1, cresce de 1 em 1, nível 2 cresce de 2 em 2.

	private Texto texto = new Texto(20);

	private Random rand = new Random();

	//private Ranking classificacao = new Ranking();
	public static String nome_rank = "";  // era PRIVATE e SEM static

	private int desceY = 25;

	private int idPeca = -1;
	private int idPrxPeca = -1;
	private int idPrxPeca2 = -1;
	private int idPrxPeca3 = -1;
	private Color corPeca;
	private int[][] peca;

	private int estPecas[] = new int[7];
	private int nivel = Jogo.nivel;
	public static int pontos;  //era PRIVATE e SEM static
	private int linhasFeitas;

	private boolean animar;
	private boolean depurar = false;  // variável de teste

	private Estado estado = Estado.JOGANDO;
	private boolean colocouNome = false;
	private int comecoX = 250;  // serve para colocar o jogo onde eu quero que comece

	// Som
	private AudioInputStream as;
	private Clip clipAdicionarPeca;
	private Clip clipMarcarLinha;
	private Clip clipGameOver;
	private Clip clipViraPeca;
	private Clip clipDesceTudo;
	private Sequencer seqSomDeFundo;

	public JogoCenario(int largura, int altura) {
		super(largura - 500, altura);  // a sacada da tela normal é aqui junto com a variável "comecoX"
	}

	@Override
	public void carregar() {
		largBloco = largura / grade.length;  // definição da largura do bloco
		altBloco = altura / grade[0].length;  // definição da altura do bloco

		// preenchendo a grade do jogo com espaços vazios
		for (int i = 0; i < grade.length; i++) {
			for (int j = 0; j < grade[0].length; j++) {
				grade[i][j] = ESPACO_VAZIO;
			}
		}
		//------------------------------ MÚSICAS DO JOGO ------------------------------//
		Type[] audioFileTypes = AudioSystem.getAudioFileTypes();
		for (Type t : audioFileTypes) {
			System.out.println(t.getExtension());
		}

		try {
			as = AudioSystem.getAudioInputStream(new File("som/adicionaPeca.wav"));
			clipAdicionarPeca = AudioSystem.getClip();
			clipAdicionarPeca.open(as);

			as = AudioSystem.getAudioInputStream(new File("som/desceTudo.wav"));
			clipDesceTudo = AudioSystem.getClip();
			clipDesceTudo.open(as);

			as = AudioSystem.getAudioInputStream(new File("som/viraPeca.wav"));
			clipViraPeca = AudioSystem.getClip();
			clipViraPeca.open(as);

			as = AudioSystem.getAudioInputStream(new File("som/game_over.wav"));
			clipGameOver = AudioSystem.getClip();
			clipGameOver.open(as);

			as = AudioSystem.getAudioInputStream(new File("som/marcaLinha.wav"));
			clipMarcarLinha = AudioSystem.getClip();
			clipMarcarLinha.open(as);

			seqSomDeFundo = MidiSystem.getSequencer();
			seqSomDeFundo.setSequence(MidiSystem.getSequence(new File("som/somFundo.mid")));
			seqSomDeFundo.open();

			seqSomDeFundo.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);

			seqSomDeFundo.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
		//-----------------------------------------------------------------------------//

		adicionaPeca();  // função para adição de uma nova peça.
	}

	@Override
	public void descarregar() {
		//------------------------------ MÚSICAS DO JOGO ------------------------------//
		if (clipAdicionarPeca != null) {
			clipAdicionarPeca.stop();
			clipAdicionarPeca.close();
		}

		if (clipViraPeca != null) {
			clipViraPeca.stop();
			clipViraPeca.close();
		}

		if (clipMarcarLinha != null) {
			clipMarcarLinha.stop();
			clipMarcarLinha.close();
		}

		if (seqSomDeFundo != null) {
			seqSomDeFundo.stop();
			seqSomDeFundo.close();
		}

		if (clipGameOver != null) {
			clipGameOver.stop();
			clipGameOver.close();
		}

		if (clipDesceTudo != null) {
			clipDesceTudo.stop();
			clipDesceTudo.close();
		}

		//-----------------------------------------------------------------------------//
	}

	@Override
	public void atualizar() {

		if (estado != Estado.JOGANDO) {
			return;
		}

		//-------- Quando botão é apertado, verifica possibilidade do movimento --------//
		if (Jogo.controleTecla[Jogo.Tecla.ESQUERDA.ordinal()]) {
			if (validaMovimento(peca, ppx - 1, ppy))
				ppx--;

		} else if (Jogo.controleTecla[Jogo.Tecla.DIREITA.ordinal()]) {
			if (validaMovimento(peca, ppx + 1, ppy))
				ppx++;
		}

		if (Jogo.controleTecla[Jogo.Tecla.CIMA.ordinal()]) {
			girarReposicionarPeca(true);
			
			if (clipViraPeca != null) {
				clipViraPeca.setFramePosition(0);
				clipViraPeca.start();
				}

		} else if (Jogo.controleTecla[Jogo.Tecla.Z.ordinal()]){
			girarReposicionarPeca(false);
			clipViraPeca.start();

			if (clipViraPeca != null) {
				clipViraPeca.setFramePosition(0);
				clipViraPeca.start();
				}
		}
		
		if (Jogo.controleTecla[Jogo.Tecla.BAIXO.ordinal()]) {
			if (validaMovimento(peca, ppx, ppy + 1)){
				ppy++;
				pontos++;
				//System.out.printf("*Pontos = %d*\n", pontos);
			}

		} else if (Jogo.controleTecla[Jogo.Tecla.ESPACO.ordinal()]){

			if (validaMovimento(peca, ppx, ppy)){
				for (int y = 0; y < 16; y++){

					if(!colidiu(ppx, ppy + 1)){
						ppy++;
						pontos += 2;
					}
				}
			}
			if (clipDesceTudo != null) {
				clipDesceTudo.setFramePosition(0);
				clipDesceTudo.start();
				}

		}

		if (depurar && Jogo.controleTecla[Jogo.Tecla.W.ordinal()]) {
			if (++idPeca == Peca.PECAS.length)
				idPeca = 0;

			peca = Peca.PECAS[idPeca];
			corPeca = Peca.Cores[idPeca];
		}

		Jogo.liberaTeclas();

		//System.out.println(temporizador);

		if (animar && temporizador >= 5) {
			animar = false;

			descerColunas();  // reorganiza a grade quando uma linha fica completa
			adicionaPeca();

		} else if (temporizador >= 20) {  // o valor 20 vem de 1000/20 FPS
			temporizador = 0;
			//System.out.println("ciclo completo\n");

			if (colidiu(ppx, ppy + 1)) {

				if (clipAdicionarPeca != null) {
					clipAdicionarPeca.setFramePosition(0);
					clipAdicionarPeca.start();
				}

				if (!parouForaDaGrade()) {
					adicionarPecaNaGrade();
					animar = marcarLinha();// quando uma linha é totalmente preenchida, essa linha desaparece e todas as linhas de cima descem.

					peca = null;

					if (!animar){
						adicionaPeca();
					}

				} else {
					estado = Estado.PERDEU;
					if (seqSomDeFundo != null) {
						seqSomDeFundo.stop();
						clipGameOver.start();
					}


				}

			} else
				ppy++;

		} else
			temporizador += nivel;

	}

	public void adicionaPeca() {

		ppy = -2;
		ppx = grade.length / 2 - 1;

		// Primeira chamada
		if (idPeca == -1){
			idPeca = rand.nextInt(Peca.PECAS.length);
			idPrxPeca = rand.nextInt(Peca.PECAS.length);
			idPrxPeca2 = rand.nextInt(Peca.PECAS.length);
		}
		else{
			idPeca = idPrxPeca;  // original
			idPrxPeca = idPrxPeca2;
			idPrxPeca2 = idPrxPeca3;
		}
		idPrxPeca3 = rand.nextInt(Peca.PECAS.length);
		
		// Isso acontece muito
		if (idPeca == idPrxPeca){
			idPrxPeca = rand.nextInt(Peca.PECAS.length);
		}
		if (idPrxPeca == idPrxPeca2){
			idPrxPeca2 = rand.nextInt(Peca.PECAS.length);
		}
		if (idPrxPeca2 == idPrxPeca3){
			idPrxPeca3 = rand.nextInt(Peca.PECAS.length);
		}


		// ESTATÍSTICA DAS PEÇAS ABAIXO:
		estPecas[idPeca]++;

		peca = Peca.PECAS[idPeca];
		corPeca = Peca.Cores[idPeca];

	}

	private void adicionarPecaNaGrade() {

		for (int col = 0; col < peca.length; col++) {
			for (int lin = 0; lin < peca[col].length; lin++) {

				if (peca[lin][col] != 0) {

					grade[col + ppx][lin + ppy] = idPeca;

				}
			}
		}
	}

	private boolean validaMovimento(int[][] peca, int px, int py) {

		if (peca == null)
			return false;

		for (int col = 0; col < peca.length; col++) {
			for (int lin = 0; lin < peca[col].length; lin++) {
				if (peca[lin][col] == 0)
					continue;

				int prxPx = col + px; // Proxima posicao peca x
				int prxPy = lin + py; // Proxima posicao peca y

				if (prxPx < 0 || prxPx >= grade.length)
					return false;

				if (prxPy >= grade[0].length)
					return false;

				if (prxPy < 0)
					continue;

				// Colidiu com uma peca na grade
				if (grade[prxPx][prxPy] > ESPACO_VAZIO)
					return false;

			}
		}

		return true;
	}

	private boolean parouForaDaGrade() {  // Se sim (parou fora da grade), significa que você perdeu!

		if (peca == null)
			return false;

		for (int lin = 0; lin < peca.length; lin++) {
			for (int col = 0; col < peca[lin].length; col++) {
				if (peca[lin][col] == 0)
					continue;
				// Fora da grade
				if (lin + ppy < 0)
					return true;
			}
		}

		return false;
	}

	private boolean colidiu(int px, int py) {

		if (peca == null)
			return false;

		for (int col = 0; col < peca.length; col++) {
			for (int lin = 0; lin < peca[col].length; lin++) {
				if (peca[lin][col] == 0)
					continue;

				int prxPx = col + px;
				int prxPy = lin + py;

				if (depurar) {
					if (prxPx < 0 || prxPx >= grade.length)
						return false;
				}
				// Chegou na base da grade
				if (prxPy == grade[0].length)
					return true;

				// Fora da grade
				if (prxPy < 0)
					continue;

				// Colidiu com uma peca na grade
				if (grade[prxPx][prxPy] > ESPACO_VAZIO)
					return true;
			}
		}

		return false;
	}

	private boolean marcarLinha() { // elimina linhas completadas e faz a marcação de pontos
		int multPontos = 0;
		int pontoExtra = 0;

		for (int lin = grade[0].length - 1; lin >= 0; lin--) {
			boolean linhaCompleta = true;

			for (int col = grade.length - 1; col >= 0; col--) {
				if (grade[col][lin] == ESPACO_VAZIO) {
					linhaCompleta = false;
					break;
				}
			}

			if (linhaCompleta) {
				multPontos++;
				for (int col = grade.length - 1; col >= 0; col--) {
					grade[col][lin] = LINHA_COMPLETA;
				}
			}
		}
		if(multPontos == 4){
			pontoExtra = 100;
		}
		if (multPontos > 0){
			pontos += (100 + 200*(multPontos - 1) + pontoExtra)*nivel; // pontuação atualizada
			linhasFeitas += multPontos;
		}
		

		if (linhasFeitas >= 9) { // ORIGINAL É 9... voltar pra 9
			nivel++;
			linhasFeitas = 0;
		}
		//System.out.printf("pontos = %d \nmultpontos = %d\n\n", pontos, multPontos);

		return multPontos > 0;
	}

	private void descerColunas() {
		for (int col = 0; col < grade.length; col++) {
			for (int lin = grade[0].length - 1; lin >= 0; lin--) {

				if (grade[col][lin] == LINHA_COMPLETA) {
					int moverPara = lin;
					int prxLinha = lin - 1;

					for (; prxLinha > -1; prxLinha--) {
						if (grade[col][prxLinha] == LINHA_COMPLETA)
							continue;
						else
							break;

					}

					for (; moverPara > -1; moverPara--, prxLinha--) {

						if (prxLinha > -1)
							grade[col][moverPara] = grade[col][prxLinha];
						else
							grade[col][moverPara] = ESPACO_VAZIO;

					}
				}
			}
		}

		if (clipMarcarLinha != null) {
			clipMarcarLinha.setFramePosition(0);
			clipMarcarLinha.start();
		}

	}

	protected void girarPeca(boolean sentidoHorario) {
		if (peca == null)
			return;

		final int[][] temp = new int[peca.length][peca.length];

		for (int i = 0; i < peca.length; i++) {
			for (int j = 0; j < peca.length; j++) {
				if (sentidoHorario)
					temp[j][peca.length - i - 1] = peca[i][j];
				else
					temp[peca.length - j - 1][i] = peca[i][j];
			}
		}

		System.out.println("Antes:");
		imprimirArray(peca);
		System.out.println("Depois:");
		imprimirArray(temp);

		if (validaMovimento(temp, ppx, ppy)) {
			peca = temp;
		}
	}

	private void imprimirArray(int[][] arr) {
		for (int lin = 0; lin < arr.length; lin++) {
			for (int col = 0; col < arr[lin].length; col++) {
				System.out.print(arr[lin][col] + "\t");
			}

			System.out.println();
		}
	}

	private void girarReposicionarPeca(boolean sentidoHorario) {
		if (peca == null)
			return;

		int tempPx = ppx;
		final int[][] tempPeca = new int[peca.length][peca.length];

		for (int i = 0; i < peca.length; i++) {
			for (int j = 0; j < peca.length; j++) {
				if (sentidoHorario)
					tempPeca[j][peca.length - i - 1] = peca[i][j];
				else
					tempPeca[peca.length - j - 1][i] = peca[i][j];
			}
		}

		// Reposiciona peca na tela
		for (int i = 0; i < tempPeca.length; i++) {
			for (int j = 0; j < tempPeca.length; j++) {
				if (tempPeca[j][i] == 0) {
					continue;
				}

				int prxPx = i + tempPx;

				if (prxPx < 0)
					tempPx = tempPx - prxPx;

				else if (prxPx == grade.length)
					tempPx = tempPx - 1;

			}
		}

		if (validaMovimento(tempPeca, tempPx, ppy)) {
			peca = tempPeca;
			ppx = tempPx;
		}
	}

	@Override
	public void desenhar(Graphics2D g) {

		// ---------------- LINHAS DELIMITADORAS ---------------- //
		g.setColor(Color.PINK);
		g.drawLine(comecoX, 0, comecoX, altura);
		g.drawLine(comecoX+largura, 0, comecoX+largura, altura);
		g.drawRect(comecoX + largura + 5, 20, 87, 110);


		for (int col = 0; col < grade.length; col++) {
			for (int lin = 0; lin < grade[0].length; lin++) {
				int valor = grade[col][lin];

				if (valor == ESPACO_VAZIO){
					g.setColor(Color.BLACK);
					//g.fillRect(col*largBloco, lin*altBloco, largBloco, altBloco);
					continue;
				}
				if (valor == LINHA_COMPLETA){
					g.setColor(Color.RED);
				}
				else{
					g.setColor(Peca.Cores[valor]);
				}

				int x = comecoX + col * largBloco + ESPACAMENTO;
				int y = lin * altBloco + ESPACAMENTO;

				g.fillRect(x, y, largBloco - ESPACAMENTO, altBloco - ESPACAMENTO);

			}
		}

		if (peca != null) {
			g.setColor(corPeca);

			for (int col = 0; col < peca.length; col++) {
				for (int lin = 0; lin < peca[col].length; lin++) {
					if (peca[lin][col] != 0) {

						int x = comecoX + (col + ppx) * largBloco + ESPACAMENTO;
						int y = (lin + ppy) * altBloco + ESPACAMENTO;

						g.fillRect(x, y, largBloco - ESPACAMENTO, altBloco - ESPACAMENTO);

					} else if (depurar) {
						g.setColor(Color.PINK);
						int x = comecoX + (col + ppx) * largBloco + ESPACAMENTO;
						int y = (lin + ppy) * altBloco + ESPACAMENTO;

						g.fillRect(x, y, largBloco - ESPACAMENTO, altBloco - ESPACAMENTO);

						g.setColor(corPeca);
					}
				}
			}
		}

		// desenha peças localizadas na parte direita da janela (próximas peças)
		desenhaPeca(2, Peca.PECAS[idPrxPeca], idPrxPeca, g, 10, 25, comecoX+largura);
		desenhaPeca(4, Peca.PECAS[idPrxPeca2], idPrxPeca2, g, 100, 50, comecoX+largura);
		desenhaPeca(4 , Peca.PECAS[idPrxPeca3], idPrxPeca3, g, 150, 50, comecoX+largura);
		
		//Criei função para não precisar repetir várias vezes a mesma coisa
		// desenha peças localizadas na parte esquerda da janela (estatística das peças)
		desenhaPeca(4, Peca.PECAS[0], 0, g, 50, 200, 0);
		desenhaPeca(4, Peca.PECAS[1], 1, g, 50, 260, 0);
		desenhaPeca(4, Peca.PECAS[2], 2, g, 50, 320, 0);
		desenhaPeca(4, Peca.PECAS[3], 3, g, 50, 380, 0);
		desenhaPeca(4, Peca.PECAS[4], 4, g, 50, 440, 0);
		desenhaPeca(4, Peca.PECAS[5], 5, g, 50, 500, 0);
		desenhaPeca(4, Peca.PECAS[6], 6, g, 50, 560, 0);
		
		texto.setCor(Color.WHITE);
		texto.desenha(g, "  :   " + estPecas[0], 90, 225);
		texto.desenha(g, "  :   " + estPecas[1], 90, 285);
		texto.desenha(g, "  :   " + estPecas[2], 90, 345);
		texto.desenha(g, "  :   " + estPecas[3], 90, 405);
		texto.desenha(g, "  :   " + estPecas[4], 90, 465);
		texto.desenha(g, "  :   " + estPecas[5], 90, 525);
		texto.desenha(g, "  :   " + estPecas[6], 90, 585);

		texto.setCor(Color.WHITE);
		texto.desenha(g, "Level:     " + nivel, (comecoX/5), 50);
		texto.desenha(g, "Linhas:   " + linhasFeitas, (comecoX/5), 80);
		texto.desenha(g, "Pontos:   " + String.valueOf(pontos), (comecoX/5), 110);


		if (estado != Estado.JOGANDO) {
			texto.setCor(Color.WHITE);

			if (estado == Estado.PERDEU){
				texto.setCor(Color.GRAY);
				texto.desenha(g, "Deu ruim!", comecoX+215, 250);
				
				if (!colocouNome){

					nome_rank = JOptionPane.showInputDialog("Digite seu nome");

					JOptionPane.showMessageDialog(null, nome_rank + ", você fez  " + pontos + " pontos", "Jogo concluído", JOptionPane.PLAIN_MESSAGE);
					colocouNome = true;
				}
			}
		}


		texto.desenha(g, "||--------- Ranking ---------||", 755, 205);
		texto.setCor(Color.WHITE);

		for (int i = 0; i < 10; i++){
			if (Jogo.classificacao.getTamanho() >= i + 1){
				imprimePosicoes(i, g);
			}
		}
		texto.desenha(g, "||------------------------------||", 755, 490);
		texto.desenha(g, "Aperte ESC para retornar", 760, 600);
	}


	public void desenhaPeca(int escala, int[][] blocoP, int id, Graphics2D g, int ajusteX, int ajusteY, int comeca) {

		int miniatura = largBloco / escala;
		blocoP = Peca.PECAS[id];
		g.setColor(Peca.Cores[id]);

		for (int col = 0; col < blocoP.length; col++) {
			for (int lin = 0; lin < blocoP[col].length; lin++) {
				if (blocoP[lin][col] == 0)
					continue;

				int x = comeca + col * miniatura + ESPACAMENTO;
				int y = lin * miniatura + ESPACAMENTO;

				g.fillRect(x + ajusteX, y + ajusteY, miniatura - ESPACAMENTO, miniatura - ESPACAMENTO);

			}
		}
	}


	public void imprimePosicoes(int index, Graphics2D g){
		Jogador jog_rank = Jogo.classificacao.getJogador(index);
		texto.desenha(g, index+1 + "  -  " + jog_rank.getNome() + "   " + jog_rank.getPontuacao(), 758, 210 + (index+1)*desceY);
	}
}
