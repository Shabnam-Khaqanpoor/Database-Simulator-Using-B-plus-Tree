package com.example.demo;

import com.example.demo.impelementation.BPTree;
import javafx.event.ActionEvent;
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
    private AnchorPane pane; // the main pane
    @FXML
    private ImageView add; // add table icon
    @FXML
    private ImageView exit; // exit icon

    //    add a table
    @FXML
    void addClicked(MouseEvent event) {
        selectedTree = null;
        selected = false;
        paneImport.setVisible(true);
        nameField.setVisible(true);
        infoText.setText("name of the table : ");
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
//    exit
    @FXML
    void exitClicked(MouseEvent event) {
        System.exit(0);
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



//    add table page
    @FXML
    private Pane paneImport;
    @FXML
    private Text infoText;
    @FXML
    private TextField nameField;
    @FXML
    private ImageView cancelButton;
    @FXML
    private ImageView okButton;

    //    cancel button
    @FXML
    void cancelClicked(MouseEvent event) {
        selectedTree = null;
        selected = false;
        paneImport.setVisible(false);
        nameField.setText("");
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
    //    make sure about making table with enter
    @FXML
    void enterPressed(ActionEvent event){
        makeTable();
    }
//    make sure about making table or loading a table
    @FXML
    void okClicked(MouseEvent event) throws IOException {
        if (selected) {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("database-view.fxml")));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setTitle("Database");
            stage.setScene(scene);
            stage.show();
            paneImport.setVisible(false);
        } else {
            makeTable();
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


    //    initialize
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paneImport.setVisible(false);
        selectedTree = null;
        selected = false;
        for (BPTree tree : tables) {
            showTree(tree);
        }
    }
//    list of our table
    private static List<BPTree> tables = new ArrayList<>() ;
    //    the selected table
    private Boolean selected = false ;
    private static BPTree selectedTree ;
    public static BPTree getSelectedTree() {
        return selectedTree;
    }
    // No two name of tables should be the same
    private Boolean checkName(String name) {
        for (BPTree bpTree : tables) {
            if (bpTree.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }
//    make a table
    private void makeTable () {
        if (!nameField.getText().equals("")) {
            if (checkName(nameField.getText())) {
                BPTree tree = new BPTree(nameField.getText());
                tables.add(tree);
                showTree(tree);
                paneImport.setVisible(false);
                nameField.setText("");
            } else {
                infoText.setText("input is Repetitious");
            }
        } else {
            infoText.setText("input is not ok");
        }
    }
//    show the threes
    public void showTree(BPTree tree) {
        Pane temp = new Pane();
        temp.setPrefWidth(115);
        temp.setPrefHeight(115);
        temp.setLayoutX(800);
        temp.setLayoutY(50);
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
        while (temp.getLayoutY() >= 720) {
            temp.setLayoutY(temp.getLayoutY() - 650);
            temp.setLayoutX(temp.getLayoutX() + 150);
        }
        imageView.setOnMouseClicked(event -> {
            selectedTree = tree;
            selected = true;
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
}
