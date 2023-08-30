public class Controle {
    private Televisao tv;


    public Controle(Televisao tv){
        this.tv = tv;
    }

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

    public void changeChannel ( int channel){
        tv.setChannel(channel);
    }



}
