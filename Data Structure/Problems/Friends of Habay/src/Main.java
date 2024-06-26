import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Lista afirmList = new Lista();
        NegLista negList = new NegLista();

        String line = input.nextLine();
        while(!line.equals("FIM")){
            String word[] = line.split(" ");

            if (word[1].equals("YES")){
                afirmList.add(word[0]);
            }
            else{
                negList.add(word[0]);
            }
            line = input.nextLine();
        }
        input.close();

        afirmList.result();
        negList.result();
        afirmList.choice();

    }
}

class Lista {

    private SortedPointers<Registration> yesList = new SortedPointers<>();
    @SuppressWarnings("rawtypes")
    private Node maiorNome;

    public void add(String oneName){
        Registration name = new Registration(oneName);

        if(!yesList.exists(name)){
            yesList.add(name);

            if (yesList.size() == 1){
                maiorNome = yesList.getMemory(name);
            }
            else if(name.getSize() > yesList.getData(maiorNome).getSize()){
                maiorNome = yesList.getMemory(name);
            }
        }
    }

    public void result(){
        for (int i = 0; i < yesList.size(); i++){
            System.out.println(yesList.getUnit(i).getName());
        }
    }

    public void choice(){
        System.out.println();
        System.out.println("Amigo do Habay:");
        System.out.println(yesList.getData(maiorNome).getName());
    }

}

class NegLista {

    private SortedPointers<Registration> noList = new SortedPointers<>();

    public void add(String oneName){
        Registration name = new Registration(oneName);

        if (!noList.exists(name)){
            noList.add(name);
        }
    }

    public void result(){
        for (int i = 0; i < noList.size(); i++){
            System.out.println(noList.getUnit(i).getName());
        }
    }
}

class Registration implements Comparable<Registration>{

    private String name;
    private int size;

    public Registration(String name){
        this.name = name;
        this.size = name.length();
    }

    public String getName(){
        return this.name;
    }

    public int getSize(){
        return this.size;
    }

    @Override
    public int compareTo(Registration other) {
        return this.name.compareTo(other.name);
    }
}

class SortedPointers<T extends Comparable<T>> {

    @SuppressWarnings("rawtypes")
    private Node first = null;

    @SuppressWarnings("rawtypes")
    private Node last = null;

    private int size;

    public SortedPointers(){
        this.last = null;
        this.size = 0;
    }

    @SuppressWarnings({ "rawtypes", "unchecked"})
    public void add(T unit){
        Node newNode = new Node<>(unit);

        if (this.last == null){
            this.first = newNode;
            this.last = newNode;
        }
        else if (((T)newNode.getData()).compareTo((T)this.first.getData()) < 0){
            newNode.setNext(this.first);
            this.first.setPrevious(newNode);
            this.first = newNode;
        }
        else if (((T)newNode.getData()).compareTo((T)this.last.getData()) >= 0){
            this.last.setNext(newNode);
            newNode.setPrevious(this.last);
            this.last = newNode;
        }
        else{
            Node aux = this.first;
            while(((T)newNode.getData()).compareTo((T)aux.getData()) >= 0){
                aux = aux.getNext();
            }
            // conectando o novo elemento ao conjunto
            newNode.setPrevious(aux.getPrevious());
            newNode.setNext(aux);

            // conectando a primeira parte da lista ao novo elemento
            aux.getPrevious().setNext(newNode);

            // conectando a segunda parte da lista ao novo elemento
            aux.setPrevious(newNode);
        }

        this.size++;
    }

    public int size(){
        return this.size;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public T getData(Node data){
        return (T) data.getData();
    }

    @SuppressWarnings({ "rawtypes"})
    public Node getMemory(T unit){
        Node aux = this.first;

        for (int i = 0; i < this.size; i++){
            if (aux.getData().equals(unit)){
                break;
            }
            aux = aux.getNext();
        }

        return aux;
    }

    @SuppressWarnings({ "rawtypes"})
    public int getIndex(T unit){
        Node aux = this.first;
        int index = 0;

        for (int i = 0; i < this.size; i++){
            if (aux.getData().equals(unit)){
                index = i;
                break;
            }
            aux = aux.getNext();
        }

        return index;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public T getUnit(int num){
        Node aux = this.first;

        if (num >= 0 && num < this.size){
            for (int i = 0; i < num; i++){
                aux = aux.getNext();
            }
            return (T) aux.getData();
        }
        return null;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public boolean exists(T unit){

        Node aux = this.first;

        for (int i = 0; i < this.size; i++){
            if (((Comparable<T>) aux.getData()).compareTo(unit) == 0){
                return true;
            }
            aux = aux.getNext();
        }

        return false;
    }

    @SuppressWarnings("rawtypes")
    public int howMany(T unit){
        int count = 0;
        Node aux = this.first;

        for (int i = 0; i < this.size; i++){
            if (aux.getData().equals(unit)){
                count++;
            }
            aux = aux.getNext();
        }
        return count;
    }

    public void remove(){
        if (this.first != null && this.size == 1){
            this.first = null;
            this.last = null;
            this.size--;
        }

        else if (this.first != null && this.size > 1){
            this.last.getPrevious().setNext(null);
            this.last = this.last.getPrevious();
            this.size--;
        }
    }

    @SuppressWarnings("rawtypes")
    public void remove(int pos){
        Node aux = this.first;

        if (this.first == null){
            return;
        }

        if (pos == 0){
            this.first = aux.getNext();
            if (this.first != null){
                this.first.setPrevious(null);
            }
            this.size--;
        }

        else if ((pos > 0) && (pos <= this.size - 2) && (this.size > 2)){
            for (int i = 0; i < pos - 1; i++){
                aux = aux.getNext();
            }
            aux.setNext(aux.getNext().getNext());
            if (aux.getNext() != null && aux.getNext().getNext() != null) {
                aux.getNext().getNext().setPrevious(aux);
            }
            this.size--;
        }

        else if ((pos == this.size - 1) && (this.size > 1)){
            remove();
        }
    }

    @SuppressWarnings("rawtypes")
    public void remove(T unit){
        Node aux = this.first;
        boolean exists = false;
        int pos = 0;

        for (int i = 0; i < this.size; i++){
            if (unit.equals(aux.getData())){
                pos = i;
                exists = true;
                break;
            }
            aux = aux.getNext();
        }
        if(exists){
            remove(pos);
        }
    }

    public void clear(){
        //this.first = null;
        this.last = null;
        this.size = 0;
    }

    @SuppressWarnings("rawtypes")
    public void print(){

        Node aux = this.first;

        System.out.print("[");

        for (int i = 0; i < this.size; i++){
            if (i == this.size - 1){
                System.out.print(aux.getData());
            }
            else{
                System.out.print(aux.getData() + " ");
            }
            aux = aux.getNext();
        }
        System.out.println("]");
    }
}

class Node<T> {

    private T data;

    @SuppressWarnings("rawtypes")
    private Node next;

    @SuppressWarnings("rawtypes")
    private Node previous;



    public Node(T data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public Node(){
        this.data = null;
        this.next = null;
        this.previous = null;
    }

    public T getData(){
        return this.data;
    }

    public void setData(T data){
        this.data = data;
    }

    @SuppressWarnings("rawtypes")
    public Node getNext(){
        return this.next;
    }

    @SuppressWarnings("rawtypes")
    public void setNext(Node next){
        this.next = next;
    }

    @SuppressWarnings("rawtypes")
    public Node getPrevious(){
        return this.previous;
    }

    @SuppressWarnings("rawtypes")
    public void setPrevious(Node previous){
        this.previous = previous;
    }
}
