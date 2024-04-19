public class House {
    
    private int residents;
    private int consumption;

    public House(int residents, int consumption){
        this.residents = residents;
        this.consumption = consumption;
    }

    public int getResidents(){
        return this.residents;
    }

    public void setResidents(int residents){
        this.residents = residents;
    }

    public int getConsumption(){
        return this.consumption;
    }

    public void setConsumption(int consumption){
        this.consumption = consumption;
    }
}
