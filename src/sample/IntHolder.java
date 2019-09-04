package sample;

public class IntHolder {
    private Integer i=0;

    public void IntHolder(Integer i) {
        this.i = i;
    }
    public void decInt(){
        synchronized (this){
            System.out.println(String.format("Run 2 : %s",this.i--));
        }
    }
    public void incInt(){
        synchronized (this){
            System.out.println(String.format("Run 1 : %s",this.i++));
        }
    }

}