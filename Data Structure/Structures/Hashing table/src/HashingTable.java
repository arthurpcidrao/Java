public class HashingTable<T extends Comparable<T>> {
    
    private SortedPointers<String> array[];
    private int size;
    private int elements;

// para deixar mais geral, podemos colocar uma classe com um nome, um id crescente e algum outro dados.
// caso um nome repetido seja colocado, podemos não inserir na tabela.

    @SuppressWarnings("unchecked")
    public HashingTable(int length){
        this.array = new SortedPointers[length];
        this.size = 0;
        this.elements = 0;
    }


    private int hashingFunction(String element){
        //pegando a primeira letra correspondente na tabela ascii
        char firstChar = element.charAt(0);
        int asciiValue = firstChar;

        //caso queira colocar números, faça:
        //int value = Integer.parseInt(element);

        return asciiValue % this.array.length;
    }


    public void add(String element){
        int rest = hashingFunction(element);

        if (this.array[rest] == null){
            this.array[rest] = new SortedPointers<>();
            this.size++;
        }

        this.array[rest].add(element);
        this.elements++;
    }


    public int howMany(int i){
        return this.array[i].size();
    }


    public String remove(String element){
        int rest = hashingFunction(element);

        if (this.array[rest] == null){
            return null;
        }
        
        return this.array[rest].remove(element);
    }


    public void show(){
        for (int i = 0; i < this.array.length; i++){
            if (this.array[i] != null){
                System.out.print((i+1) + "°: ");
                this.array[i].print();
            }
        }
    }
}
