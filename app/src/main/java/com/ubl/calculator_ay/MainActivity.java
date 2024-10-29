package com.ubl.calculator_ay;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText txtNumber1, txtNumber2;
    Button btnPlus, btnMinus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumber1 = findViewById(R.id.txtNumber1);
        txtNumber2 = findViewById(R.id.txtNumber2);
        btnPlus = findViewById(R.id.button_plus);
        btnMinus = findViewById(R.id.button_min);

        btnPlus.setOnClickListener(view -> handlePlusButton());
        btnMinus.setOnClickListener(view -> handleMinusButton());
    }

    private void handlePlusButton() {
        if (validateInput()) {
            int num1 = Integer.parseInt(txtNumber1.getText().toString());
            int num2 = Integer.parseInt(txtNumber2.getText().toString());
            int result = num1 + num2;

            showResultDialog("Hasil Penjumlahan", String.valueOf(result));
        }
    }

    private void handleMinusButton() {
        if (validateInput()) {
            int num1 = Integer.parseInt(txtNumber1.getText().toString());
            int num2 = Integer.parseInt(txtNumber2.getText().toString());
            int result = num1 - num2;

            showResultDialog("Hasil Pengurangan", String.valueOf(result));
        }
    }

    private boolean validateInput() {
        if (txtNumber1.getText().toString().isEmpty()) {
            Toast.makeText(this, "number 1 is required", Toast.LENGTH_SHORT).show();
            return false;
        } else if (txtNumber2.getText().toString().isEmpty()) {
            Toast.makeText(this, "number 2 is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void showResultDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        Dialog dialog = builder.create();
        dialog.show();
    }
}