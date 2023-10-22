public class Frog {
    private int jump;
    private Pipes canos;

    public Frog (Pipes canos){
        this.canos = canos;
    }
    
    public int getJump(){
        return jump;
    }

    public void setJump(int jump){
        this.jump = jump;
    }

    public String isPossible(){
        String result = "YOU WIN";
        for (int i = 0; i < canos.lenPipes() - 1; i++){
            if (this.jump < Math.abs(canos.whichPipe(i+1) - canos.whichPipe(i))){
                result = "GAME OVER";
            }
        }

        return result;
    }
}
