package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView calText;
    String workings = "";
    float first_number, second_number;
    boolean add, sub, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    private void initTextViews()
    {
        calText = (TextView) findViewById(R.id.calText);
    }

    private void setWorkings(String givenValue)
    {
        workings = workings + givenValue;
        calText.setText(workings);
    }

    public void equalsOnClick(View view)
    {
        second_number = Float.parseFloat(workings);
        workings = "";

        if(add)
        {
            setWorkings(first_number + second_number + "");
            add = false;
        }
        if(sub)
        {
            setWorkings(first_number - second_number + "");
            sub = false;
        }
        if(mul)
        {
            setWorkings(first_number * second_number + "");
            mul = false;
        }
        if(div)
        {
            setWorkings(first_number / second_number + "");
            div = false;
        }
    }

    public void clearOnClick(View view)
    {
        calText.setText("");
        workings = "";
        setWorkings("");
    }

    public void divisionOnClick(View view)
    {
        first_number = Float.parseFloat(workings);
        div = true;
        workings = "";
        setWorkings("");
    }

    public void sevenOnClick(View view)
    {
        setWorkings("7");
    }

    public void eightOnClick(View view)
    {
        setWorkings("8");
    }

    public void nineOnClick(View view)
    {
        setWorkings("9");
    }

    public void timesOnClick(View view)
    {
        first_number = Float.parseFloat(workings);
        mul = true;
        workings = "";
        setWorkings("");
    }

    public void fourOnClick(View view)
    {
        setWorkings("4");
    }

    public void fiveOnClick(View view)
    {
        setWorkings("5");
    }

    public void sixOnClick(View view)
    {
        setWorkings("6");
    }

    public void minusOnClick(View view)
    {
        first_number = Float.parseFloat(workings);
        sub = true;
        workings = "";
        setWorkings("");
    }

    public void oneOnClick(View view)
    {
        setWorkings("1");
    }

    public void twoOnClick(View view)
    {
        setWorkings("2");
    }

    public void threeOnClick(View view)
    {
        setWorkings("3");
    }

    public void plusOnClick(View view)
    {
        if(calText.getText() == "")
            calText.setText("");
        else
        {
            first_number = Float.parseFloat(workings);
            add = true;
            workings = "";
            setWorkings("");
        }
    }

    public void decimalOnClick(View view)
    {
        setWorkings(".");
    }

    public void zeroOnClick(View view)
    {
        setWorkings("0");
    }

}