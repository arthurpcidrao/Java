public class MyException extends Exception{
    private int msgErroIndex;
    private String erro[] = {"nota invalida"};

    public MyException(int msgErroIndex){
        this.msgErroIndex = msgErroIndex;
    }

    @Override
    public String getMessage(){
        return erro[this.msgErroIndex];
    }
}
