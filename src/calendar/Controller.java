package calendar;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;


public class Controller {


    @FXML
    private DatePicker datePicker ;
    @FXML
    private GridPane gridPane;
    @FXML
    private ComboBox<String> comboBox;




    public void initialize() {
        datePicker.setValue(LocalDate.now());

        headerDateUpdate();

        dateChangeEvent();

        viewSwitcherEvent();


    }




    private void dateChangeEvent(){
        datePicker.valueProperty().addListener((ov, oldValue, newValue) -> {
            headerDateUpdate();
        });
    }


    private void headerDateUpdate(){
        LocalDate date = datePicker.getValue();



        ObservableList<Node> gridPeneChildren = gridPane.getChildren();

        LocalDate startOfWeek = date.minusDays(date.getDayOfWeek().getValue() - 1);
        // Tygodniowy widok //FIXME refactor this make if or sumthing
        for(int i = 0; i<gridPeneChildren.size() -1; i++){
            TextField tf = (TextField)gridPeneChildren.get(i);
            tf.setText(startOfWeek.plusDays(i).toString());
        }
        // Misieczny widok
//        LocalDate date = today.minusDays(today.getDayOfMonth());

/*        for (int i = 0 ; i < gridPeneChildren.size() - 1; i++){

            TextField tf = (TextField)gridPeneChildren.get(i);
            tf.setText(date.plusDays(i).toString());
        }*/
    }


    private void viewSwitcherEvent(){
        comboBox.setOnAction((event) -> {
            String selectedItem = comboBox.getSelectionModel().getSelectedItem();

            if(selectedItem.equals("Month")){
                System.out.println("zmiena na month");
                monthView();

            }else{
                System.out.println("zmiana na week");
                weekView();
            }
        });
    }

    private void monthView(){
        for (int i = 2; i < 5; i++) {
            gridPane.addRow(i, new TextField(),new TextField(),new TextField(),new TextField(),new TextField(),new TextField(),new TextField());
        }
    }

    private void weekView(){

    }
}