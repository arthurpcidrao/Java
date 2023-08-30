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
        return tvOn;
    }

    public boolean setTvOff(){
        if (this.tvOn == true){
            this.tvOn = false;
        }
        return tvOn;
    }

    public boolean getTv(){
        return this.tvOn;
    }

    public void volumeUp(){
        if (this.volume < 100){
            this.volume++;
        }
        System.out.printf("Volume: %d", this.volume);
    }

    public void volumeDown(){
        if (this.volume > 0){
            this.volume--;
        }
        System.out.printf("Volume: %d", this.volume);
    }

    public void channelUp(){
        if (this.channel < 15){
            this.channel++;
        }
        System.out.printf("Canal: %d", this.channel);
    }

    public void channelDown(){
        if (this.channel > 0){
            this.channel--;
        }
        System.out.printf("Canal: %d", this.channel);
    }
}
