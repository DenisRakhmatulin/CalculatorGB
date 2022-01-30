package com.example.calculatorgb;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resultString;
    private TextView operationString;
    private Calculator calculator;
    private static final String ARG = "Calculator";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_layout);


        if (savedInstanceState == null) {
            calculator = new Calculator();
        } else {
            calculator = savedInstanceState.getParcelable(ARG);
        }

        resultString = findViewById(R.id.result_string);
        operationString = findViewById(R.id.operation_string);

        resultString.setText(calculator.getResult());
        operationString.setText(calculator.getLastBtn());


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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(ARG, calculator);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.key_one:
                calculator.buttonPush("1", resultString.getText().toString());
                resultString.setText(calculator.getLastNum());
                break;

            case R.id.key_two:
                calculator.buttonPush("2", resultString.getText().toString());
                resultString.setText(calculator.getLastNum());
                break;

            case R.id.key_three:
                calculator.buttonPush("3", resultString.getText().toString());
                resultString.setText(calculator.getLastNum());
                break;

            case R.id.key_four:
                calculator.buttonPush("4", resultString.getText().toString());
                resultString.setText(calculator.getLastNum());
                break;

            case R.id.key_five:
                calculator.buttonPush("5", resultString.getText().toString());
                resultString.setText(calculator.getLastNum());
                break;

            case R.id.key_six:
                calculator.buttonPush("6", resultString.getText().toString());
                resultString.setText(calculator.getLastNum());
                break;

            case R.id.key_seven:
                calculator.buttonPush("7", resultString.getText().toString());
                resultString.setText(calculator.getLastNum());
                break;

            case R.id.key_eight:
                calculator.buttonPush("8", resultString.getText().toString());
                resultString.setText(calculator.getLastNum());
                break;

            case R.id.key_nine:
                calculator.buttonPush("9", resultString.getText().toString());
                resultString.setText(calculator.getLastNum());
                break;

            case R.id.key_zero:
                calculator.buttonPush("0", resultString.getText().toString());
                resultString.setText(calculator.getLastNum());
                break;

            case R.id.key_dot:
                calculator.buttonPush(".", resultString.getText().toString());
                resultString.setText(calculator.getLastNum());
                break;

            case R.id.key_plus:
                calculator.operationPush("+", resultString.getText().toString());
                operationString.setText(calculator.getLastBtn());
                resultString.setText(calculator.getResult());
                break;

            case R.id.key_minus:
                calculator.operationPush("-", resultString.getText().toString());
                operationString.setText(calculator.getLastBtn());
                resultString.setText(calculator.getResult());
                break;

            case R.id.key_multiply:
                calculator.operationPush("x", resultString.getText().toString());
                operationString.setText(calculator.getLastBtn());
                resultString.setText(calculator.getResult());
                break;

            case R.id.key_split:
                calculator.operationPush("/", resultString.getText().toString());
                operationString.setText(calculator.getLastBtn());
                resultString.setText(calculator.getResult());
                break;

            case R.id.key_result:
                calculator.resultPush(resultString.getText().toString());
                resultString.setText(calculator.getResult());
                operationString.setText(null);
                calculator.setValueDbl(0d);
                calculator.setLastBtn(null);
                break;

            case R.id.key_reset:
                resultString.setText("0");
                operationString.setText(null);

                calculator.setValueDbl(0d);
                calculator.setOperation(null);
                calculator.setLastNum(null);
                calculator.setLastBtn(null);
                calculator.setResult("0");
                break;


        }
    }
}
