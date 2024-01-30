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
import java.util.regex.Pattern;

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
    //    متغیری که اجازه نمیدهد دو فرایند با هم انجام شوند
    private boolean onWorking = false;

    //    توابع ایکون خروج
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
//    توابع ایکون سرچ
    @FXML
    void searchClicked(MouseEvent event) {
        String word = fieldText.getText();
        if (!word.equals("") && !onWorking) {
            onWorking = true;
            Pack pack = bpTree.search(word);
            int n = bpTree.getColumnNames().size();
            Pane temp = new Pane();
            temp.setPrefWidth(n * 100 + 70);
            temp.setPrefHeight(80);
            pane.getChildren().add(temp);
            temp.setLayoutX(500);
            temp.setLayoutY(300);
            ImageView imageView = new ImageView(new Image(HelloApplication.class.getResource("color1.png").toString()));
            imageView.setFitWidth(n * 100 + 70);
            imageView.setFitHeight(80);
            imageView.setOpacity(0.4);
            temp.getChildren().add(imageView);
            if (pack != null) {
                for (int i = 0; i < n; i++) {
                    Button button = new Button(pack.values.get(i).toString());
                    button.setPrefWidth(90);
                    button.setPrefHeight(40);
                    temp.getChildren().add(button);
                    button.setLayoutX(10 + i * 100);
                    button.setLayoutY(20);
                }
            } else {
                Text textError = new Text("not Found");
                textError.setTabSize(20);
                temp.getChildren().add(textError);
                temp.setLayoutX(100);
                temp.setLayoutY(10);
            }
            ImageView closeIcon = new ImageView(new Image(HelloApplication.class.getResource("close.png").toString()));
            closeIcon.setFitWidth(40);
            closeIcon.setFitHeight(40);
            temp.getChildren().add(closeIcon);
            closeIcon.setLayoutX(n * 100 + 10);
            closeIcon.setLayoutY(20);
            closeIcon.setOnMouseClicked(event1 -> {
                onWorking = false;
                temp.setVisible(false);
                fieldText.setText("");
            });
            closeIcon.setOnMouseEntered(event1 -> {
                closeIcon.setScaleX(1.1);
                closeIcon.setScaleY(1.1);
            });
            closeIcon.setOnMouseExited(event1 -> {
                closeIcon.setScaleX(1);
                closeIcon.setScaleY(1);
            });
        }
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

    //    توابع ایکون اضافه کردن ستون (دخیره مقدار اضافه)
    @FXML
    void addColumnClicked(MouseEvent event) {
        if (!onWorking) {
            onWorking = true;
            Pane temp = new Pane();
            temp.setPrefWidth(300);
            temp.setPrefHeight(200);
            ImageView imageView = new ImageView(new Image(HelloApplication.class.getResource("color1.png").toString()));
            imageView.setFitWidth(300);
            imageView.setFitHeight(200);
            imageView.setOpacity(0.4);
            temp.getChildren().add(imageView);
//        textFields
            TextField columnName = new TextField();
            columnName.setPrefWidth(150);
            columnName.setPrefHeight(40);
            temp.getChildren().add(columnName);
            columnName.setLayoutX(140);
            columnName.setLayoutY(20);
            TextField columnType = new TextField();
            columnType.setPrefWidth(75);
            columnType.setPrefHeight(40);
            temp.getChildren().add(columnType);
            columnType.setLayoutX(30);
            columnType.setLayoutY(20);
            Text keyName = new Text("name of your column");
            temp.getChildren().add(keyName);
            keyName.setLayoutX(20);
            keyName.setLayoutY(20);
//
            Button send = new Button("send");
            send.setPrefWidth(50);
            send.setPrefHeight(20);
            temp.getChildren().add(send);
            send.setLayoutX(200);
            send.setLayoutY(100);
            Button cancel = new Button("cancel");
            cancel.setPrefWidth(50);
            cancel.setPrefHeight(20);
            temp.getChildren().add(cancel);
            cancel.setLayoutX(50);
            cancel.setLayoutY(100);
            pane.getChildren().add(temp);
            temp.setLayoutX(500);
            temp.setLayoutY(200);
            send.setOnMouseClicked(event1 -> {
                String name = columnName.getText();
                if (!name.equals("")) {
                    Type type = RegexClass.gettype(columnType.getText());
                    if (type != null) {
                        bpTree.addColumnName(name, type);
                        showRowBar(name);
                        for (int i = 0; i < bpTree.getSize(); i++) {
                            Button button = new Button();
                            table.getChildren().add(button);
                            button.setPrefWidth(90);
                            button.setPrefHeight(40);
                            button.setLayoutX(bpTree.getColumnNames().indexOf(name) * 95 + 90);
                            button.setLayoutY(40 + i * 45);
                            bpTree.getPacks().get(i).addMax();
                            bpTree.getPacks().get(i).addValue(" "); ;
                        }
                        onWorking = false;
                        temp.setVisible(false);
                    } else {
                        keyName.setText("your type is not correct");
                    }
                }
            });
            cancel.setOnMouseClicked(event1 -> {
                temp.setVisible(false);
                onWorking = false;
            });
        }
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

    //    توابع ایکون اضافه کردن سطر (کاربر جدید یا نود)
    @FXML
    void addRowClicked(MouseEvent event) {
        if (!onWorking) {
            onWorking = true;
            Pane temp = new Pane();
            temp.setPrefWidth(300);
            temp.setPrefHeight((bpTree.getColumnNames().size() + 1) * 50);
            ImageView imageView = new ImageView(new Image(HelloApplication.class.getResource("color1.png").toString()));
            imageView.setFitWidth(300);
            imageView.setFitHeight((bpTree.getColumnNames().size() + 2) * 50 + 20);
            imageView.setOpacity(0.4);
            temp.getChildren().add(imageView);
//        textFields
            TextField textKey = new TextField();
            textKey.setPrefWidth(150);
            textKey.setPrefHeight(40);
            temp.getChildren().add(textKey);
            textKey.setLayoutX(140);
            textKey.setLayoutY(10);
            Text keyName = new Text("key");
            temp.getChildren().add(keyName);
            keyName.setLayoutX(20);
            keyName.setLayoutY(10);
//
            List<TextField> textFields = new ArrayList<>();
            for (int i = 0; i < bpTree.getColumnNames().size(); i++) {
                TextField textField = new TextField();
                textField.setPrefWidth(150);
                textField.setPrefHeight(40);
                temp.getChildren().add(textField);
                textField.setLayoutX(140);
                textField.setLayoutY(10 + (i + 1) * 50);
                textFields.add(textField);
                Text text = new Text(bpTree.getColumnNames().get(i));
                temp.getChildren().add(text);
                text.setLayoutX(20);
                text.setLayoutY(30 + (i + 1) * 50);
            }
            Button send = new Button("send");
            send.setPrefWidth(50);
            send.setPrefHeight(20);
            temp.getChildren().add(send);
            send.setLayoutX(200);
            send.setLayoutY(70 + bpTree.getColumnNames().size() * 50);
            Button cancel = new Button("cancel");
            cancel.setPrefWidth(50);
            cancel.setPrefHeight(20);
            temp.getChildren().add(cancel);
            cancel.setLayoutX(50);
            cancel.setLayoutY(70 + bpTree.getColumnNames().size() * 50);
            pane.getChildren().add(temp);
            temp.setLayoutX(500);
            temp.setLayoutY(200);
            send.setOnMouseClicked(event1 -> {
//                چک میکنه حتما همه فیلد ها پر شده باشن
                boolean full = true;
                for (TextField textField : textFields) {
                    if (textField.getText().equals("")) {
                        full = false;
                        break;
                    }
                }
                if (textKey.getText().equals("")) {
                    full = false;
                }

//
                if (full) {
                    Pack pack = new Pack(bpTree.getColumnNames().size());
                    for (TextField textField : textFields) {
                        pack.addValue(textField.getText());
                    }
//                چک میکنه فیلد ها با مقادیر درستی پر شده باشن
                    boolean correct = true;
                    int i = 0 ;
                    for (Type type : bpTree.getTypes()) {
                        if (!pack.values.get(i).equals(type)) {
                            correct = false ;
                            break;
                        }
                        i++ ;
                    }
                    if (correct) {
                        bpTree.insert(textKey.getText(), pack);
                        showCellsRow(textKey.getText(), pack, bpTree.getSize() - 1);
                        temp.setVisible(false);
                        onWorking = false;
                    } else {
                        textKey.setText("your type is not correct");
                    }
                }
            });
            cancel.setOnMouseClicked(event1 -> {
                temp.setVisible(false);
                onWorking = false;
            });
        }
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
            showRowBar(column);
        }
        makeFullTable();
    }

    //درخت بی تری مرتبط با این دیتا بیس
    private static BPTree<String, Pack> bpTree;
    //    لیست سل ها یا همان تکست ها
    private List<Cell> cells = new ArrayList<>();

    private void makeFullTable() {
        for (String key : bpTree.traverse()) {
            Pack pack = bpTree.search(key);
            int n = bpTree.traverse().indexOf(key) ;
            showCellsRow(key, pack, n);
            System.out.println(n);
        }
    }

    public void showRowBar(String column) {
        Button button = new Button(column);
        row.getChildren().add(button);
        button.setPrefWidth(90);
        button.setPrefHeight(40);
        button.setLayoutX(bpTree.getColumnNames().indexOf(column) * 95);
        button.setLayoutY(0);
    }

    public void showCellsRow(String key, Pack pack, int n) {
        Button button = new Button(key);
        column.getChildren().add(button);
        button.setPrefWidth(90);
        button.setPrefHeight(40);
        button.setLayoutX(0);
        button.setLayoutY(40 + n * 45);
//        نمایش سل ها
        for (int i = 0; i < pack.values.size(); i++) {
            Cell cell = new Cell(key, pack.values.get(i).toString(), i);
            table.getChildren().add(cell);
            cell.setPrefWidth(90);
            cell.setPrefHeight(40);
            cell.setLayoutX(90 + i * 95);
            cell.setLayoutY(40 + n * 45);
            cells.add(cell);
            cell.setOnMouseClicked(event -> {
                selectedCell = cell;
            });
        }
    }

    //در صورت انتخاب یک سل ان به حالت سلکت شده در می اید
    private Cell selectedCell;

    //    مربوط به فرایند حذف که باگ داشت
    private void easyDelete() {
        if (!onWorking) {
            onWorking = true;
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
                String key = (String) selectedCell.getKey();
                List<Cell> del = new ArrayList<>();
                for (Cell cell : cells) {
                    if (cell.getKey().equals(key)) {
                        table.getChildren().remove(cell);
                        del.add(cell);
                    }
                }
                for (Cell cell : del) {
                    cells.remove(cell);
                }
                bpTree.delete((String) selectedCell.getKey());
                selectedCell = null;
                onWorking = false;
                temp.setVisible(false);
            });
            buttonCancel.setOnMouseClicked(event -> {
                pane.getChildren().remove(temp);
                selectedCell = null;
                onWorking = false;
            });
        }
    }

}