package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import javax.swing.*;

public class Controller {

    @FXML
    private Button oneInputButton;

    @FXML
    private Button andGate;

    @FXML
    private Button orGate;

    @FXML
    private Button notGate;

    @FXML
    private Button nandGate;

    @FXML
    private Button norGate;

    @FXML
    private ChoiceBox inputList1;

    @FXML
    private ChoiceBox inputList2;

    /*
    @FXML
    private ChoiceBox inputList3;
*/

    @FXML
    private Text labelInput1;

    @FXML
    private Text labelInput2;

    /*
    @FXML
    private Text labelInput3;
*/

    @FXML
    private TextField outputSpace;

    @FXML
    private Button submitButton;

    Model model = new Model();

    public void initialize() {
        inputList1.getItems().add("zero");
        inputList1.getItems().add("one");

        inputList2.getItems().add("zero");
        inputList2.getItems().add("one");
        andGate.setDisable(true);
        orGate.setDisable(true);
        notGate.setDisable(true);
        nandGate.setDisable(true);
        norGate.setDisable(true);

        inputList1.setDisable(true);
        inputList2.setDisable(true);


        /*
        inputList3.getItems().add("zero");
        inputList3.getItems().add("one");
        */
    }

    @FXML private void oneInputButtonClicked()
    {
        andGate.setDisable(true);
        orGate.setDisable(true);
        notGate.setDisable(false);
        nandGate.setDisable(true);
        norGate.setDisable(true);

        inputList1.setDisable(false);
        inputList2.setDisable(false);

        inputList2.setVisible(false);
        //inputList3.setVisible(false);

        labelInput2.setVisible(false);
       // labelInput3.setVisible(false);



    }

    @FXML private void twoInputButtonClicked()
    {
        andGate.setDisable(false);
        orGate.setDisable(false);
        notGate.setDisable(true);
        nandGate.setDisable(false);
        norGate.setDisable(false);

        inputList1.setDisable(false);
        inputList2.setDisable(false);

        inputList1.setVisible(true);
        inputList2.setVisible(true);
       // inputList3.setVisible(false);

        labelInput2.setVisible(true);
      //  labelInput3.setVisible(false);

    }
/*
    @FXML private void threeInputButtonClicked()
    {
        andGate.setDisable(false);
        orGate.setDisable(false);
        notGate.setDisable(true);
        nandGate.setDisable(false);
        norGate.setDisable(false);

        inputList1.setVisible(true);
        inputList2.setVisible(true);
        inputList3.setVisible(true);

        labelInput2.setVisible(true);
        labelInput3.setVisible(true);

    }
*/
    Alert alert = new Alert(Alert.AlertType.WARNING);

    private void alertBox()
    {
        alert.setTitle("Warning!");
        alert.setHeaderText(null);
        alert.setContentText("Input1 or Input2 is not selected!");
        alert.showAndWait();
    }

    @FXML private void notButton(){
        if(inputList1.getSelectionModel().isEmpty())
        {
            alertBox();
            return;
        }
        outputSpace.setText(String.valueOf(model.notCalculation(model.transformToInt(inputList1.getValue().toString()))));
    }

    @FXML private void andButton(){
        if(inputList1.getSelectionModel().isEmpty() || inputList2.getSelectionModel().isEmpty())
        {
            alertBox();
            return;
        }
        outputSpace.setText(String.valueOf(model.andCalculation(model.transformToInt(inputList1.getValue().toString()), model.transformToInt(inputList2.getValue().toString()))));
    }

    @FXML private void orButton(){
        if(inputList1.getSelectionModel().isEmpty() || inputList2.getSelectionModel().isEmpty())
        {
            alertBox();
            return;
        }
        outputSpace.setText(String.valueOf(model.orCalculation(model.transformToInt(inputList1.getValue().toString()), model.transformToInt(inputList2.getValue().toString()))));
    }

    @FXML private void norButton(){
        if(inputList1.getSelectionModel().isEmpty() || inputList2.getSelectionModel().isEmpty())
        {
            alertBox();
            return;
        }
        outputSpace.setText(String.valueOf(model.norCalculation(model.transformToInt(inputList1.getValue().toString()), model.transformToInt(inputList2.getValue().toString()))));
    }

    @FXML private void nandButton(){
        if(inputList1.getSelectionModel().isEmpty() || inputList2.getSelectionModel().isEmpty())
        {
            alertBox();
            return;
        }
        outputSpace.setText(String.valueOf(model.nandCalculation(model.transformToInt(inputList1.getValue().toString()), model.transformToInt(inputList2.getValue().toString()))));
    }


}
