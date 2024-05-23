package controller;

import java.net.URL;
import java.util.ResourceBundle;

import classes.operaciones;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


public class CalculatorController implements Initializable {
    public TextField Resultado;
    public Button Operar;
    public RadioButton Suma;
    public RadioButton Division;
    public RadioButton Resta;
    public RadioButton Multiplicacion;

    @FXML
    private TextField txtnum1;

    @FXML
    private TextField txtnum2;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ToggleGroup tg = new ToggleGroup();
        Suma.setToggleGroup(tg);
        Resta.setToggleGroup(tg);
        Multiplicacion.setToggleGroup(tg);
        Division.setToggleGroup(tg);

    }

    @FXML
    private void operar() {
        try{
            double num1 = Double.parseDouble(txtnum1.getText());
            double num2 = Double.parseDouble(txtnum2.getText());

            operaciones oper = new operaciones(num1, num2);

            if(Suma.isSelected()){
                Resultado.setText(String.valueOf(oper.sumar()));
            }else if(Resta.isSelected()){
                Resultado.setText(String.valueOf(oper.restar()));
            }else if(Multiplicacion.isSelected()){
                Resultado.setText(String.valueOf(oper.multiplicar()));
            }else if(Division.isSelected()){
                if (num2 == 0){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("No se puede dividir un numero entre 0");
                    alert.showAndWait();
                } else {
                    Resultado.setText(String.valueOf(oper.dividir()));
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Seleccione una operación");
                alert.showAndWait();
            }

        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }

    }

}
