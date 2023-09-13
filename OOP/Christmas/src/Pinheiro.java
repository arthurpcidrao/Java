public class Pinheiro {
    private int altura;
    private int largura;
    private int galhos;

    public int getAltura(){
        return altura;
    }

    public void setAltura( int altura){
        this.altura = altura;
    }

    public int getLargura(){
        return largura;
    }

    public void setLargura(int largura){
        this.largura = largura;
    }

    public int getGalhos(){
        return galhos;
    }

    public void setGalhos(int galhos){
        this.galhos = galhos;
    }

    public String verifica(){
        String result = "Sim";
        if (this.altura < 200 || this.altura > 300){
            result = "Nao";
        }

        if (this.largura < 50){
            result = "Nao";
        }

        if (this.galhos < 150){
            result = "Nao";
        }

        return result;
    }
}
