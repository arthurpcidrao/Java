    import java.util.Scanner;

    public class Even_numbers {
        public static void main(String[] args) throws Exception {
            
            int num, qtd = 5, count_even = 0, count_odd = 0, count_pos = 0, count_neg = 0;

            Scanner input = new Scanner(System.in);

            for (int i = 0; i < qtd; i++) {

                num = input.nextInt();

                if (num % 2 == 0) {
                    count_even++;
                }

                if (num % 2 == 1) {
                    count_odd++;
                }

                if (num > 0) {
                    count_pos++;
                }

                if (num < 0) {
                    count_neg++;
                }
            }
            input.close();

            System.out.printf("%d valor(es) par(es)\n", count_even);
            System.out.printf("%d valor(es) impar(es)\n", count_odd);
            System.out.printf("%d valor(es) positivo(s)\n", count_pos);
            System.out.printf("%d valor(es) negativo(s)\n", count_neg);
        }
    }
