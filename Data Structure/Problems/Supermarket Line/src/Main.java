import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int cashiers = input.nextInt();
        int clients = input.nextInt();

        int timerCashier[] = new int[cashiers];

        for (int i = 0; i< cashiers; i++){
            timerCashier[i] = input.nextInt();
        }

        LinkedQueue<Integer> itemsClients = new LinkedQueue<>();

        for (int i = 0; i < clients; i++){
            itemsClients.enqueue(input.nextInt());
        }

        Heap<Caixa> heap = new Heap<>(cashiers);

        for (int i = 0; i < cashiers; i++){
            Caixa caixa = new Caixa(i, timerCashier[i]*itemsClients.dequeue());
            heap.add(caixa);
        }

        int maxTime[] = new int[cashiers];

        while(!itemsClients.isNull()){
            
            Caixa aux = heap.next();
            int pos = aux.getPosition();
            int time = aux.getTime();

            maxTime[pos] = maxTime[pos] + time;

            Caixa caixa = new Caixa(pos, timerCashier[pos]*itemsClients.dequeue());
            heap.add(caixa);

        }

        while (!heap.isFull()){
            Caixa aux = heap.next();
            int pos = aux.getPosition();
            int time = aux.getTime();

            maxTime[pos] = maxTime[pos] + time;
        }

        int max = 0;

        for (int i = 0; i < maxTime.length; i++){
            if (i == 0){
                max = maxTime[i];
            }
            else{
                if (maxTime[i] > max){
                    max = maxTime[i];
                }
            }
        }

        System.out.println(max);


        input.close();
    }

}