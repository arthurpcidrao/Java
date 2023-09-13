import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        int num;
        Scanner input = new Scanner(System.in);
        int ata, def, level, bonus;
        
        Pokemons dabriel = new Pokemons();
        Pokemons guarte = new Pokemons();
        Batalha bat = new Batalha(dabriel, guarte);

        num = input.nextInt();
        for (int i = 0; i < num; i++){
            bonus = input.nextInt();
            bat.setBonus(bonus);

            ata = input.nextInt();
            dabriel.setAta(ata);

            def = input.nextInt();
            dabriel.setDef(def);

            level = input.nextInt();
            dabriel.setLevel(level);

            ata = input.nextInt();
            guarte.setAta(ata);

            def = input.nextInt();
            guarte.setDef(def);

            level = input.nextInt();
            guarte.setLevel(level);

            System.out.printf(bat.resultado());

        }
        input.close();
    }
}
