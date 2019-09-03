package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.concurrent.Executors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        IntHolder i = new IntHolder();
        i.i=0;
        Run1 r1 = new Run1();
        Run2 r2 = new Run2();
        r1.setInteger(i);
        r2.setInteger(i);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        //ExecutorService s =Executors.newFixedThreadPool(2);

    }
        public static void main (String[]args) {
            launch(args);
        }
}
