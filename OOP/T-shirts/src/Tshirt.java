public class Tshirt implements Comparable<Tshirt>{
    private String cor;
    private String tamanho;
    private String nome;

    public String getCor(){
        return cor;
    }

    public void setCor(String cor){
        this.cor = cor;
    }

    public String getTamanho(){
        return tamanho;
    }

    public void setTamanho(String tamanho){
        this.tamanho = tamanho;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void printCamisa(){
        System.out.printf("%s%s %s\n", getCor(), getTamanho(), getNome());
    }

    @Override
    public int compareTo(Tshirt outraCamisa){
        int compCor = this.cor.compareTo(outraCamisa.getCor());
        
        if (compCor == 0){
            int compTam = outraCamisa.tamanho.compareTo(this.tamanho);

            if (compTam == 0){
                int compNome = this.nome.compareTo(outraCamisa.getNome());
                return compNome;
            }
            return compTam;
        }
        return compCor;
    }    
}
