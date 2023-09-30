package com.example.calculatorapp;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private AppCompatImageButton del;
    private TextView outPuttxt, inputTxt;

    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        clickListener();
        setupTextWatcher();
    }

    private void init() {
        initializeButtons();

        outPuttxt = findViewById(R.id.outPuttxt);
        inputTxt = findViewById(R.id.inputTxt);
        del = findViewById(R.id.del);
    }

    private void initializeButtons() {
        for (int i = 0; i <= 9; i++) {
            int digitId = getResources().getIdentifier("btn_" + i, "id", getPackageName());
            AppCompatButton digitButton = findViewById(digitId);

            final int digit = i;
            digitButton.setOnClickListener(v -> {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + digit);
            });
        }
    }

    private void clickListener() {

        setupOperationButtonListeners();


        del.setOnClickListener(v -> {
            String currentInput = inputTxt.getText().toString();
            if (!currentInput.isEmpty()) {
                currentInput = currentInput.substring(0, currentInput.length() - 1);
                inputTxt.setText(currentInput);
            }
        });

        // Clear All Button
        AppCompatButton btn_ac = findViewById(R.id.btn_ac);
        btn_ac.setOnClickListener(v -> {
            inputTxt.setText("");
            outPuttxt.setText("");
        });

        // Decimal Button
        AppCompatButton btn_dot = findViewById(R.id.btn_dot);
        btn_dot.setOnClickListener(v -> {
            data = inputTxt.getText().toString();
            inputTxt.setText(data + ".");
        });


        // Equal Button
        AppCompatButton btn_equal = findViewById(R.id.btn_equal);
        btn_equal.setOnClickListener(v -> {
            data = inputTxt.getText().toString();
            data = data.replaceAll("×", "*");
            data = data.replaceAll("%", "/100");
            data = data.replaceAll("÷", "/");

            Context rhinoContext = Context.enter();
            rhinoContext.setOptimizationLevel(-1);



            String finalResult;
            Scriptable scriptable = rhinoContext.initStandardObjects();
            finalResult = rhinoContext.evaluateString(scriptable, data, "Javsscript", 1, null).toString();

            outPuttxt.setText("");
            inputTxt.setText(finalResult);
        });
    }

    private void setupTextWatcher() {
        inputTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Update output in real-time
                updateOutput();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    private void updateOutput() {
        String inputData = inputTxt.getText().toString();
        if (inputData.isEmpty()) {
            outPuttxt.setText("");
            return;
        }

        try {
            String processedData = preprocessExpression(inputData);
            double result = evaluateExpression(processedData);
            outPuttxt.setText(String.valueOf(result));
        } catch (Exception e) {
            outPuttxt.setText("Error");
        }
    }

    private String preprocessExpression(String input) {
        return input.replaceAll("×", "*")
                .replaceAll("%", "/100")
                .replaceAll("÷", "/");
    }

    private double evaluateExpression(String expression) {
        Context rhinoContext = Context.enter();
        rhinoContext.setOptimizationLevel(-1);

        Scriptable scriptable = rhinoContext.initStandardObjects();
        Object result = rhinoContext.evaluateString(scriptable, expression, "JavaScript", 1, null);
        return Context.toNumber(result);
    }

    private void setupOperationButtonListeners() {
        Map<AppCompatButton, String> operationButtons = new HashMap<>();
        operationButtons.put(findViewById(R.id.btn_multiplication), "×");
        operationButtons.put(findViewById(R.id.btn_minus), "-");
        operationButtons.put(findViewById(R.id.btn_plus), "+");
        operationButtons.put(findViewById(R.id.btn_module), "%");
        operationButtons.put(findViewById(R.id.btn_div), "÷");

        for (Map.Entry<AppCompatButton, String> entry : operationButtons.entrySet()) {
            AppCompatButton button = entry.getKey();
            String operation = entry.getValue();

            button.setOnClickListener(v -> {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + operation);
            });
        }
    }

}














