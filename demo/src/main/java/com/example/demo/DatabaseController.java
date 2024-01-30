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
        addColumn.setScaleX(1.1);
        addColumn.setScaleY(1.1);
    }

    @FXML
    void addColumnExited(MouseEvent event) {
        addColumn.setScaleX(1);
        addColumn.setScaleY(1);
    }

    @FXML
    void addRowClicked(MouseEvent event) {
        Pane temp = new Pane() ;
        temp.setPrefWidth(300);
        temp.setPrefHeight((bpTree.getColumnNames().size() + 1) * 50);
//        یه عکس بزار اسمشو تو جای مشخص شده بزار ترجیحا مستطیل 8*3 باشه
        ImageView imageView = new ImageView(new Image(HelloApplication.class.getResource("color1.png").toString())) ;
        imageView.setFitWidth(300);
        imageView.setFitHeight((bpTree.getColumnNames().size() + 2) * 50 + 20);
        imageView.setOpacity(0.4);
        temp.getChildren().add(imageView) ;
//        textFields
        TextField textKey = new TextField() ;
        textKey.setPrefWidth(150);
        textKey.setPrefHeight(40);
        temp.getChildren().add(textKey) ;
        textKey.setLayoutX(140);
        textKey.setLayoutY(20);
        Text keyName = new Text("key") ;
        temp.getChildren().add(keyName) ;
        keyName.setLayoutX(20);
        keyName.setLayoutY(20);
//
        List<TextField> textFields = new ArrayList<>() ;
        for (int i = 0 ; i < bpTree.getColumnNames().size() ; i++) {
            TextField textField = new TextField() ;
            textField.setPrefWidth(150);
            textField.setPrefHeight(40);
            temp.getChildren().add(textField) ;
            textField.setLayoutX(140);
            textField.setLayoutY(10 + (i+1) * 50);
            textFields.add(textField);
            Text text = new Text(bpTree.getColumnNames().get(i)) ;
            temp.getChildren().add(text) ;
            text.setLayoutX(20);
            text.setLayoutY(30 + (i+1) * 50);
        }
        Button send = new Button("send") ;
        send.setPrefWidth(50);
        send.setPrefHeight(20);
        temp.getChildren().add(send) ;
        send.setLayoutX(200);
        send.setLayoutY(70 + bpTree.getColumnNames().size() * 50);
        Button cancel = new Button("cancel") ;
        cancel.setPrefWidth(50);
        cancel.setPrefHeight(20);
        temp.getChildren().add(cancel) ;
        cancel.setLayoutX(50);
        cancel.setLayoutY(70 + bpTree.getColumnNames().size() * 50);
        pane.getChildren().add(temp) ;
        temp.setLayoutX(500);
        temp.setLayoutY(200);
        send.setOnMouseClicked(event1 -> {
            boolean full = true ;
            for (int i = 0 ; i < textFields.size() ; i++) {
                if (textFields.get(i).getText().equals("")) {
                    full = false ;
                    break;
                }
            }
            if (textKey.getText().equals("")) {
                full = false ;
            }
            if (full) {
                Pack pack = new Pack(bpTree.getColumnNames().size()) ;
                for (int i= 0 ; i <bpTree.getColumnNames().size() ; i++) {
                    pack.addValue(textFields.get(i).getText());
                }
                bpTree.insert(keyName.getText() , pack);
                show(keyName.getText() , pack , bpTree.traverse().indexOf(keyName.getText()));
                temp.setVisible(false);
            } else {

            }
        });
        cancel.setOnMouseClicked(event1 -> {
            temp.setVisible(false);
        });
    }

    @FXML
    void addRowEntered(MouseEvent event) {
        addRow.setScaleX(1.1);
        addRow.setScaleY(1.1);
    }

    @FXML
    void addRowExited(MouseEvent event) {
        addRow.setScaleX(1);
        addRow.setScaleY(1);
    }
















//    ----------------------------------
    //    چاپ مقادیر اولیه درخت
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bpTree = HelloApplication.getTree();
        for (String column : bpTree.getColumnNames()) {
            System.out.println(column);
            Button button = new Button(column) ;
            row.getChildren().add(button) ;
            button.setPrefWidth(90);
            button.setPrefHeight(40);
            button.setLayoutX(bpTree.getColumnNames().indexOf(column) * 95);
            button.setLayoutY(0);
        }
        for (String key : bpTree.traverse()) {
            Pack pack = bpTree.search(key);
            show(key , pack, bpTree.traverse().indexOf(key));
        }
    }
//درخت بی تری مرتبط با این دیتا بیس
    private static BPTree<String, Pack> bpTree;
//    لیست سل ها یا همان تکست ها
    private List<Cell> cells = new ArrayList<>() ;
    public void show(String key , Pack pack, int n) {
        Button button = new Button(key) ;
        column.getChildren().add(button) ;
        button.setPrefWidth(90);
        button.setPrefHeight(40);
        button.setLayoutX(0);
        button.setLayoutY(40 + bpTree.traverse().indexOf(key) * 45);
//        نمایش سل ها
        for (int i = 0; i < pack.values.size(); i++) {
            Cell cell = new Cell(key, pack.values.get(i).toString() , 9);
            table.getChildren().add(cell);
            cell.setPrefWidth(90);
            cell.setPrefHeight(40);
            cell.setLayoutX(90 + i * 95);
            cell.setLayoutY(40 + n * 45);
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