public class Wallet {
    private Array<Pomekon> pomekons = new Array<>();

    public void add(String name){
        Pomekon pomekon = new Pomekon(name);
        if(!(pomekons.exists(pomekon))){
            pomekons.add(pomekon);
        }
    }

    public void result(){
        System.out.println("Falta(m) " + (151 - pomekons.size()) + " pomekon(s).");
    }

    public void print(){
        for (int i = 0; i < pomekons.size(); i++){
            System.out.println(pomekons.getUnit(i).getName());
        }
        
    }

}
