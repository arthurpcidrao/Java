import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        int num = input.nextInt();
        input.nextLine();

        for (int i = 0; i < num; i++){
            ShoppingList list = new ShoppingList();
            
            String object = input.nextLine();
            String marketList[] = object.split(" ");
            
            for (int j = 0; j < marketList.length; j++){
                list.add(marketList[j]);
            }
            list.print();
        }

        input.close();
    }
}
