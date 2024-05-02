public class QueueW {
    
    private LinkedStack<Integer> stackE;
    private LinkedStack<Integer> stackD;

    private int sizeE;
    private int sizeD;
    private int size;

    public QueueW(){
        this.stackE = new LinkedStack<>();
        this.stackD = new LinkedStack<>();

        this.sizeE = 0;
        this.sizeD = 0;
        this.size = 0;
    }

    public void enqueue(int unit){
        while(this.sizeD > 0){
            this.stackE.push(this.stackD.pop());
            this.sizeD--;
            this.sizeE++;
        }

        this.stackE.push(unit);
        this.sizeE++;
        this.size++;

    }

    public int dequeue(){
        while(this.sizeE > 0){
            this.stackD.push(this.stackE.pop());
            this.sizeD++;
            this.sizeE--;
        }

        this.sizeD--;
        this.size--;

        return this.stackD.pop();
    }

    public void print(){
        while(this.sizeD > 0){
            this.stackE.push(this.stackD.pop());
            this.sizeD--;
            this.sizeE++;
        }
        this.stackE.print();
    }

    public int size(){
        return this.size;
    }
}
