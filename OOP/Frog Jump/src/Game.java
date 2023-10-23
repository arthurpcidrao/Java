public class Game {
    private Frog sapo;
    private Pipes canos;

    public Game (Frog sapo, Pipes canos){
        this.sapo = sapo;
        this.canos = canos;
    }

    public String isPossible(){
        String result = "YOU WIN";
        for (int i = 0; i < canos.lenPipes() - 1; i++){
            if (sapo.getJump() < Math.abs(canos.getPipe(i+1) - canos.getPipe(i))){
                result = "GAME OVER";
            }
        }

        return result;
    }
}
