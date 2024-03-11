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

    public void result(){ // verificar esse método

        int len = list.size();
        int num = 0;
        while(num <= len){
        
            int tam = 2;
            for (int i = tam; i <= 19; i++){
                int j = 0;
                while(j < list.size()){

                    if (list.getUnit(j).getSize() == i){
                        System.out.print(list.getUnit(j).getName() + ", ");
                        list.remove(list.getUnit(j));
                        num++;
                        break;
                    }
                    j++;
                }
            }
            System.out.println();
        }
    }
}
