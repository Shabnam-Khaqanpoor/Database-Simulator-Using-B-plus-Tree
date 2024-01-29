package com.example.demo;

import com.example.demo.impelementation.BPTree;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.util.*;

public class HelloController implements Initializable {
    @FXML
    private ImageView add;
    @FXML
    private ImageView exit;
//    add a table
    @FXML
    void addClicked(MouseEvent event) {
        paneImport.setVisible(true);
        nameField.setVisible(true);
        infoText.setText("name of the table : ");
        selectedTree = null ;
    }
//    just for show in the graphic
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
//    صفحه ای که قبل ورود به جدول تایید میگیرد
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

//    cancel
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
//    تایید کردن
    @FXML
    void okClicked(MouseEvent event) throws IOException {
        if (selectedTree != null) {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("database-view.fxml")));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setTitle("Database");
            stage.setScene(scene);
            stage.show();
            pane.setVisible(false);
        } else {
            if (nameField.getText() != null) {
                BPTree tree = new BPTree();
                tables.add(tree);
                showTree(tree);
                pane.setVisible(false);
            } else {
                infoText.setText("input is not ok");
            }
        }
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
//    initialize
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tables.add(new BPTree());
        tables.add(new BPTree());
        tables.add(new BPTree());
        for (BPTree tree : tables) {
            showTree(tree);
        }
        selectedTree = HelloController.getTree();
    }
//    نمایش مربع های حاوی اطلاعات درخت در صفحه برای انتخاب
    public void showTree(BPTree tree) {
        Pane temp = new Pane();
        temp.setPrefWidth(80);
        temp.setPrefHeight(80);
        temp.setLayoutX(850);
        temp.setLayoutY(85);
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
        if (temp.getLayoutY() >= 785 ) {
            temp.setLayoutY(temp.getLayoutY() - 700);
            temp.setLayoutX(temp.getLayoutX() + 100);
        }
        imageView.setOnMouseClicked(event -> {
            selectedTree = tree ;
            paneImport.setVisible(true);
            nameField.setVisible(false);
            infoText.setText(text.getText()); ;
        });

        imageView.setOnMouseEntered(event -> {
            imageView.setScaleX(1.1);
            imageView.setScaleY(1.1);
            selectedTree = tree ;
            paneImport.setVisible(true);
            nameField.setVisible(false);
            infoText.setText(text.getText()); ;
        });


        imageView.setOnMouseExited(event -> {
            imageView.setScaleX(1);
            imageView.setScaleY(1);
            selectedTree = tree ;
            paneImport.setVisible(true);
            nameField.setVisible(false);
            infoText.setText(text.getText()); ;
        });
    }
    private static BPTree selectedTree ;

    public static BPTree getSelectedTree() {
        return selectedTree;
    }

    List <BPTree> tables = new ArrayList<>() ;
    public static BPTree getTree () {
        return selectedTree ;
    }
}