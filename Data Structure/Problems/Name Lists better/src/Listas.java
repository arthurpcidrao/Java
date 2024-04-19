public class Listas {
    
    @SuppressWarnings("rawtypes")
    private Array<SortedPointers> list = new Array<>();

    @SuppressWarnings({ "unchecked"})
    public void add(String stringName){
        
        Name name = new Name(stringName);
        
        boolean state = true;
        while(state){

            list.add(new SortedPointers<>());

            for (int i = 0; i < list.size(); i++){
                if(!list.getUnit(i).exists(name)){
                    list.getUnit(i).add(name);

                    state = false;
                    break;
                }
            }
        }
    }

    public void result(){
        for(int i = 0; i < list.size(); i++){
            for (int j = 0; j < list.getUnit(i).size(); j++){
                if(j == list.getUnit(i).size() - 1){
                    System.out.print(((Name) list.getUnit(i).getUnit(j)).getName());        
                }
                else{
                    System.out.print(((Name) list.getUnit(i).getUnit(j)).getName() + ", ");    
                }
            }
            if (list.getUnit(i).size() > 0){
                System.out.println();
            }
            
        }
    }
}
