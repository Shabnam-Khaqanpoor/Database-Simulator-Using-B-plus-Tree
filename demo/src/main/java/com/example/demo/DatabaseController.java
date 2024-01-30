package com.example.demo;

import com.example.demo.impelementation.BPTree;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class DatabaseController implements Initializable {
//    شکال و ابزارک هایی که در صفحه هستند
    @FXML
    private AnchorPane pane;
    @FXML
    private Text databaseName;
    @FXML
    private ImageView close;
    @FXML
    private ImageView delete;
    @FXML
    private ImageView edite;
    @FXML
    private ImageView addColumn;
    @FXML
    private ImageView addRow;
    @FXML
    private ImageView search;
    @FXML
    private TextField fieldText;
    @FXML
    private Pane table;
    @FXML
    private Pane column;
    @FXML
    private Pane row;
    @FXML
    private Pane searchResult;


    @FXML
    void closeClicked(MouseEvent event) {
        System.exit(0);
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
//عملکرد دکمه اضافه کردن (کامل نشده)
//    @FXML
//    void addClicked(MouseEvent event) {
//        Pane temp = new Pane() ;
//        temp.setPrefWidth(300);
//        temp.setPrefHeight(800);
////        یه عکس بزار اسمشو تو جای مشخص شده بزار ترجیحا مستطیل 8*3 باشه
//        ImageView imageView = new ImageView(new Image(HelloApplication.class.getResource("").toString())) ;
//        imageView.setFitWidth(300);
//        imageView.setFitHeight(800);
//        temp.getChildren().add(imageView) ;
////        بجای 5 باید تعداد ستون ها قرار بگیرد
//        for (int i = 0 ; i < 5 ; i++) {
//            TextField textField = new TextField() ;
//            temp.getChildren().add(textField) ;
//            textField.setLayoutX(200);
//            textField.setLayoutY(50 * i + 50);
//            Text text = new Text("the name of colum") ;
//            temp.getChildren().add(text) ;
//            text.setLayoutX(10);
//            text.setLayoutY(60 * i + 50);
//        }
//        Button button = new Button("send") ;
//        temp.getChildren().add(button) ;
//        button.setLayoutX(50);
//        button.setLayoutY(700);
//        pane.getChildren().add(temp) ;
//        temp.setLayoutX(500);
//        temp.setLayoutY(200);
//        button.setOnMouseClicked(event1 -> {
////            خواااااااابم میاد
//        });
//    }

//عملکرد فرایند حذف کردن (کامل ولی باگ داره)
    @FXML
    void deleteClicked(MouseEvent event) {
        if (selectedCell != null) {
            easyDelete();
        }
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
//ادیت در داک نبود
    @FXML
    void editeClicked(MouseEvent event) {
//        Pane temp = new Pane();
//        pane.getChildren().add(temp);
//        temp.setPrefWidth(250);
//        temp.setPrefHeight(150);
//        temp.setLayoutX(800);
//        temp.setLayoutY(300);
//        TextField field = new TextField();
//        temp.getChildren().add(field);
//        field.setPrefWidth(200);
//        field.setPrefHeight(40);
//        field.setLayoutX(25);
//        field.setLayoutY(60);
//        Button button = new Button("send");
//        temp.getChildren().add(button);
//        button.setPrefWidth(60);
//        button.setPrefHeight(20);
//        button.setLayoutX(165);
//        button.setLayoutY(115);
//        button.setOnMouseClicked(event1 -> {
//            String t = field.getText();
//            if (t != null) {
//                if (checkText()) {
//                    selectedCell.setText(field.getText());
//                }
//            }
//        });
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
//سرچ کردن
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
    void addColumnClicked(MouseEvent event) {

    }

    @FXML
    void addColumnEntered(MouseEvent event) {

    }

    @FXML
    void addColumnExited(MouseEvent event) {

    }

    @FXML
    void addRowClicked(MouseEvent event) {

    }

    @FXML
    void addRowEntered(MouseEvent event) {

    }

    @FXML
    void addRowExited(MouseEvent event) {

    }

















//شروع کار
//    چاپ مقادیر اولیه درخت
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bpTree = HelloApplication.getTree();
        for (String temp : bpTree.traverse()) {
            Pack pack = bpTree.search(temp);
            show(temp , pack, bpTree.traverse().indexOf(temp));
        }
    }
//درخت بی تری مرتبط با این دیتا بیس
    private static BPTree<String, Pack> bpTree;
//    لیست سل ها یا همان تکست ها
    private List<Cell> cells = new ArrayList<>() ;
    public void show(String key , Pack temp, int n) {
//        نمایش سل ها
        for (int i = 0; i < temp.values.size(); i++) {
            Cell cell = new Cell(key, temp.values.get(i).toString() , 9);
            System.out.println(temp.values.get(i));
            pane.getChildren().add(cell);
            cell.setLayoutX(300 + i * 50);
            cell.setLayoutY(100 + n * 50);
            cells.add(cell);
            cell.setOnMouseClicked(event -> {
                selectedCell = cell ;
            });
        }
    }
//در صورت انتخاب یک سل ان به حالت سلکت شده در می اید
    private Cell selectedCell;
//تابع چک کردن درست بودن مقادیر وارد شده (ناکامل)
    private boolean checkText() {
        return true;
    }
//    مربوط به فرایند حذف که باگ داشت
    private void easyDelete () {
        Pane temp = new Pane();
        pane.getChildren().add(temp);
        temp.setPrefWidth(250);
        temp.setPrefHeight(150);
        temp.setLayoutX(800);
        temp.setLayoutY(300);
        Button buttonAll = new Button("delete all");
        temp.getChildren().add(buttonAll);
        buttonAll.setPrefWidth(60);
        buttonAll.setPrefHeight(20);
        buttonAll.setLayoutX(165);
        buttonAll.setLayoutY(115);
        Button buttonCancel = new Button("cancel");
        temp.getChildren().add(buttonCancel);
        buttonCancel.setPrefWidth(60);
        buttonCancel.setPrefHeight(20);
        buttonCancel.setLayoutX(35);
        buttonCancel.setLayoutY(115);
        buttonAll.setOnMouseClicked(event -> {
            for (Cell<String> cell : cells) {
                if (cell.getKey().equals(selectedCell.getKey())) {
                    pane.getChildren().remove(cell) ;
                    cells.remove(cell) ;
                }
            }
            bpTree.delete((String) selectedCell.getKey());
            pane.getChildren().remove(temp) ;
            selectedCell = null ;
        });
        buttonCancel.setOnMouseClicked(event -> {
            pane.getChildren().remove(temp) ;
            selectedCell = null ;
        });
    }
}