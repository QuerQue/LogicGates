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

    @FXML
    private ChoiceBox inputList3;

    @FXML
    private Text labelInput1;

    @FXML
    private Text labelInput2;

    @FXML
    private Text labelInput3;

    @FXML
    private TextField outputSpace;

    @FXML
    private Button submitButton;

    int flag=0;

    Model model = new Model();

    public void initialize() {
        inputList1.getItems().add("0");
        inputList1.getItems().add("1");

        inputList2.getItems().add("0");
        inputList2.getItems().add("1");

        inputList3.getItems().add("0");
        inputList3.getItems().add("1");

        andGate.setDisable(true);
        orGate.setDisable(true);
        notGate.setDisable(true);
        nandGate.setDisable(true);
        norGate.setDisable(true);

        inputList1.setDisable(true);
        inputList2.setDisable(true);
        inputList3.setDisable(true);

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
        inputList3.setVisible(false);

        labelInput2.setVisible(false);
        labelInput3.setVisible(false);

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
        inputList3.setVisible(false);

        labelInput2.setVisible(true);
        labelInput3.setVisible(false);

        flag=2;
    }

    @FXML private void threeInputButtonClicked()
    {
        andGate.setDisable(false);
        orGate.setDisable(false);
        notGate.setDisable(true);
        nandGate.setDisable(false);
        norGate.setDisable(false);

        inputList1.setDisable(false);
        inputList2.setDisable(false);
        inputList3.setDisable(false);

        inputList1.setVisible(true);
        inputList2.setVisible(true);
        inputList3.setVisible(true);

        labelInput1.setVisible(true);
        labelInput2.setVisible(true);
        labelInput3.setVisible(true);

        flag=3;
    }

    Alert alert = new Alert(Alert.AlertType.WARNING);

    private void alertBox()
    {
        alert.setTitle("Warning!");
        alert.setHeaderText(null);
        alert.setContentText("One of inputs is not selected!");
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
        if(flag==2 && (inputList1.getSelectionModel().isEmpty() || inputList2.getSelectionModel().isEmpty()))
        {
            alertBox();
            return;
        }
        else if(flag==3 && (inputList1.getSelectionModel().isEmpty() || inputList2.getSelectionModel().isEmpty() || inputList3.getSelectionModel().isEmpty()))
        {
            alertBox();
            return;
        }

        if(flag==2)
            outputSpace.setText(String.valueOf(model.andCalculation(model.transformToInt(inputList1.getValue().toString()), model.transformToInt(inputList2.getValue().toString()))));
        else if(flag==3)
            outputSpace.setText(String.valueOf(model.andCalculation(
                    model.transformToInt(inputList1.getValue().toString()),
                    model.transformToInt(inputList2.getValue().toString()),
                    model.transformToInt(inputList3.getValue().toString())
            )));
    }

    @FXML private void orButton(){
        if(flag==2 && (inputList1.getSelectionModel().isEmpty() || inputList2.getSelectionModel().isEmpty()))
        {
            alertBox();
            return;
        }
        else if(flag==3 && (inputList1.getSelectionModel().isEmpty() || inputList2.getSelectionModel().isEmpty() || inputList3.getSelectionModel().isEmpty()))
        {
            alertBox();
            return;
        }
        if(flag==2)
            outputSpace.setText(String.valueOf(model.orCalculation(model.transformToInt(inputList1.getValue().toString()), model.transformToInt(inputList2.getValue().toString()))));
        else if(flag==3)
            outputSpace.setText(String.valueOf(model.orCalculation(
                    model.transformToInt(inputList1.getValue().toString()),
                    model.transformToInt(inputList2.getValue().toString()),
                    model.transformToInt(inputList3.getValue().toString())
            )));
    }

    @FXML private void norButton(){
        if(flag==2 && (inputList1.getSelectionModel().isEmpty() || inputList2.getSelectionModel().isEmpty()))
        {
            alertBox();
            return;
        }
        else if(flag==3 && (inputList1.getSelectionModel().isEmpty() || inputList2.getSelectionModel().isEmpty() || inputList3.getSelectionModel().isEmpty()))
        {
            alertBox();
            return;
        }
        if(flag==2)
            outputSpace.setText(String.valueOf(model.norCalculation(model.transformToInt(inputList1.getValue().toString()), model.transformToInt(inputList2.getValue().toString()))));
        else if(flag==3)
            outputSpace.setText(String.valueOf(model.norCalculation(
                    model.transformToInt(inputList1.getValue().toString()),
                    model.transformToInt(inputList2.getValue().toString()),
                    model.transformToInt(inputList3.getValue().toString())
            )));
    }

    @FXML private void nandButton(){
        if(flag==2 && (inputList1.getSelectionModel().isEmpty() || inputList2.getSelectionModel().isEmpty()))
        {
            alertBox();
            return;
        }
        else if(flag==3 && (inputList1.getSelectionModel().isEmpty() || inputList2.getSelectionModel().isEmpty() || inputList3.getSelectionModel().isEmpty()))
        {
            alertBox();
            return;
        }
        if(flag==2)
            outputSpace.setText(String.valueOf(model.nandCalculation(model.transformToInt(inputList1.getValue().toString()), model.transformToInt(inputList2.getValue().toString()))));
        else if(flag==3)
            outputSpace.setText(String.valueOf(model.nandCalculation(
                    model.transformToInt(inputList1.getValue().toString()),
                    model.transformToInt(inputList2.getValue().toString()),
                    model.transformToInt(inputList3.getValue().toString())
            )));
    }


}
