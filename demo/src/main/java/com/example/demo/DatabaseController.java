package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class DatabaseController {
    @FXML
    private Text databaseName;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> firstC;
    @FXML
    private TableColumn<?, ?> secondC;
    @FXML
    private TableColumn<?, ?> thirdC;
    @FXML
    private TableColumn<?, ?> fourthC;
    @FXML
    private TableColumn<?, ?> fifthC;
    @FXML
    private TableColumn<?, ?> sixthC;
    @FXML
    private TableColumn<?, ?> seventhC;
    @FXML
    private TableColumn<?, ?> eighthC;
    @FXML
    private TableColumn<?, ?> ninthC;
    @FXML
    private TableColumn<?, ?> tenthC;
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
    void closeClicked(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setTitle("Databases");
        stage.setScene(scene);
        stage.show();
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
    @FXML
    void edit1(ActionEvent event) {

    }
    @FXML
    void edit2(ActionEvent event) {

    }
    @FXML
    void edit3(ActionEvent event) {

    }

    @FXML
    void edit4(ActionEvent event) {

    }

    @FXML
    void edit5(ActionEvent event) {

    }

    @FXML
    void edit6(ActionEvent event) {

    }

    @FXML
    void edit7(ActionEvent event) {

    }

    @FXML
    void edit8(ActionEvent event) {

    }

    @FXML
    void edit9(ActionEvent event) {

    }
    @FXML
    void edit10(ActionEvent event) {

    }


}
