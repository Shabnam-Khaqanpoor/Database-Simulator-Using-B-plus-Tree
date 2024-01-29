package com.example.demo;

import com.example.demo.impelementation.BPTree;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class DatabaseController implements Initializable {
    @FXML
    private AnchorPane pane;
    @FXML
    private Text databaseName;
    @FXML
    private ImageView close;
    @FXML
    private ImageView add;
    @FXML
    private ImageView delete;
    @FXML
    private ImageView edite;
    @FXML
    private TextField fieldText;
    @FXML
    private ImageView search;
    @FXML
    private Text searchResult;

    Node selectedNode ;

    @FXML
    void closeClicked(MouseEvent event) /*throws IOException*/ {
//        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(parent);
//        stage.setTitle("Databases");
//        stage.setScene(scene);
//        stage.show();
    }
    @FXML
    void closeEntered(MouseEvent event) {
        close.setScaleX(1.1);
        close.setScaleY(1.1);
    }
    @FXML
    void closeExited(MouseEvent event) {
        close.setScaleX(1);
        close.setScaleY(1);
    }
    @FXML
    void addClicked(MouseEvent event) {

    }
    @FXML
    void addEntered(MouseEvent event) {
        add.setScaleX(1.1);
        add.setScaleY(1.1);
    }

    @FXML
    void addExited(MouseEvent event) {
        add.setScaleX(1);
        add.setScaleY(1);
    }

    @FXML
    void deleteClicked(MouseEvent event) {
        bpTree.insert(null , null , null);

    }

    @FXML
    void deleteEntered(MouseEvent event) {
        delete.setScaleX(1.1);
        delete.setScaleY(1.1);
    }
    @FXML
    void deleteExited(MouseEvent event) {
        delete.setScaleX(1);
        delete.setScaleY(1);
    }

    @FXML
    void editeClicked(MouseEvent event) {
        Pane temp = new Pane() ;
        pane.getChildren().add(temp);
        temp.setPrefWidth(250);
        temp.setPrefHeight(150);
        temp.setLayoutX(800);
        temp.setLayoutY(300);
        TextField field = new TextField() ;
        temp.getChildren().add(field);
        field.setPrefWidth(200);
        field.setPrefHeight(40);
        field.setLayoutX(25);
        field.setLayoutY(60);
        Button button = new Button("send") ;
        temp.getChildren().add(button);
        button.setPrefWidth(60);
        button.setPrefHeight(20);
        button.setLayoutX(165);
        button.setLayoutY(115);
    }

    @FXML
    void editeEntered(MouseEvent event) {
        edite.setScaleX(1.1);
        edite.setScaleY(1.1);
    }
    @FXML
    void editeExited(MouseEvent event) {
        edite.setScaleX(1);
        edite.setScaleY(1);
    }

    @FXML
    void searchClicked(MouseEvent event) {

    }

    @FXML
    void searchEntered(MouseEvent event) {
        search.setScaleX(1.1);
        search.setScaleY(1.1);
    }
    @FXML
    void searchExited(MouseEvent event) {
        search.setScaleX(1);
        search.setScaleY(1);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bpTree = HelloApplication.getTree() ;
        for (String temp : bpTree.traverse()) {
            Pack pack = bpTree.search(temp) ;
            System.out.println(pack.toString());
            show(pack , bpTree.traverse().indexOf(temp));
        }
        fieldText.setVisible(false);
    }
    private int colum ;
    private static BPTree <String , Pack> bpTree ;
    public void show (Pack temp , int n) {
        for (int i= 0 ; i < temp.values.size() ; i++) {
            Text text = new Text(temp.values.get(i).toString());
            System.out.println(temp.values.get(i));
            pane.getChildren().add(text);
            text.setLayoutX(300 + i * 50);
            text.setLayoutY(100 + n * 50);
        }
    }
}