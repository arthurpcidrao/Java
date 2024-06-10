import java.io.*;

public class Arquivos_L_G {

    public void lerArquivo(File txt, Fila fila) throws Exception {
        BufferedReader aq = new BufferedReader(new FileReader(txt));

        int[] contagemCaracteres = new int[256];
        int caractere;

        while ((caractere = aq.read()) != -1) {
            if (caractere < 256) {
                contagemCaracteres[caractere]++;
            }
        }
        aq.close();

        for (int i = 0; i < contagemCaracteres.length; i++) {
            if (contagemCaracteres[i] > 0) {
                fila.adicionar((char) i, contagemCaracteres[i]);
            }
        }
    }

    public void comprimirArquivo(File arquivoOriginal, File arquivoComprimido, Arvore arvore) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(arquivoOriginal));
        StringBuilder texto = new StringBuilder();

        int caractere;
        while ((caractere = reader.read()) != -1) {
            texto.append((char) caractere);
        }
        reader.close();

        StringBuilder textoComprimido = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char ch = texto.charAt(i);
            textoComprimido.append(arvore.getCodigo(ch));
        }


        String arvoreCodificada = arvore.codigo_arvore(arvore.getRaiz());
        String conteudoComprimido = arvoreCodificada + textoComprimido.toString();


        BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoComprimido));
        writer.write(conteudoComprimido);
        writer.close();
    }

    public void descomprimirArquivo(File arquivoComprimido, File arquivoDescomprimido) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(arquivoComprimido));
        StringBuilder conteudoComprimido = new StringBuilder();

        int caractere;
        while ((caractere = reader.read()) != -1) {
            conteudoComprimido.append((char) caractere);
        }
        reader.close();


        String conteudo = conteudoComprimido.toString();
        int[] indice = {0};
        No raiz = Arvore.reconstruirArvore(conteudo, indice);
        String mensagemComprimida = conteudo.substring(indice[0]);


        String mensagemDecodificada = Arvore.decodificarMensagem(mensagemComprimida, raiz);


        BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoDescomprimido));
        writer.write(mensagemDecodificada);
        writer.close();
    }
}