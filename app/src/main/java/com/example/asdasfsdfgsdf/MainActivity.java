package com.example.asdasfsdfgsdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputText;
    private String currentInput = ""; // Menyimpan input saat ini
    private double result = 0; // Menyimpan hasil perhitungan
    private char operator = ' '; // Menyimpan operator saat ini

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);

        // Menghubungkan tombol-tombol angka dengan metode onClick yang sama
        int[] numberButtonIds = {
                R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
                R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9
        };

        for (int id : numberButtonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onNumberClick(((Button) view).getText().toString());
                }
            });
        }

        Button buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOperatorClick('+');
            }
        });

        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOperatorClick('-');
            }
        });

        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOperatorClick('*');
            }
        });

        Button buttonDivide = findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOperatorClick('/');
            }
        });

        Button buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });

        Button buttonEquals = findViewById(R.id.buttonEquals);
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });
    }

    private void onNumberClick(String number) {
        currentInput += number;
        inputText.setText(currentInput);
    }

    private void onOperatorClick(char op) {
        if (!currentInput.isEmpty()) {
            calculate();
        }
        operator = op;
    }

    private void calculate() {
        if (!currentInput.isEmpty()) {
            double operand2 = Double.parseDouble(currentInput);
            switch (operator) {
                case '+':
                    result += operand2;
                    break;
                case '-':
                    result -= operand2;
                    break;
                case '*':
                    result *= operand2;
                    break;
                case '/':
                    if (operand2 != 0) {
                        result /= operand2;
                    }
                    break;
                default:
                    result = operand2;
            }
            inputText.setText(String.valueOf(result));
            currentInput = "";
        }
    }

    private void clear() {
        currentInput = "";
        result = 0;
        operator = ' ';
        inputText.setText("");
    }
}
