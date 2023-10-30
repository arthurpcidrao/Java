import java.util.Scanner;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Tabela tabela = new Tabela();

        int num = input.nextInt();
        for (int i = 0; i < num; i++){
            tabela.addPais(input.next(), input.nextInt(), input.nextInt(), input.nextInt());
        }
        tabela.ordenarTabela();
        tabela.imprimeTabela();

        input.close();
    }
}

class Paises implements Comparable<Paises> {
    private String nome;
    private int ouro;
    private int prata;
    private int bronze;

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getOuro(){
        return ouro;
    }

    public void setOuro(int ouro){
        this.ouro = ouro;
    }

    public int getPrata(){
        return prata;
    }

    public void setPrata(int prata){
        this.prata = prata;
    }

    public int getBronze(){
        return bronze;
    }

    public void setBronze(int bronze){
        this.bronze = bronze;
    }

    public void imprimeMedalhas(){
        System.out.printf("%s %d %d %d\n", getNome(), getOuro(), getPrata(), getBronze());
    }

    @Override
    public int compareTo(Paises outroPais){
        int sub = -(this.ouro - outroPais.getOuro());
        if (sub == 0){
            sub = -(this.prata - outroPais.getPrata());
            if (sub == 0){
                sub = -(this.bronze - outroPais.getBronze());
                if (sub == 0){
                    sub = this.nome.compareTo(outroPais.getNome());
                }
            }
        }
        return sub;
    }
}

class Tabela {
    private ArrayList<Paises> tabela = new ArrayList<Paises>();
    

    public void addPais(String nome, int ouro, int prata, int bronze){
        Paises pais = new Paises();
        pais.setNome(nome);
        pais.setOuro(ouro);
        pais.setPrata(prata);
        pais.setBronze(bronze);

        tabela.add(pais);
    }

    public void ordenarTabela(){
        Collections.sort(tabela);
    }

    public void imprimeTabela(){
        for (Paises p : tabela){
            p.imprimeMedalhas();
        }
    }
}


