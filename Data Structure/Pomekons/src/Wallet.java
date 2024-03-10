public class Wallet {
    private int qtd;
    private Array<Pomekon> pomekons = new Array<>();


    public int getQtd(){
        return this.qtd;
    }

    public void setQtd(int qtd){
        this.qtd = qtd;
    }

    public void add(String name){
        Pomekon pomekon = new Pomekon(name);
        if(!(pomekons.exists(pomekon))){
            pomekons.add(pomekon);
        }
    }

    public void print(){
        for (int i = 0; i < pomekons.size(); i++){
            System.out.println(pomekons.getUnit(i).getName());
        }
        
    }

}
