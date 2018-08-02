package calendar.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;


public class Controller {
    @FXML
    private DatePicker datePicker;
    @FXML
    private GridPane gridPane;
    @FXML
    private ComboBox<String> comboBox;

    //Fixme Keeps view info cuz I cant get info directly from comboBox cuz it doesnt keep it's value. It's one time event sending info ): duno how to handle this now
    static private String state = "Week";





    
    public void initialize() {
        datePicker.setValue(LocalDate.now());

        dateUpdate();

        dateChangeEvent();

        viewSwitcherEvent();


    }









    private void dateChangeEvent() {
        datePicker.valueProperty().addListener((ov, oldValue, newValue) -> {
            dateUpdate();
        });
    }


    private void dateUpdate() {
        String selectedView = comboBox.getSelectionModel().getSelectedItem();
        LocalDate chosenDate = datePicker.getValue();


        if(("Month").equals(state)){
            insertDataIntoTextFields(chosenDate.minusDays(chosenDate.getDayOfMonth()));
        }else{
            insertDataIntoTextFields(chosenDate.minusDays(chosenDate.getDayOfWeek().getValue()-1));
        }

    }

    private void insertDataIntoTextFields(LocalDate date){
        ObservableList<Node> gridPeneChildren = gridPane.getChildren();
        for (int i = 0 ; i < gridPeneChildren.size() - 1; i++){
            TextField tf = (TextField)gridPeneChildren.get(i);
            tf.setText(date.plusDays(i).toString());
        }
    }

    
    
    
    
    

    private void viewSwitcherEvent() {
        comboBox.setOnAction((event) -> {
            String selectedItem = comboBox.getSelectionModel().getSelectedItem();
            
            state = selectedItem;

            try {
                changeView(selectedItem);
            } catch (IOException e) {
                System.out.println(e);
            }
        });
    }

    private void changeView(String fxmlFileName) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) comboBox.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../views/" + fxmlFileName + "View" + ".fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}