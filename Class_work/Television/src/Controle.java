import java.util.Scanner;

public class Controle {
    private Televisao tv;
    private int keyboard;



    public void tvOn(){
        tv.setTvOn();
    }

    public void volumeUp(){
        tv.volumeUp();
    }
    
    public void volumeDown(){
        tv.volumeDown();
    }

    public void channelUp(){
        tv.channelUp();
    }

    public void channelDown(){
        tv.channelDown();
    }

    public void setKeyboard(){
        Scanner input = new Scanner(System.in);
        input.close();
    }


}
