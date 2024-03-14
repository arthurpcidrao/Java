public class Table {
    private SortedPointers<Country> list = new SortedPointers<>();

    public void add(String countryName, int countryGold, int countrySilver, int countryBronze){
        
        Country country = new Country(countryName, countryGold, countrySilver, countryBronze);
        list.add(country);
    }

    public void result(){
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.getUnit(i).getName() + " " + list.getUnit(i).getGold() + " " + list.getUnit(i).getSilver() + " " + list.getUnit(i).getBronze());
        }
    }
}
