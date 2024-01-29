package com.example.demo;

import javafx.beans.InvalidationListener;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;


public class DatabaseController {
    @FXML
    private AnchorPane pane;
    @FXML
    private Text databaseName;
    @FXML
    private TableView<Record> table;
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
//        table.getItems().add(new Person("ali")) ;
        table.getItems().add(new Record ());
        System.out.println(table.getItems().size());
//        table.getItems().
    }
    List <Record> records ;
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

class Person {
    public Person (String a) {
        k = a;
    }
    String k;
}
