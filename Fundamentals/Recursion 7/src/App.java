import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);

        System.out.println("Placar m x n, time A x B");

        System.out.print("m = ");
        int golsA = input.nextInt();

        System.out.print("n = ");
        int golsB = input.nextInt();

        input.close();
        permutacoes("", golsA, golsB);
        
    }

    // algoritmo DFS (Depth-first Search) -> busca em profundidade
    public static void permutacoes(String caso, int a, int b){
        if (a == 0 && b == 0){
            //System.out.println("finalizou");
            System.out.println(caso);
            //System.out.println();
        }
        if (a > 0){
            //System.out.printf("Entrou em A = %d\n", a);
            permutacoes(caso + "A", a-1, b);
        }
        if (b > 0) {
            //System.out.printf("Entrou em B = %d\n", b);
            permutacoes(caso + "B", a, b-1);
        }
    }
}
