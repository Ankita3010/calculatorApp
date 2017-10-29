package com.ankita.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button one,two,three,four,five,six,seven,eight,nine,zero,add,subtract,multiply,divide,decimal,equals,clear;
    TextView output;
    char operator=' ';
    String str = "";
    float num1= 0,num2 = 0;
    char last_pressed=' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button)findViewById(R.id.zero);

        add = (Button) findViewById(R.id.add);
        subtract = (Button) findViewById(R.id.subtract);
        multiply = (Button)findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
        decimal = (Button) findViewById(R.id.decimal);

        equals = (Button) findViewById(R.id.equals);
        clear = (Button) findViewById(R.id.clear);

        output = (TextView) findViewById(R.id.output);

        one.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v1){ display(String.valueOf('1'));last_pressed='n';
            }
        });
        two.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v2){
                display(String.valueOf('2'));last_pressed='n';
            }
        });
        three.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v3){
                display(String.valueOf('3'));last_pressed='n';
        }
        });
        four.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v3){
                display(String.valueOf('4'));last_pressed='n';
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(String.valueOf('5'));last_pressed='n';
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(String.valueOf('6'));last_pressed='n';
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(String.valueOf('7'));last_pressed='n';
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(String.valueOf('8'));last_pressed='n';
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(String.valueOf('9'));last_pressed='n';
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(String.valueOf('0'));last_pressed='n';
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator == ' ')
                {
                    num1= (str!="" )?  Float.parseFloat(str): num1;
                    str="";
                }
                else
                if( last_pressed == 'n')
                {
                    equals.callOnClick();
                }
                    operator='+';
                last_pressed='o';
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator == ' ')
                {
                    num1= (str!="" )?  Float.parseFloat(str): num1;
                    str="";
                }
                else
                if( last_pressed == 'n')
                {
                    equals.callOnClick();
                }
                operator='-';
                last_pressed='o';
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator == ' ')
                {
                    num1= (str!="" )?  Float.parseFloat(str): num1;
                    str="";
                }
                else
                if( last_pressed == 'n')
                {
                    equals.callOnClick();
                }
                    operator='*';
                last_pressed='o';
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator == ' ')
                {
                    num1= (str!="" )?  Float.parseFloat(str): num1;
                    str="";
                }
                else
                if( last_pressed == 'n')
                {
                    equals.callOnClick();
                }
                    operator='/';
                last_pressed='o';
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chkdec=str;
                if (chkdec!="")
                {
                    for(int i=0; i < chkdec.length(); i++ )
                    {
                        if(chkdec.charAt(i) == '.')
                        {
                            display("");
                            return;
                        }
                    }
                }
                    display(String.valueOf('.'));
                last_pressed='.';
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str="";
                operator= ' ';
                num1=num2=0;
                display(str);
                last_pressed=' ';
            }
        });

        equals.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                if(str == "")
                {
                    display(String.valueOf(num1));
                }
                else
                {
                    num2 = Float.parseFloat(str);
                    str="";
                    calculate(operator);
                }
                last_pressed=' ';
        }
        });
        }


        public void display(String x){
            str = str + x;
            output.setText(str);
    }

    public void calculate(char y){

        if(y == '+')
        {
            num1=num1+num2;
            display(String.valueOf(num1));
        }
        else if(y == '-')
        {
            num1=num1-num2;
            display(String.valueOf(num1));
        }
        else if(y == '*')
        {
            num1=num1*num2;
            display(String.valueOf(num1));
        }
        else if(y == '/')
        {
            num1=num1/num2;
            display(String.valueOf(num1));
        }
        else if(y == ' ')
        {
            num1=num2;
            display(String.valueOf(num1));
        }
        num2=0;
        operator=' ';
        str="";
    }
}

