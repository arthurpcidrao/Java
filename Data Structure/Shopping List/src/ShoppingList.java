public class ShoppingList {
    
    private SortedPointers<Objects> list = new SortedPointers<>();

    public void add(String name){
        Objects object = new Objects(name);
        if (!list.exists(object)){
            list.add(object);
        }
    }

    public void print(){

        for (int i = 0; i < list.size(); i++){
            if (i == list.size() - 1){
                System.out.println(list.getUnit(i).getObject());
            }
            else{
                System.out.print(list.getUnit(i).getObject() + " ");
            }
        }
    }
}
