import java.util.Scanner;

public class Digitos {

    public static int analise(String vetor[], int cte){

        String novo[] = new String[vetor.length];
        boolean verdadeiro = true;

        for (int i = 0; i < vetor.length; i++){
            novo[i] = vetor[i];
        }


        int contNove = 0;
        int contZero = 0;
        for (int i = 0; i < vetor.length; i++){
            
            if (Integer.parseInt(novo[i]) == 9){
                int j = i;
                contNove = 0;
                while(Integer.parseInt(novo[j]) == 9){
                    contNove++;
                    j++;
                }
                
                if (Integer.parseInt(novo[j+1]) == 0 && Integer.parseInt(novo[j]) == 1){
                    int k = j+1;
                    contZero = 0;    
                    while(Integer.parseInt(novo[k]) == 0){
                        contZero++;
                        k++;
                    }
                }

                if (contNove == contZero){
                    int muda[] = new int[vetor.length];
                    // armazenar as posições de transição
                }
            }

            else if (Integer.parseInt(novo[i]) + 1 != Integer.parseInt(novo[i+1])){
                for (int z = 0; z < vetor.length; z++){
                    novo[z] = "";
                }
                // vi a merda, pois da forma que eu to fazendo, estou olhando os números individualmente

            }

            
        }


        int i = 0;
        
        while(verdadeiro){
            
            if (Integer.parseInt(novo[i]) + 1 != Integer.parseInt(novo[i+1])){

                for (i = 0; i < vetor.length; i++){
                    novo[i] = "";
                }
                //ajeitar as condições do while
                i = 0;
                // aqui tem que ter uma condição pra colocar a variação de 9 pra 0
                while(verdadeiro){
                    while(verdadeiro){
                        novo[j] = novo[j] + vetor[k];
                        k++;
                    }
                    j++;
                }
            }
            i++;
        }





        return 0;
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        String vetor[] = new String[n];

        for (int i = 0; i < n; i++){
            vetor[i] = input.next();
        }

        if (n == vetor.length){
            int inicio = analise(vetor, 1);

            input.close();
            System.out.println(inicio);
        }
    }

}
