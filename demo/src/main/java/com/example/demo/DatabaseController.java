package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DatabaseController {

    @FXML
    private Text databaseName;

    @FXML
    private TableColumn<?, ?> eightthC;

    @FXML
    private TableColumn<?, ?> fifthC;

    @FXML
    private TableColumn<?, ?> firstC;

    @FXML
    private TableColumn<?, ?> fourthC;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> ninethC;

    @FXML
    private Text searchResult;

    @FXML
    private TableColumn<?, ?> secondC;

    @FXML
    private TableColumn<?, ?> seventhC;

    @FXML
    private TableColumn<?, ?> sixC;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> tenthC;

    @FXML
    private TableColumn<?, ?> thirdC;

    @FXML
    void edit(MouseEvent event) {

    }

    @FXML
    void edit1(ActionEvent event) {

    }

    @FXML
    void edit10(ActionEvent event) {

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
    void exit(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setTitle("Databases");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void remove(MouseEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }

    @FXML
    void search2(MouseEvent event) {

    }


}
