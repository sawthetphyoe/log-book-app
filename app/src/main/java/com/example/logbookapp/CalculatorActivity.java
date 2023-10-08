package com.example.logbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    enum operation {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }

    TextView calculatorDisplay;
    Button btnPlus, btnMinus, btnDivide, btnMultiply, btnClear, btnEqual, btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    double operandOne = 0, operandTwo = 0;
    operation operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        calculatorDisplay = findViewById(R.id.calculator_display);

        btnZero = findViewById(R.id.btn_zero);
        btnOne = findViewById(R.id.btn_one);
        btnTwo = findViewById(R.id.btn_two);
        btnThree = findViewById(R.id.btn_three);
        btnFour = findViewById(R.id.btn_four);
        btnFive = findViewById(R.id.btn_five);
        btnSix = findViewById(R.id.btn_six);
        btnSeven = findViewById(R.id.btn_seven);
        btnEight = findViewById(R.id.btn_eight);
        btnNine = findViewById(R.id.btn_nine);
        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnDivide = findViewById(R.id.btn_divide);
        btnMultiply = findViewById(R.id.btn_multiple);
        btnClear = findViewById(R.id.btn_clear);
        btnEqual = findViewById(R.id.btn_equal);

        btnZero.setOnClickListener(v -> {
            calculatorDisplay.setText("0");
        });

        btnOne.setOnClickListener(v -> {
            calculatorDisplay.setText("1");
        });

        btnTwo.setOnClickListener(v -> {
            calculatorDisplay.setText("2");
        });

        btnThree.setOnClickListener(v -> {
            calculatorDisplay.setText("3");
        });

        btnFour.setOnClickListener(v -> {
            calculatorDisplay.setText("4");
        });

        btnFive.setOnClickListener(v -> {
            calculatorDisplay.setText("5");
        });

        btnSix.setOnClickListener(v -> {
            calculatorDisplay.setText("6");
        });

        btnSeven.setOnClickListener(v -> {
            calculatorDisplay.setText("7");
        });

        btnEight.setOnClickListener(v -> {
            calculatorDisplay.setText("8");
        });

        btnNine.setOnClickListener(v -> {
            calculatorDisplay.setText("9");
        });

        btnThree.setOnClickListener(v -> {
            calculatorDisplay.setText("3");
        });

        btnPlus.setOnClickListener(v -> {
            if (operator != null && operandOne != 0) {
                operandOne = calculate(operandOne, Double.parseDouble(calculatorDisplay.getText().toString()), operator);
            } else {
                operandOne = Double.parseDouble(calculatorDisplay.getText().toString());
            }
            ;
            operator = operation.ADD;
        });

        btnMinus.setOnClickListener(v -> {
            if (operator != null && operandOne != 0) {
                operandOne = calculate(operandOne, Double.parseDouble(calculatorDisplay.getText().toString()), operator);
            } else {
                operandOne = Double.parseDouble(calculatorDisplay.getText().toString());
            }
            ;
            operator = operation.SUBTRACT;
        });

        btnMultiply.setOnClickListener(v -> {
            if (operator != null && operandOne != 0) {
                operandOne = calculate(operandOne, Double.parseDouble(calculatorDisplay.getText().toString()), operator);
            } else {
                operandOne = Double.parseDouble(calculatorDisplay.getText().toString());
            }
            ;
            operator = operation.MULTIPLY;
        });

        btnDivide.setOnClickListener(v -> {
            if (operator != null && operandOne != 0) {
                operandOne = calculate(operandOne, Double.parseDouble(calculatorDisplay.getText().toString()), operator);
            } else {
                operandOne = Double.parseDouble(calculatorDisplay.getText().toString());
            }
            ;
            operator = operation.DIVIDE;
        });

        btnEqual.setOnClickListener(v -> {
            if (operator != null) {
                operandTwo = Double.parseDouble(calculatorDisplay.getText().toString());
                double result = calculate(operandOne, operandTwo, operator);
                calculatorDisplay.setText(fmt(result));
//            Reset operands and operators
                operandOne = result;
                operandTwo = 0;
                operator = null;
            } else {
                operandOne = 0;
                operandTwo = 0;
                calculatorDisplay.setText("0");
            }
            ;
        });

        btnClear.setOnClickListener(v -> {
            operandOne = 0;
            operandTwo = 0;
            calculatorDisplay.setText("0");
        });
    }

    protected double calculate(double operand1, double operand2, Enum<operation> operator) {
        if (operator == operation.ADD) {
            return operand1 + operand2;
        }
        ;
        if (operator == operation.SUBTRACT) {
            return operand1 - operand2;
        }
        ;
        if (operator == operation.MULTIPLY) {
            return operand1 * operand2;
        }
        ;
        if (operator == operation.DIVIDE) {
            return operand1 / operand2;
        }
        ;
        return 0;
    }

    ;

    public static String fmt(double d) {
        if (d == (long) d) {
            return String.format("%d", (long) d);
        } else
            return String.format("%s", d);
    }
}