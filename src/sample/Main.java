package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        Db db = new Db();
        db.establishConnect();
        ResultSet rs = null;


        Thread th = new Thread (new Runnable (){
            @Override
            public void run () {

                try {

                    Thread.sleep (2000);
                    if(!Thread.currentThread ().isInterrupted ()){
                        ArrayList<Db.TestTable> t =  db.getTestTableContent(db.request("select * from test"));
                        for (Db.TestTable tmp: t )
                        {
                            System.out.println (String.format ("id:%s, testfield:%s",tmp.id,tmp.testField));
                        }
                    }
                } catch(InterruptedException e) {
                    e.printStackTrace ();
                }


            }
        });
        th.start ();
        th.interrupt ();


        /*
        IntHolder i = new IntHolder();
        Run1 r1 = new Run1();
        Run2 r2 = new Run2();
        r1.setInteger(i);
        r2.setInteger(i);
        Object o = new Object();
        r1.locker = o;
        r2.locker = o;
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();
*/

        //ExecutorService s =Executors.newFixedThreadPool(2);

    }
        public static void main (String[]args) {
            launch(args);
        }
}
