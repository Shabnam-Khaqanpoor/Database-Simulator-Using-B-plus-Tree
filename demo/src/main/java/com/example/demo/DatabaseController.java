package com.example.demo;

import com.example.demo.impelementation.BPTree;
import javafx.event.ActionEvent;
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
    private AnchorPane pane; // main pane
    @FXML
    private Button patternButton;
    @FXML
    private ImageView close; // close icon
    @FXML
    private ImageView delete; // delete icon
    @FXML
    private ImageView edite; // edite icon
    @FXML
    private ImageView addColumn; // icon for add a column to table
    @FXML
    private ImageView addRow; // icon for add a row to table
    @FXML
    private ImageView search; // search icon
    @FXML
    private TextField fieldText; // search field
    @FXML
    private Pane table; //pane for show the table information
    @FXML
    private Pane column; //pane for our index in the column 0
    @FXML
    private Pane row; // pane for our column name in the row 0

    //   close
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
//    delete
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

//    edite
    @FXML
    void editeClicked(MouseEvent event) {
        if (selectedCell != null && !onWorking) {
            paneEdite.setVisible(true);
            onWorking = true;
        }
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
//    search
    @FXML
    void searchEnterPressed(ActionEvent event) {
        if (!onWorking) {
            showSearchResult();
            onWorking = true ;
        }
    }
    @FXML
    void searchClicked(MouseEvent event) {
        if (!onWorking) {
            showSearchResult();
            onWorking = true ;
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
//    add column to table
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
//    add row to table
    @FXML
    void addRowClicked(MouseEvent event) {
        if (!onWorking) {
            if (bpTree.getColumnNames().size() > 0) {
                onWorking = true;
//            make a pane
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
                temp.setLayoutY(100);
                send.setOnMouseClicked(event1 -> {
//                check to be full all our fields
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
//                check to make full our fields with the correct data
                        boolean correct = true;
//                    check for unique columns in table
                        boolean uniqueCheck = true;
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
                            if (!correct) {
                                break;
                            }

                            if (bpTree.getUnique(i)) {
                                for (String key : bpTree.traverse()) {
                                    Object ob = bpTree.search(key).values.get(i);
                                    if (pack.values.get(i).equals(ob)) {
                                        uniqueCheck = false;
                                        break;
                                    }
                                }
                            }
                            if (!uniqueCheck) {
                                break;
                            }
                            i++;
                        }

                        if (correct) {
                            if (uniqueCheck) {
                                String index = String.valueOf(myIndex);
                                myIndex++;
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
//    pane delete and pane add column in the page
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
    private Pane paneEdite;
    @FXML
    private TextField editeField;
    @FXML
    private ImageView okEdite;
    @FXML
    private ImageView cancelEdite;
    @FXML
    private Pane paneDelete;
    @FXML
    private Button okAllDelete;
    @FXML
    private ImageView okDelete;
    @FXML
    private ImageView cancelDelete;

    @FXML
    void okAddEnterPressed(ActionEvent event) {
        showColumn();
    }
    @FXML
    void okAddColumnClicked(MouseEvent event) {
        showColumn();
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
//    edite
    @FXML
    void okEditeEnterPressed(ActionEvent event) {
        showEditeResult();
    }

    @FXML
    void okEditeClicked(MouseEvent event) {
        showEditeResult();
    }

    @FXML
    void okEditeEntered(MouseEvent event) {
        okEdite.setScaleX(1.1);
        okEdite.setScaleY(1.1);
    }
    @FXML
    void okEditeExited(MouseEvent event) {
        okEdite.setScaleX(1);
        okEdite.setScaleY(1);
    }
    @FXML
    void cancelEditeClicked(MouseEvent event) {
        paneEdite.setVisible(false);
        selectedCell = null ;
        onWorking = false ;
    }

    @FXML
    void cancelEditeEntered(MouseEvent event) {
        cancelEdite.setScaleX(1.1);
        cancelEdite.setScaleY(1.1);
    }

    @FXML
    void cancelEditeExited(MouseEvent event) {
        cancelEdite.setScaleX(1);
        cancelEdite.setScaleY(1);
    }

    //    delete
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
        bpTree.search(key).deleteValue(selectedCell.getColum());
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
        patternButton.setText(bpTree.getName());
        for (String column : bpTree.getColumnNames()) {
            showRowBar(column);
        }
        makeFullTable();
    }
    private static BPTree<String, Pack> bpTree;
    private List<Cell> cells = new ArrayList<>();
    private Cell selectedCell;
    private static int myIndex = 0 ;
    private boolean onWorking = false;

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
    public void showColumn () {
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
    public void showSearchResult () {
        String word = fieldText.getText();
        if (!word.equals("") && !onWorking) {
            int n = bpTree.getColumnNames().size();
//            make a pane
            Pane temp = new Pane();
            temp.setPrefWidth(n * 100 + 100);
            temp.setPrefHeight(80);
            pane.getChildren().add(temp);
            temp.setLayoutX(500);
            temp.setLayoutY(200);
            ImageView imageView = new ImageView(new Image(HelloApplication.class.getResource("color2.png").toString()));
            imageView.setFitWidth(n * 100 + 100);
            imageView.setFitHeight(80);
            imageView.setOpacity(0.4);
            temp.getChildren().add(imageView);
            Pack pack = bpTree.search(word);
//           find the answer and show
            if (pack != null) {
                for (int i = 0; i < n; i++) {
                    Button button = new Button(pack.values.get(i).toString());
                    button.setPrefWidth(90);
                    button.setPrefHeight(40);
                    temp.getChildren().add(button);
                    button.setLayoutX(20 + i * 100);
                    button.setLayoutY(20);
                }
            } else {
                Text textError = new Text("not Found");
                textError.setTabSize(20);
                temp.getChildren().add(textError);
                temp.setLayoutX(500);
                temp.setLayoutY(200);
            }
            ImageView closeIcon = new ImageView(new Image(HelloApplication.class.getResource("close.png").toString()));
            closeIcon.setFitWidth(40);
            closeIcon.setFitHeight(40);
            temp.getChildren().add(closeIcon);
            closeIcon.setLayoutX(n * 100 + 40);
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
    public void showEditeResult () {
        String word = editeField.getText() ;
        if (!word.equals("")) {
            int i = selectedCell.getColum() ;
            Type type = bpTree.getTypes().get(i) ;
            boolean correct = true ;
            boolean uniqueCheck = true ;
            switch (type) {
                case dateT -> {
                    correct = RegexClass.checkDate(word);
                }
                case stringT -> {
                    correct = RegexClass.checkString(word);
                }
                case doubleT -> {
                    correct = RegexClass.checkDouble(word);
                }
            }

            if (bpTree.getUnique(i)) {
                for (String key : bpTree.traverse()) {
                    Object ob = bpTree.search(key).values.get(i) ;
                    if (word.equals(ob)) {
                        uniqueCheck = false ;
                        break;
                    }
                }
            }
            if (correct && uniqueCheck) {
                selectedCell.setText(word);
                bpTree.search((String) selectedCell.getKey()).editeValue(i , word);
                paneEdite.setVisible(false);
                selectedCell = null ;
                onWorking = false ;
            }
        }
    }
}