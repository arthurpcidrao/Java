public class Televisao {
    private boolean tvOn = false;
    private int channel;
    private int volume;


    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel){
        this.channel = channel;
    }

    // REVISAR ESSA PARTE DO CÓDIGO
    public boolean setTvOn(){
        if (this.tvOn == false){
            this.tvOn = true;
        }
        System.out.println("Televisao LIGADA");
        return tvOn;
    }

    public boolean setTvOff(){
        if (this.tvOn == true){
            this.tvOn = false;
        }
        System.out.println("Televisao DESLIGADA");
        return tvOn;
    }

    public void volumeUp(){
        if (this.volume < 100 && tvOn){
            this.volume++;
        }
    }

    public void volumeDown(){
        if (this.volume > 0 && tvOn){
            this.volume--;
        }
    }

    public void channelUp(){
        if (this.channel < 15 && tvOn){
            this.channel++;
        }
    }

    public void channelDown(){
        if (this.channel > 0 && tvOn){
            this.channel--;
        }
    }

    public void imprima(){
        System.out.printf("Canal: %d\n", this.channel);
        System.out.printf("Volume: %d\n\n", this.volume);
    }
}
