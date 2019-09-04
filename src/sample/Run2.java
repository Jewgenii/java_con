package sample;

public class Run2 implements Runnable {
    IntHolder i;
    public Object locker;
    public void setInteger(IntHolder i){
        this.i = i;
    }
    @Override
    public void run() {
        while(true){
            synchronized ( this.locker ) {this.i.decInt(); }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
