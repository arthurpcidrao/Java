public class Caixa implements Comparable<Caixa> {
    
    private Integer position;
    private Integer time;

    public Caixa(int position, int time){
        this.position = position;
        this.time = time;
    }

    public int getPosition(){
        return this.position;
    }

    public int getTime(){
        return this.time;
    }


    @Override
    public int compareTo(Caixa other) {

        int comparableAux = - this.time.compareTo(other.time);

        if (comparableAux == 0){
            comparableAux = this.position.compareTo(other.position);
        }

        return comparableAux;
    }
}
