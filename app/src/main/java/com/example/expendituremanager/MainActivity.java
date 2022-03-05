package com.example.expendituremanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText amountField, dateField, commentField;
    Spinner categorySpinner, currencySpinner;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = findViewById(R.id.submitButton);
        categorySpinner = findViewById(R.id.categorySpinner);
        currencySpinner = findViewById(R.id.currencySpinner);

        final ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.categoryArray)); //Your resource name

        categorySpinner.setAdapter(categoryAdapter); //attaching the spinner to a spinner.

        final ArrayAdapter<String> currencyAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.currencies));

        currencySpinner.setAdapter(currencyAdapter);
    }

    public void saveExpense(View view) {
        System.out.println("Inside the function");
        amountField = findViewById(R.id.amountField);
        dateField = findViewById(R.id.dateField);
        commentField = findViewById(R.id.commentField);

        if (amountField.getText().toString().isEmpty()) {
            showErrorMessage("Amount");
            return;
        }

        if (dateField.getText().toString().isEmpty()) {
            showErrorMessage("Date");
            return;
        }

        if (commentField.getText().toString().isEmpty()) {
            showErrorMessage("Comment");
            return;
        }
        String toastMessage = "You spent " + amountField.getText().toString() + " for " + categorySpinner.getSelectedItem().toString() + " on " + dateField.getText().toString();

        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }

    private void showErrorMessage(String fieldName) {

        System.out.println("showing toast for " + fieldName);
        Toast.makeText(this, fieldName + " is missing!", Toast.LENGTH_SHORT).show();
    }
}