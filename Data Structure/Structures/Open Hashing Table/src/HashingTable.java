import java.util.Objects;

public class HashingTable {
    
    private Integer table[];
    private int size;

    public HashingTable(int len){
        table = new Integer[len];
        this.size = 0;
    }


    private int hashingFunction(int element){
        //pegando a primeira letra correspondente na tabela ascii
        
        //char firstChar = element.charAt(0);
        //int asciiValue = firstChar;

        //caso queira colocar números, faça:
        //int value = Integer.parseInt(element);

        return element % this.table.length;
    }

    public void add(int element){
        if (this.size < table.length){
            int i = hashingFunction(element);

            while (table[i] != null){
                i++;
                i = i % table.length;
            }
            table[i] = element;
            this.size++;
        }
    }

    public int remove(Integer element){

        Integer removed = null;

        if (this.size > 0){
            int count = 0;
            int i = hashingFunction(element);
            while(!Objects.equals(table[i], element) && count < table.length){
                i++;
                i = i % table.length;
                count++;
            }
            removed = table[i];
            table[i] = null;
            this.size--;
        }

        return removed;
    }


    public void print(){
        System.out.print("[");
        for (int i = 0; i < table.length - 1; i++){
            System.out.print(table[i] + ", ");
        }
        System.out.println(table[table.length - 1] + "]");
    }
}
