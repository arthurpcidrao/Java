import java.util.Scanner;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        while(input.hasNext()){
            int num = input.nextInt();

            Genero genero = new Genero();

            for(int i = 0; i < num; i++){
                genero.addLivro(input.next());
            }
            genero.ordenaLivros();

            biblioteca.addGenero(genero);
        }

        biblioteca.imprimeBiblioteca();

        input.close();
    }
}

class Books implements Comparable<Books>{
    private String codigo;

    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public void imprimeLivro(){
        System.out.println(getCodigo());
    }

    @Override
    public int compareTo(Books outroLivro){
        int compCod = this.codigo.compareTo(outroLivro.getCodigo());
        return compCod;
    }

}

class Genero {
    private ArrayList<Books> livros = new ArrayList<Books>();

    public void addLivro(String codigo){
        Books livro = new Books();
        livro.setCodigo(codigo);

        livros.add(livro);
    }

    public void ordenaLivros(){
        Collections.sort(livros);
    }

    public void imprimeGenero(){
        for (Books b : livros){
            b.imprimeLivro();
        }
    }
}

class Biblioteca {
    private ArrayList<Genero> biblioteca = new ArrayList<Genero>();

    public void addGenero(Genero genero){
        biblioteca.add(genero);
    }

    public void imprimeBiblioteca(){
        for (Genero g : biblioteca){
            g.imprimeGenero();
        }
    }

}
