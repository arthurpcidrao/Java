public class Lista {
    private SortedPointers<Name> list = new SortedPointers<>();

    public void add(String personName){
        Name name = new Name(personName);
        list.add(name);
    }

    public void print(){
        System.out.println();
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.getUnit(i).getName());
        }
    }

    public void result(){
        
        SortedPointers<Name> line = new SortedPointers<>();
        
        int num = list.size();
        while(num > 0){
    
            for (int i = 2; i <=19; i++){
                for (int j = 0; j < list.size(); j++){
                    if (list.getUnit(j).getSize() == i){
                        Name nome = new Name(list.getUnit(j).getName());
                        line.add(nome);
                        list.getUnit(j).setName("");
                        num--;
                        break;
                    }
                }
            }
            
            for (int i = 0; i < line.size(); i++){
                if (i == line.size() - 1){
                    System.out.println(line.getUnit(i).getName());
                }
                else{
                    System.out.print(line.getUnit(i).getName() + ", ");
                }
            }
            line.clear();
        }
    }
}
