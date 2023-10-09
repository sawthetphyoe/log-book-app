package com.example.logbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    boolean activeNumber = false;

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

        btnZero.setOnClickListener(v -> onNumberClick("0"));
        btnOne.setOnClickListener(v -> onNumberClick("1"));
        btnTwo.setOnClickListener(v -> onNumberClick("2"));
        btnThree.setOnClickListener(v -> onNumberClick("3"));
        btnFour.setOnClickListener(v -> onNumberClick("4"));
        btnFive.setOnClickListener(v -> onNumberClick("5"));
        btnSix.setOnClickListener(v -> onNumberClick("6"));
        btnSeven.setOnClickListener(v -> onNumberClick("7"));
        btnEight.setOnClickListener(v -> onNumberClick("8"));
        btnNine.setOnClickListener(v -> onNumberClick("9"));

        btnPlus.setOnClickListener(v -> onOperatorClick(operation.ADD));
        btnMinus.setOnClickListener(v -> onOperatorClick(operation.SUBTRACT));
        btnMultiply.setOnClickListener(v -> onOperatorClick(operation.MULTIPLY));
        btnDivide.setOnClickListener(v -> onOperatorClick(operation.DIVIDE));

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
                resetCalculator();
            }
        });

        btnClear.setOnClickListener(v -> resetCalculator());
    }

    private void resetCalculator() {
        operandOne = 0;
        operandTwo = 0;
        calculatorDisplay.setText("0");
        operator = null;
    }

    private void onNumberClick(String text) {
        String currentDisplay = calculatorDisplay.getText().toString();
        if (!activeNumber || currentDisplay.equals("0")) {
            calculatorDisplay.setText(text);
        } else {
            calculatorDisplay.append(text);
        }
        activeNumber = true;
    }

    private void onOperatorClick(operation opt) {
        if (operator != null && activeNumber) {
            operandOne = calculate(operandOne, Double.parseDouble(calculatorDisplay.getText().toString()), operator);
        } else {
            operandOne = Double.parseDouble(calculatorDisplay.getText().toString());
        }
        operator = opt;
        activeNumber = false;
    }

    private double calculate(double operand1, double operand2, Enum<operation> operator) {
        if (operator == operation.ADD) {
            return operand1 + operand2;
        }
        if (operator == operation.SUBTRACT) {
            return operand1 - operand2;
        }
        if (operator == operation.MULTIPLY) {
            return operand1 * operand2;
        }
        if (operator == operation.DIVIDE) {
            return operand1 / operand2;
        }
        return 0;
    }

    private static String fmt(double d) {
        String s;
        if (d == (long) d) {
            s = Long.toString((long) d);
        } else {
            s = Double.toString(d);
        }
        return s;
    }
}