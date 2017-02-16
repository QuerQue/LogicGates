package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private ImageView indicator;

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
        inputList2.setDisable(true);
        inputList3.setDisable(true);

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
        inputList3.setDisable(true);

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

    private static final String IMAGE1 = "greenbulb.png";

    @FXML private void notButton(){
        //check if any input option was selected (1 or 0)
        if(inputList1.getSelectionModel().isEmpty())
        {
            alertBox();
            return;
        }

        //result od NOT gate
        int calculationResult = model.notCalculation(model.transformToInt(inputList1.getValue().toString()));

        //set result to output text area
        outputSpace.setText(String.valueOf(calculationResult));

        //if returned value is 1, light the green bulb, otherwise the red one
        if(calculationResult == 1)
            indicator.setImage(new Image(getClass().getResource("greenbulb.png").toExternalForm()));
        else
            indicator.setImage(new Image(getClass().getResource("redbulb.png").toExternalForm()));
    }

    @FXML private void andButton(){
        //check which button was clicked, 2 or 3 inputs and if any option was selected, if not alertBox is showed
        if(flag==2 && (inputList1.getSelectionModel().isEmpty()
                        || inputList2.getSelectionModel().isEmpty()))
        {
            alertBox();
            return;
        }
        else if(flag==3 && (inputList1.getSelectionModel().isEmpty()
                            || inputList2.getSelectionModel().isEmpty()
                            || inputList3.getSelectionModel().isEmpty()))
        {
            alertBox();
            return;
        }

        int calculationResult=0; //result of calculation AND gate

        if(flag==2) // check which button was clicked, 2 inputs or 3 inputs (different method is call)
        {
            calculationResult = model.andCalculation(
                    model.transformToInt(inputList1.getValue().toString()),
                    model.transformToInt(inputList2.getValue().toString()));

            outputSpace.setText(String.valueOf(calculationResult));
        }
        else if(flag==3)
        {
            calculationResult = model.andCalculation(
                    model.transformToInt(inputList1.getValue().toString()),
                    model.transformToInt(inputList2.getValue().toString()),
                    model.transformToInt(inputList3.getValue().toString()));

            outputSpace.setText(String.valueOf(calculationResult));
        }

        if(calculationResult == 1)
            indicator.setImage(new Image(getClass().getResource("greenbulb.png").toExternalForm()));
        else
            indicator.setImage(new Image(getClass().getResource("redbulb.png").toExternalForm()));
    }

    @FXML private void orButton(){
        if(flag==2 && (inputList1.getSelectionModel().isEmpty() || inputList2.getSelectionModel().isEmpty()))
        {
            alertBox();
            return;
        }
        else if(flag==3 && (inputList1.getSelectionModel().isEmpty()
                            || inputList2.getSelectionModel().isEmpty()
                            || inputList3.getSelectionModel().isEmpty()))
        {
            alertBox();
            return;
        }

        int calculationResult=0;

        if(flag==2)
        {
            calculationResult = model.orCalculation(
                    model.transformToInt(inputList1.getValue().toString()),
                    model.transformToInt(inputList2.getValue().toString()));

            outputSpace.setText(String.valueOf(calculationResult));
        }
        else if(flag==3)
        {
            calculationResult = model.orCalculation(
                    model.transformToInt(inputList1.getValue().toString()),
                    model.transformToInt(inputList2.getValue().toString()),
                    model.transformToInt(inputList3.getValue().toString()));

            outputSpace.setText(String.valueOf(calculationResult));
        }

        if(calculationResult == 1)
            indicator.setImage(new Image(getClass().getResource("greenbulb.png").toExternalForm()));
        else
            indicator.setImage(new Image(getClass().getResource("redbulb.png").toExternalForm()));
    }

    @FXML private void norButton(){
        if(flag==2 && (inputList1.getSelectionModel().isEmpty() || inputList2.getSelectionModel().isEmpty()))
        {
            alertBox();
            return;
        }
        else if(flag==3 && (inputList1.getSelectionModel().isEmpty()
                            || inputList2.getSelectionModel().isEmpty()
                            || inputList3.getSelectionModel().isEmpty()))
        {
            alertBox();
            return;
        }

        int calculationResult=0;

        if(flag==2)
        {
            calculationResult = model.norCalculation(
                    model.transformToInt(inputList1.getValue().toString()),
                    model.transformToInt(inputList2.getValue().toString()));

            outputSpace.setText(String.valueOf(calculationResult));
        }
        else if(flag==3)
        {
            calculationResult = model.norCalculation(
                    model.transformToInt(inputList1.getValue().toString()),
                    model.transformToInt(inputList2.getValue().toString()),
                    model.transformToInt(inputList3.getValue().toString()));

            outputSpace.setText(String.valueOf(calculationResult));
        }

        if(calculationResult == 1)
            indicator.setImage(new Image(getClass().getResource("greenbulb.png").toExternalForm()));
        else
            indicator.setImage(new Image(getClass().getResource("redbulb.png").toExternalForm()));
    }

    @FXML private void nandButton(){
        if(flag==2 && (inputList1.getSelectionModel().isEmpty() || inputList2.getSelectionModel().isEmpty()))
        {
            alertBox();
            return;
        }
        else if(flag==3 && (inputList1.getSelectionModel().isEmpty()
                            || inputList2.getSelectionModel().isEmpty()
                            || inputList3.getSelectionModel().isEmpty()))
        {
            alertBox();
            return;
        }

        int calculationResult=0;

        if(flag==2)
        {
            calculationResult = model.nandCalculation(
                    model.transformToInt(inputList1.getValue().toString()),
                    model.transformToInt(inputList2.getValue().toString()));

            outputSpace.setText(String.valueOf(calculationResult));
        }
        else if(flag==3)
        {
            calculationResult = model.nandCalculation(
                    model.transformToInt(inputList1.getValue().toString()),
                    model.transformToInt(inputList2.getValue().toString()),
                    model.transformToInt(inputList3.getValue().toString()));

            outputSpace.setText(String.valueOf(calculationResult));
        }

        if(calculationResult == 1)
            indicator.setImage(new Image(getClass().getResource("greenbulb.png").toExternalForm()));
        else
            indicator.setImage(new Image(getClass().getResource("redbulb.png").toExternalForm()));
    }


}
