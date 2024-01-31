package com.example.demo;

import com.example.demo.impelementation.BPTree;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class DatabaseController implements Initializable {
    //    شکال و ابزارک هایی که در صفحه هستند
    @FXML
    private AnchorPane pane;
    @FXML
    private Text databaseName;
    @FXML
    private Button patternButton;
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
    void closeClicked(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
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
//    توابع ایکون دیلیت
    @FXML
    void deleteClicked(MouseEvent event) {
        if (selectedCell != null && !onWorking) {
            paneDelete.setVisible(true);
            onWorking = true ;
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
            ImageView imageView = new ImageView(new Image(HelloApplication.class.getResource("color2.png").toString()));
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
            paneAddColumn.setVisible(true);
            onWorking = true ;
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
            ImageView imageView = new ImageView(new Image(HelloApplication.class.getResource("color2.png").toString()));
            imageView.setFitWidth(300);
            imageView.setFitHeight((bpTree.getColumnNames().size() + 2) * 50 + 20);
            imageView.setOpacity(0.4);
            temp.getChildren().add(imageView);
            Text addRowInfo = new Text("enter your information");
            temp.getChildren().add(addRowInfo);
            addRowInfo.setLayoutX(40);
            addRowInfo.setLayoutY(40);
//               textFields
            List<TextField> textFields = new ArrayList<>();
            for (int i = 0; i < bpTree.getColumnNames().size(); i++) {
                TextField textField = new TextField();
                textField.setPrefWidth(150);
                textField.setPrefHeight(40);
                temp.getChildren().add(textField);
                textField.setLayoutX(130);
                textField.setLayoutY(10 + (i + 1) * 50);
                textFields.add(textField);
                Text text = new Text(bpTree.getColumnNames().get(i));
                temp.getChildren().add(text);
                text.setLayoutX(40);
                text.setLayoutY(30 + (i + 1) * 50);
            }
            Button send = new Button("send");
            send.setPrefWidth(70);
            send.setPrefHeight(20);
            send.setStyle(patternButton.getStyle());
            temp.getChildren().add(send);
            send.setLayoutX(200);
            send.setLayoutY(70 + bpTree.getColumnNames().size() * 50);
            Button cancel = new Button("cancel");
            cancel.setPrefWidth(70);
            cancel.setPrefHeight(20);
            cancel.setStyle(patternButton.getStyle());
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


                if (full) {
                    Pack pack = new Pack(bpTree.getColumnNames().size());
                    for (TextField textField : textFields) {
                        pack.addValue(textField.getText());
                    }
//                چک میکنه فیلد ها با مقادیر درستی پر شده باشن
                    boolean correct = true;
//                    چک کردن برای ستون های یکتا
                    boolean uniqueCheck = true ;
                    int i = 0;
                    for (Type type : bpTree.getTypes()) {
                        switch (type) {
                            case dateT -> {
                                correct = RegexClass.checkDate((String) pack.values.get(i));
                            }
                            case stringT -> {
                                correct = RegexClass.checkString((String) pack.values.get(i));
                            }
                            case doubleT -> {
                                correct = RegexClass.checkDouble((String) pack.values.get(i));
                            }
                        }
                        if (!correct ) {
                            break;
                        }

                        if (bpTree.getUnique(i)) {
                            for (String key : bpTree.traverse()) {
                                Object ob = bpTree.search(key).values.get(i) ;
                                if (pack.values.get(i).equals(ob)) {
                                    uniqueCheck = false ;
                                    break;
                                }
                            }
                        }
                        if (!uniqueCheck ) {
                            break;
                        }
                        i++;
                    }



                    if (correct) {
                        if (uniqueCheck) {
                            String index = String.valueOf(myIndex);
                            myIndex ++ ;
                            bpTree.insert(index, pack);
                            showCellsRow(index, pack, bpTree.getSize() - 1);
                            temp.setVisible(false);
                            onWorking = false;
                        } else {
                            addRowInfo.setText("your input is repetitious");
                        }
                    } else {
                        addRowInfo.setText("your type is not correct");
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
//    صفحات مربوط به حذف ایتم و اضاضفه کردن ستون

    @FXML
    private Pane paneAddColumn;
    @FXML
    private TextField addColumnField;
    @FXML
    private ImageView okAddColumn;
    @FXML
    private ImageView cancelAddColumn;
    private Type newColumnType = null ;
    private boolean unique = false ;
    @FXML
    private Button dataPattern;
    @FXML
    private Button numberPattern;
    @FXML
    private Button stringPattern;
    @FXML
    private Button uniqueButton;
    @FXML
    private ImageView uniqueLight;
    @FXML
    private Pane paneDelete;
    @FXML
    private Button okAllDelete;
    @FXML
    private ImageView okDelete;
    @FXML
    private ImageView cancelDelete;
    @FXML
    void okAddColumnClicked(MouseEvent event) {
        String name = addColumnField.getText();
        if (!name.equals("")) {
            if (newColumnType != null) {
                bpTree.addColumnName(name, newColumnType , unique);
                showRowBar(name);
                for (int i = 0; i < bpTree.getSize(); i++) {
                    Cell cell = new Cell(bpTree.traverse().get(i), "", bpTree.getColumnNames().size()-1);
                    table.getChildren().add(cell);
                    cell.setPrefWidth(90);
                    cell.setPrefHeight(40);
                    cell.setLayoutX(bpTree.getColumnNames().indexOf(name) * 95 + 90);
                    cell.setLayoutY(40 + i * 45);
                    cell.setStyle(patternButton.getStyle());
                    cells.add(cell);
                    bpTree.getPacks().get(i).addMax();
                    bpTree.getPacks().get(i).addValue(" ");
                    cell.setOnMouseClicked(event2 -> {
                        selectedCell = cell;
                    });
                }
                onWorking = false;
                paneAddColumn.setVisible(false);
                addColumnField.setText("");
                newColumnType = null ;
                unique = false ;
                uniqueLight.setVisible(false);
            }
        }
    }

    @FXML
    void okAddColumnEntered(MouseEvent event) {
        okAddColumn.setScaleX(1.1);
        okAddColumn.setScaleY(1.1);
    }

    @FXML
    void okAddColumnExited(MouseEvent event) {
        okAddColumn.setScaleX(1);
        okAddColumn.setScaleY(1);
    }
    @FXML
    void cancelAddColumnClicked(MouseEvent event) {
        addColumnField.setText("");
        onWorking = false ;
        paneAddColumn.setVisible(false);
        newColumnType = null ;
        unique = false ;
    }
    @FXML
    void cancelAddColumnEntered(MouseEvent event) {
        cancelAddColumn.setScaleX(1.1);
        cancelAddColumn.setScaleY(1.1);
    }
    @FXML
    void cancelAddColumnExited(MouseEvent event) {
        cancelAddColumn.setScaleX(1);
        cancelAddColumn.setScaleY(1);
    }
    @FXML
    void dataClicked(MouseEvent event) {
        newColumnType = Type.dateT ;
    }
    @FXML
    void numberClicked(MouseEvent event) {
        newColumnType = Type.doubleT ;
    }

    @FXML
    void stringClicked(MouseEvent event) {
        newColumnType = Type.stringT ;
    }

    @FXML
    void uniqueClicked(MouseEvent event) {
        unique = !unique ;
        uniqueLight.setVisible(unique);
    }
//    delete on new pane
    @FXML
    void okDeleteAllClicked(MouseEvent event) {
        String key = (String) selectedCell.getKey();
        List<Cell> del = new ArrayList<>();
        for (Cell cell : cells) {
            if (cell.getKey().equals(key)) {
                del.add(cell);
            }
            table.getChildren().remove(cell);
        }
        for (Cell cell : del) {
            cells.remove(cell);
        }
        bpTree.delete((String) selectedCell.getKey());
        selectedCell = null;
        onWorking = false;
        paneDelete.setVisible(false);

        column.getChildren().clear();     //remove all IDs

        for (int i = 0; i < bpTree.getSize(); i++) {    //show items after deleting a row
            String key1 = bpTree.traverse().get(i);
            showCellsRow(key1, bpTree.search(key1), i);
        }
    }
    @FXML
    void okDeleteClicked(MouseEvent event) {
        String key = (String) selectedCell.getKey();
        selectedCell.setText("");
        bpTree.search(key).values.remove(selectedCell.getColum()) ;
        selectedCell = null;
        onWorking = false;
        paneDelete.setVisible(false);
    }
    @FXML
    void okDeleteEntered(MouseEvent event) {
        okDelete.setScaleX(1.1);
        okDelete.setScaleY(1.1);
    }
    @FXML
    void okDeleteExited(MouseEvent event) {
        okDelete.setScaleX(1);
        okDelete.setScaleY(1);
    }

    @FXML
    void cancelDeleteClicked(MouseEvent event) {
        paneDelete.setVisible(false);
        selectedCell = null ;
        onWorking = false ;
    }

    @FXML
    void cancelDeleteEntered(MouseEvent event) {
        cancelDelete.setScaleX(1.1);
        cancelDelete.setScaleY(1.1);
    }

    @FXML
    void cancelDeleteExited(MouseEvent event) {
        cancelDelete.setScaleX(1);
        cancelDelete.setScaleY(1);
    }

    //    ----------------------------------
    //    چاپ مقادیر اولیه درخت
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paneAddColumn.setVisible(false);
        paneDelete.setVisible(false);
        bpTree = HelloController.getSelectedTree();
        for (String column : bpTree.getColumnNames()) {
            showRowBar(column);
        }
        makeFullTable();
    }

    //درخت بی تری مرتبط با این دیتا بیس
    private static BPTree<String, Pack> bpTree;
    //در صورت انتخاب یک سل ان به حالت سلکت شده در می اید
    private Cell selectedCell;
    //    لیست سل ها یا همان تکست ها
    private List<Cell> cells = new ArrayList<>();

    private static int myIndex = 0 ;

    private void makeFullTable() {
        for (String key : bpTree.traverse()) {
            Pack pack = bpTree.search(key);
            int n = bpTree.traverse().indexOf(key);
            showCellsRow(key, pack, n);
        }
    }

    public void showRowBar(String column) {
        Button button = new Button(column);
        row.getChildren().add(button);
        button.setPrefWidth(90);
        button.setPrefHeight(40);
        button.setLayoutX(bpTree.getColumnNames().indexOf(column) * 95 + 90);
        button.setLayoutY(0);
        button.setStyle(patternButton.getStyle());
    }

    public void showCellsRow(String key, Pack pack, int n) {
        Button button = new Button(key);
        column.getChildren().add(button);
        button.setPrefWidth(90);
        button.setPrefHeight(40);
        button.setLayoutX(0);
        button.setLayoutY(n * 45);
        button.setStyle(patternButton.getStyle());

//        نمایش سل ها
        for (int i = 0; i < pack.values.size(); i++) {
            Cell cell = new Cell(key, pack.values.get(i).toString(), i);
            table.getChildren().add(cell);
            cell.setPrefWidth(90);
            cell.setPrefHeight(40);
            cell.setLayoutX(90 + i * 95);
            cell.setLayoutY(40 + n * 45);
            cells.add(cell);
            cell.setStyle(patternButton.getStyle());
            cell.setOnMouseClicked(event -> {
                selectedCell = cell;
            });
        }
    }

}