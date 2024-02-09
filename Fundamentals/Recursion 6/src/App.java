import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite o conjunto a analisar: ");
        
        String conjunto = input.next();
        input.close();
        permuta("", conjunto);
        }

    public static void permuta(String p, String q){

        if(q.length() == 0){
            System.out.println(p);
        }
        else{
            for (int i = 0; i < q.length(); i++){
                permuta(p + q.charAt(i), q.substring(0, i) + q.substring(i+1, q.length()));
            }
        }        
    }
}
