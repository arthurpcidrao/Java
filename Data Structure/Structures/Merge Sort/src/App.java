import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        
        long vetor[] = new long[100000000];

        for (int i = 0; i < vetor.length; i++){
            vetor[i] = random.nextInt(1000000);
            //System.out.println(vetor[i]);
        }

        //System.out.println();
        System.out.println("Inicio");

        sortFast(vetor);

        /*for (int i = 0; i < vetor.length; i++){
            System.out.println(vetor[i]);
        }
        */
        System.out.println("fim");

    }

    public static void sortFast(long array[]){
        
        int len = array.length;
        if (len < 2){
            return;
        }
        
        long left[] = new long[len/2];
        long right[] = new long[len - len/2];

        for (int i = 0; i < (len/2); i++){
            left[i] = array[i];
        }
        for (int i = (len/2); i < array.length; i++){
            right[i - left.length] = array[i];
        }

        sortFast(left);
        sortFast(right);

        sortFinish(array,left,right);
    }

    public static void sortFinish(long array[], long left[], long right[]){
        int i = 0, j = 0, k = 0;

        while(i < left.length && j < right.length){
            if (left[i] < right[j]){
                array[k] = left[i];
                i++;
            }
            else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < left.length){
            array[k] = left[i];
            i++;
            k++;
        }

        while(j < right.length){
            array[k] = right[j];
            j++;
            k++;
        }
    }
}
