import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        int num = input.nextInt();
        input.nextLine();

        Table list = new Table();

        for(int i = 0; i < num; i++){

            String line = input.nextLine();
            String separated[] = line.split(" ");

            list.add(separated[0], Integer.parseInt(separated[1]), Integer.parseInt(separated[2]), Integer.parseInt(separated[3]));
        }

        input.close();

        list.result();
    }
}
