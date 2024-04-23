package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainViewController {

    @FXML
    private Label prevnum;

    @FXML
    private Label result;

    @FXML
    private Button Clearbtn;

    private double num1 = 0;
    private double total = 0;
    private String operator = "";
    private boolean check = true;




    public void computeProcess(ActionEvent event) {

        if(check) {

         result.setText("");
         prevnum.setText("");

         check = false;

        }

        Button button = (Button)event.getSource();

        String value = button.getText();

        number(value);
        prevnumber(value);

    }

    public void number(String number){

        result.setText(result.getText() + number);

    }

    public void prevnumber(String number) {

       prevnum.setText(prevnum.getText() + number);

    }

    public void prevOperator(String Operator){
        prevnum.setText(prevnum.getText() + " " + operator + " ");

    }

    public void clear(ActionEvent event){

        if(event.getSource() == Clearbtn){

            result.setText("0");
            prevnum.setText("0");
        }


    }


    public void exit(){
        System.exit(0);
    }


    public void operatorProcess(ActionEvent event){

        Button button = (Button)event.getSource();
        String value = button.getText();

        if(!value.equals("=")){

            if(!operator.isEmpty())
                return;

            operator = value;
            prevOperator(operator);
            num1 = Double.parseDouble(result.getText());
            result.setText("");


        }else{

            if(operator.isEmpty())
                return;

            double num2 = Double.parseDouble(result.getText());

            total = create(num1, num2, operator);

            result.setText(String.valueOf(total));

            operator = "";
            check = true;

        }


    }


    public Double create(Double num1, double num2, String op) {

        switch (op) {
            case "+":
                return (num1 + num2);
            case "-":
                return (num1 - num2);
            case "*":
                return (num1 * num2);
            case "/":
                if (num2 == 0)
                    return 0.0;
                    return (num1 / num2);
        default:
             break;
        }
        return 0.0;
    }


}



