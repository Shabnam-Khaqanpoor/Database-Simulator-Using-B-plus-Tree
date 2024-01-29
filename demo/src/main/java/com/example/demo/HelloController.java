package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InaccessibleObjectException;
import java.net.URL;
import java.util.*;

public class HelloController implements Initializable {
    @FXML
    private ImageView add;
    @FXML
    private SplitMenuButton menuButton;

    @FXML
    private ImageView exit;

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
    void exitClicked(MouseEvent event) {

    }

    @FXML
    void exitEntered(MouseEvent event) {
        exit.setScaleX(1.1);
        exit.setScaleY(1.1);
    }

    @FXML
    void exitExited(MouseEvent event) {
        exit.setScaleX(1);
        exit.setScaleY(1);
    }

//    Tree selectedTree = new Tree<>() ;



    @FXML
    private Pane paneImport;
    @FXML
    private Text infoText;
    @FXML
    private TextField nameField;
    @FXML
    private Button cancelButton;
    @FXML
    private Button okButton;


    @FXML
    void cancelClicked(MouseEvent event) {
        paneImport.setVisible(false);
    }

    @FXML
    void cancelEntered(MouseEvent event) {
        cancelButton.setScaleX(1.1);
        cancelButton.setScaleY(1.1);
    }

    @FXML
    void cancelExited(MouseEvent event) {
        cancelButton.setScaleX(1);
        cancelButton.setScaleY(1);
    }
    @FXML
    void okClicked(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("database-view.fxml")));
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setTitle("Database");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void okEntered(MouseEvent event) {
        okButton.setScaleX(1.1);
        okButton.setScaleY(1.1);
    }

    @FXML
    void okExited(MouseEvent event) {
        okButton.setScaleX(1);
        okButton.setScaleY(1);
    }
    @FXML
    private AnchorPane pane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tables.add(new Tree<>());
        tables.add(new Tree<>());
        tables.add(new Tree<>());
        for (Tree tree : tables) {
            Pane temp = new Pane();
            temp.setPrefWidth(80);
            temp.setPrefHeight(80);
            temp.setLayoutX(850);
            temp.setLayoutY(100);
            Image image = new Image(HelloApplication.class.getResource("images.png").toString());
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(80);
            imageView.setFitHeight(80);
            Text text = new Text(tree.toString());
            text.setStrokeWidth(80);
            text.setWrappingWidth(80);
            temp.getChildren().add(imageView);
            temp.getChildren().add(text);
            pane.getChildren().add(temp);
            temp.setLayoutY(temp.getLayoutY() + 100 * tables.indexOf(tree));
        }
    }
    
    List <Tree> tables = new ArrayList<>() ;
}