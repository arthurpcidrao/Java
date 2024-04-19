public class Country implements Comparable<Country>{
    
    private String name;
    private int gold;
    private int silver;
    private int bronze;

    public Country(String name, int gold, int silver, int bronze){
        this.name = name;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    public String getName(){
        return this.name;
    }

    public int getGold(){
        return this.gold;
    }

    public int getSilver(){
        return this.silver;
    }

    public int getBronze(){
        return this.bronze;
    }

    @Override
    public int compareTo(Country other) {

        int order = -(this.gold - other.gold);

        if (order == 0){
            order = -(this.silver - other.silver);

            if (order == 0){
                order = -(this.bronze - other.bronze);

                if (order == 0){
                    order = this.name.compareTo(other.name);
                }
            }
        }
        
        return order;
    }
}
