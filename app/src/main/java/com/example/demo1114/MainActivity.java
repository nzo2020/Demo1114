package com.example.demo1114;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText aEditText, bEditText, cEditText;
    double a = 0, b = 0, c = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aEditText = findViewById(R.id.a_edittext);
        bEditText = findViewById(R.id.b_edittext);
        cEditText = findViewById(R.id.c_edittext);
    }
    public boolean isValidNum(String input){
        return !((input.equals("")) ||
                (input.equals("-") )||
                (input.equals(".")) ||
                (input.equals("+")) ||
                (input.equals("-.")));
    }
    public void solve(View v){
        solveEquation();
    }

    public void random_numbers(View view) {
        generateRandomNumbers();
    }

    public void solveEquation() {
        if (isValidNum(aEditText.getText().toString())&& (isValidNum(bEditText.getText().toString()))
                && (isValidNum(cEditText.getText().toString()))) {
            a = Double.parseDouble(aEditText.getText().toString());
            b = Double.parseDouble(bEditText.getText().toString());
            c = Double.parseDouble(cEditText.getText().toString());
            Intent intent = new Intent(MainActivity.this, result.class);
            intent.putExtra("a", a);
            intent.putExtra("b", b);
            intent.putExtra("c", c);
            startActivity(intent);
        }else{
            Toast.makeText(this, "wrong input", Toast.LENGTH_SHORT).show();
            a=0;
            b=0;
            c=0;
        }
    }

    public void generateRandomNumbers() {
        Random rnd = new Random();
        a = rnd.nextDouble()*200-100;
        b = rnd.nextDouble()*200-100;
        c = rnd.nextDouble()*200-100;

        aEditText.setText(String.valueOf(a));
        bEditText.setText(String.valueOf(b));
        cEditText.setText(String.valueOf(c));
    }
}