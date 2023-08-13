public class Sequence_1 {
    public static void main(String[] args) throws Exception {
        double odd, sum = 0, pot = 1;

        for (odd = 1; odd <= 39; odd = odd + 2) {

            sum = sum + odd/pot;
            pot = 2*pot;
        }

        System.out.printf("%.2f\n", sum);
    }
}
