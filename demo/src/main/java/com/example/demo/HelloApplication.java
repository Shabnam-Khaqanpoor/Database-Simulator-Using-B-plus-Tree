package com.example.demo;

import com.example.demo.impelementation.BPTree;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        صفحه را مستقیم به بخش جدول به همراه یک درخت برای تست فرستادیم
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("database-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        bpTree.addColumnName("name");
        bpTree.addColumnName("number");
        bpTree.addColumnName("city");
//        تست کیس
        Pack pack = new Pack(bpTree.getColumnNames().size());
        pack.addValue("ehsan");
        pack.addValue(987);
        pack.addValue("tehran");
        Pack pack1 = new Pack(bpTree.getColumnNames().size()) ;
        pack1.addValue("yahi");
        pack1.addValue(918765);
        pack1.addValue("lkjd");

        bpTree.insert("1" , pack);
        bpTree.insert("2" , pack1);
//        ----------------
        launch();
    }
//    تست کیس
    static BPTree <String , Pack> bpTree = new BPTree<>();
    public static BPTree <String , Pack> getTree () {
        return bpTree ;
    }
}