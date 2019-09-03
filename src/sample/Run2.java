package sample;

public class Run2 implements Runnable {
    IntHolder i;
    public void setInteger(IntHolder i){
        this.i = i;
    }
    @Override
    public void run() {
        while(true){
            System.out.println(String.format("Run 2: %s",this.i.i--));
        }
    }
}
