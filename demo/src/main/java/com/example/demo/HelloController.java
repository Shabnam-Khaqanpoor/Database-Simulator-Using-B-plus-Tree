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
        selectedTree = null ;
        selected = false ;
        paneImport.setVisible(true);
        nameField.setVisible(true);
        infoText.setText("name of the table : ");
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
        selectedTree = null ;
        selected = false ;
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
        System.out.println(selected);
        if (selected) {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("database-view.fxml")));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setTitle("Database");
            stage.setScene(scene);
            stage.show();
            pane.setVisible(false);
        } else {
            if (!nameField.getText().equals("")) {
                if  (checkName(nameField.getText())) {
                    BPTree tree = new BPTree(nameField.getText());
                    tables.add(tree);
                    showTree(tree);
                    paneImport.setVisible(false);
                } else {
                    infoText.setText("input is Repetitious");
                }
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
        paneImport.setVisible(false);
        selectedTree = null ;
        selected = false ;
        tables.add(new BPTree("ali"));
        tables.add(new BPTree("food"));
        tables.add(new BPTree("student"));
        for (BPTree tree : tables) {
            showTree(tree);
        }
    }
    private Boolean selected = false ;
    private Boolean checkName (String name) {
        for (BPTree bpTree : tables) {
            if (bpTree.getName().equals(name)) {
                return false ;
            }
        }
        return true ;
    }
//    نمایش مربع های حاوی اطلاعات درخت در صفحه برای انتخاب
    public void showTree(BPTree tree) {
        Pane temp = new Pane();
        temp.setPrefWidth(115);
        temp.setPrefHeight(115);
        temp.setLayoutX(850);
        temp.setLayoutY(85);
        Image image = new Image(HelloApplication.class.getResource("table (1).png").toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(115);
        imageView.setFitHeight(115);
        Text text = new Text(tree.getName());
        text.setStrokeWidth(80);
        text.setWrappingWidth(80);
        temp.getChildren().add(imageView);
        temp.getChildren().add(text);
        pane.getChildren().add(temp);
        temp.setLayoutY(temp.getLayoutY() + 130 * tables.indexOf(tree));
        while (temp.getLayoutY() >= 720 ) {
            temp.setLayoutY(temp.getLayoutY() - 650);
            temp.setLayoutX(temp.getLayoutX() + 150);
        }
        imageView.setOnMouseClicked(event -> {
            selectedTree = tree ;
            selected = true ;
            paneImport.setVisible(true);
            nameField.setVisible(false);
            infoText.setText(text.getText());
        });

        imageView.setOnMouseEntered(event -> {
            imageView.setScaleX(1.1);
            imageView.setScaleY(1.1);
        });


        imageView.setOnMouseExited(event -> {
            imageView.setScaleX(1);
            imageView.setScaleY(1);
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

/*
کار ای باقی مانده :
یک عکس پس زمینه فقط حاوی رنگ برای paneImport
تغییر باتن های اوکی و کنسل به عکس دلخواه
زیبایی بصری
کامل کردن کردن خروج در تابع exitClicked
 */