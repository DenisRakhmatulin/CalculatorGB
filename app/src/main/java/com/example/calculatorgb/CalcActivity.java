package com.example.calculatorgb;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resultString;
    private TextView operationString;
    private boolean dotFlag = false;

    Calculator calculator = new Calculator();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_layout);

        resultString = findViewById(R.id.result_string);
        operationString = findViewById(R.id.operation_string);

        findViewById(R.id.key_one).setOnClickListener(this);
        findViewById(R.id.key_dot).setOnClickListener(this);
        findViewById(R.id.key_eight).setOnClickListener(this);
        findViewById(R.id.key_five).setOnClickListener(this);
        findViewById(R.id.key_four).setOnClickListener(this);
        findViewById(R.id.key_minus).setOnClickListener(this);
        findViewById(R.id.key_multiply).setOnClickListener(this);
        findViewById(R.id.key_nine).setOnClickListener(this);
        findViewById(R.id.key_plus).setOnClickListener(this);
        findViewById(R.id.key_reset).setOnClickListener(this);
        findViewById(R.id.key_result).setOnClickListener(this);
        findViewById(R.id.key_seven).setOnClickListener(this);
        findViewById(R.id.key_six).setOnClickListener(this);
        findViewById(R.id.key_split).setOnClickListener(this);
        findViewById(R.id.key_three).setOnClickListener(this);
        findViewById(R.id.key_two).setOnClickListener(this);
        findViewById(R.id.key_zero).setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        String buf;
        switch (view.getId()) {
            case R.id.key_one:
                buf = calculator.buttonPush("1", resultString.getText().toString());
                resultString.setText(buf);
                break;

            case R.id.key_two:
                buf = calculator.buttonPush("2", resultString.getText().toString());
                resultString.setText(buf);
                break;

            case R.id.key_three:
                buf = calculator.buttonPush("3", resultString.getText().toString());
                resultString.setText(buf);
                break;

            case R.id.key_four:
                buf = calculator.buttonPush("4", resultString.getText().toString());
                resultString.setText(buf);
                break;

            case R.id.key_five:
                buf = calculator.buttonPush("5", resultString.getText().toString());
                resultString.setText(buf);
                break;

            case R.id.key_six:
                buf = calculator.buttonPush("6", resultString.getText().toString());
                resultString.setText(buf);
                break;

            case R.id.key_seven:
                buf = calculator.buttonPush("7", resultString.getText().toString());
                resultString.setText(buf);
                break;

            case R.id.key_eight:
                buf = calculator.buttonPush("8", resultString.getText().toString());
                resultString.setText(buf);
                break;

            case R.id.key_nine:
                buf = calculator.buttonPush("9", resultString.getText().toString());
                resultString.setText(buf);
                break;

            case R.id.key_zero:
                buf = calculator.buttonPush("0", resultString.getText().toString());
                resultString.setText(buf);
                break;

            case R.id.key_dot:
                if (dotFlag) {
                    break;
                } else {
                    buf = calculator.buttonPush(".", resultString.getText().toString());
                    resultString.setText(buf);
                    dotFlag = true;
                }
                break;

            case R.id.key_plus:
                operationString.setText(calculator.operationPush("+", resultString.getText().toString()));
                resultString.setText("0");
                dotFlag = false;
                break;

            case R.id.key_minus:
                operationString.setText(calculator.operationPush("-", resultString.getText().toString()));
                resultString.setText("0");
                dotFlag = false;
                break;

            case R.id.key_multiply:
                operationString.setText(calculator.operationPush("x", resultString.getText().toString()));
                resultString.setText("0");
                dotFlag = false;
                break;

            case R.id.key_split:
                operationString.setText(calculator.operationPush("/", resultString.getText().toString()));
                resultString.setText("0");
                dotFlag = false;
                break;

            case R.id.key_result:
                resultString.setText(calculator.resultPush(resultString.getText().toString()));
                operationString.setText(null);
                calculator.setValueDbl(0d);
                dotFlag = resultString.getText().toString().contains(".");
                break;

            case R.id.key_reset:
                resultString.setText("0");
                operationString.setText(null);
                calculator.setValueDbl(0d);
                calculator.setOperation(null);
                dotFlag = false;
                break;


        }
    }
}
