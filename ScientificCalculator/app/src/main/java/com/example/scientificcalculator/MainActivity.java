package com.example.scientificcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    TextView input, sign;

    private String first_value, second_value, sign_value;
    private boolean has_decimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        sign = findViewById(R.id.sign);
        has_decimal = false;
    }

    public void logOnClick(View view) {
        sign_value = "log";
        input.setText(null);
        sign.setText("log");
        has_decimal = false;
    }

    public void lnOnClick(View view) {
        sign_value = "ln";
        input.setText(null);
        sign.setText("ln");
        has_decimal = false;
    }

    public void expOnClick(View view) {
        sign_value = "power";
        first_value = input.getText().toString();
        input.setText(null);
        sign.setText("xⁿ");
        has_decimal = false;
    }

    public void sqrtOnClick(View view) {
        sign_value = "root";
        input.setText(null);
        sign.setText("√");
        has_decimal = false;
    }

    public void factorialOnClick(View view) {
        sign_value = "factorial";
        input.setText(null);
        sign.setText("!");
        has_decimal = false;
    }

    public void sinOnClick(View view) {
        sign_value = "sin";
        input.setText(null);
        sign.setText("sin");
        has_decimal = false;
    }

    public void cosOnClick(View view) {
        sign_value = "cos";
        input.setText(null);
        sign.setText("cos");
        has_decimal = false;
    }

    public void tanOnClick(View view) {
        sign_value = "tan";
        input.setText(null);
        sign.setText("tan");
        has_decimal = false;
    }

    public void sevenOnClick(View view) {
        input.setText(input.getText() + "7");
    }

    public void eightOnClick(View view) {
        input.setText(input.getText() + "8");
    }

    public void nineOnClick(View view) {
        input.setText(input.getText() + "9");
    }

    public void divOnClick(View view) {
        sign_value = "divide";
        first_value = input.getText().toString();
        input.setText(null);
        sign.setText("÷");
        has_decimal = false;
    }

    public void delOnClick(View view) {
        if(input.getText().equals(""))
            input.setText(null);
        else {
            int length = input.getText().length();
            String str = input.getText().toString();

            if(str.charAt(length - 1) == '.')
                has_decimal = false;
            input.setText(input.getText().subSequence(0, length - 1));
        }
    }

    public void fourOnClick(View view) {
        input.setText(input.getText() + "4");
    }

    public void fiveOnClick(View view) {
        input.setText(input.getText() + "5");
    }

    public void sixOnClick(View view) {
        input.setText(input.getText() + "6");
    }

    public void mulOnClick(View view) {
        sign_value = "multiply";
        first_value = input.getText().toString();
        input.setText(null);
        sign.setText("X");
        has_decimal = false;
    }

    public void clearOnClick(View view) {
        input.setText(null);
        sign.setText(null);
        has_decimal = false;
        first_value = null;
        second_value = null;
        sign_value = null;
    }

    public void oneOnClick(View view) {
        input.setText(input.getText() + "1");
    }

    public void twoOnClick(View view) {
        input.setText(input.getText() + "2");
    }

    public void threeOnClick(View view) {
        input.setText(input.getText() + "3");
    }

    public void subOnClick(View view) {
        sign_value = "subtract";
        first_value = input.getText().toString();
        input.setText(null);
        sign.setText("-");
        has_decimal = false;
    }

    public void doubleZeroOnClick(View view) {
        input.setText(input.getText() + "00");
    }

    public void zeroOnClick(View view) {
        input.setText(input.getText() + "0");
    }

    public void decOnClick(View view) {
        if(!has_decimal) {
            if(input.getText().equals(""))
                input.setText("0.");
            else
                input.setText(".");

            has_decimal = true;
        }
    }

    public void addOnClick(View view) {
        sign_value = "add";
        first_value = input.getText().toString();
        input.setText(null);
        sign.setText("+");
        has_decimal = false;
    }

    public void equalOnClick(View view) {
        if(sign_value == null)
            sign.setText("Error!");

        else if(input.getText().equals(""))
            sign.setText("Error!");

        else if ((sign_value.equals("+") || sign_value.equals("-") || sign_value.equals("*") || sign_value.equals("/")) && first_value.equals(""))
            sign.setText("Error!");

        else {
            Double first_number, second_number;
            switch(sign_value) {
                case "log":
                    first_value = input.getText().toString();
                    first_number = Double.parseDouble(first_value);
                    input.setText(Math.log10(first_number) + "");
                    sign_value = null;
                    sign.setText(null);
                    break;

                case "ln":
                    first_value = input.getText().toString();
                    first_number = Double.parseDouble(first_value);
                    input.setText(Math.log(first_number) + "");
                    sign_value = null;
                    sign.setText(null);
                    break;

                case "power":
                    first_number = Double.parseDouble(first_value);
                    second_value = input.getText().toString();
                    second_number = Double.parseDouble(second_value);
                    input.setText(Math.pow(first_number, second_number) + "");
                    sign_value = null;
                    sign.setText(null);
                    break;

                case "root":
                    first_value = input.getText().toString();
                    first_number = Double.parseDouble(first_value);
                    input.setText(Math.sqrt(first_number) + "");
                    sign_value = null;
                    sign.setText(null);
                    break;

                case "factorial":
                    first_value = input.getText().toString();
                    first_number = Double.parseDouble(first_value);
                    int iterate = Integer.parseInt(first_value) - 1;

                    while(iterate > 0) {
                        first_number *= iterate;
                        iterate--;
                    }

                    input.setText(first_number + "");
                    sign_value = null;
                    sign.setText(null);
                    break;

                case "sin":
                    first_value = input.getText().toString();
                    first_number = Double.parseDouble(first_value);
                    input.setText(Math.sin(first_number) + "");
                    sign_value = null;
                    sign.setText(null);
                    break;

                case "cos":
                    first_value = input.getText().toString();
                    first_number = Double.parseDouble(first_value);
                    input.setText(Math.cos(first_number) + "");
                    sign_value = null;
                    sign.setText(null);
                    break;

                case "tan":
                    first_value = input.getText().toString();
                    first_number = Double.parseDouble(first_value);
                    input.setText(Math.tan(first_number) + "");
                    sign_value = null;
                    sign.setText(null);
                    break;

                case "divide":
                    first_number = Double.parseDouble(first_value);
                    second_value = input.getText().toString();
                    second_number = Double.parseDouble(second_value);
                    input.setText((first_number / second_number) + "");
                    sign_value = null;
                    sign.setText(null);
                    break;

                case "multiply":
                    first_number = Double.parseDouble(first_value);
                    second_value = input.getText().toString();
                    second_number = Double.parseDouble(second_value);
                    input.setText((first_number * second_number) + "");
                    sign_value = null;
                    sign.setText(null);
                    break;

                case "subtract":
                    first_number = Double.parseDouble(first_value);
                    second_value = input.getText().toString();
                    second_number = Double.parseDouble(second_value);
                    input.setText((first_number - second_number) + "");
                    sign_value = null;
                    sign.setText(null);
                    break;

                case "add":
                    first_number = Double.parseDouble(first_value);
                    second_value = input.getText().toString();
                    second_number = Double.parseDouble(second_value);
                    input.setText((first_number + second_number) + "");
                    sign_value = null;
                    sign.setText(null);
                    break;

                default:
                    break;
            }
        }
    }
}