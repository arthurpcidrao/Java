import java.util.Calendar;
public class People {
    
    //---------- ATRIBUTOS ----------//
    
    private String name;
    private String birthday;  // existe um tipo de dado "Date"
    private double height;

    //---------- MÉTODOS ----------//

    public People() { // colocar os parâmetros
        System.out.println("Método construtor.");
        // na hora da iniciação do objeto, colocar logo
        // os dados que você quer que ele inicie.
    }

    public void setName (String name){
        this.name = name;
    }    

    public String getName() {
        return name;
    }

    public void setBirthday (String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void print(int age) {
        System.out.printf("Nome: %s\n", this.name);
        System.out.printf("Data de nascimento: %s\n", this.birthday);
        System.out.printf("Altura: %.2f\n", this.height);
        System.out.printf("Sua idade eh: %d\n", age);
    }

    public int age() {
        int day, month, year, age;

        day = Integer.parseInt(birthday.substring(0, 2));
        month = Integer.parseInt(birthday.substring(3, 5));
        year = Integer.parseInt(birthday.substring(6, 10));

        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        int mesAtual = Calendar.getInstance().get(Calendar.MONTH) + 1; // esse método o mês começa do 0
        int diaAtual = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        age = anoAtual - year;
        if ((mesAtual == month) && (diaAtual < day)){
            age--;
        }
        
        if (mesAtual < month){
            age--;
        }

        return age;
    }



}
