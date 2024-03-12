import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        int num = input.nextInt();
        input.nextLine();

        for (int i = 0; i < num; i++){
            ShoppingList list = new ShoppingList();
            
            while(true){
                String object = input.next();
                if (object.isEmpty()){
                    break;
                }
                list.add(object);
            }
        }

        input.close();
    }
}
