package com.example.demo1114;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class result extends AppCompatActivity {
    double a, b, c;
    TextView solutionTextView;
    double discriminant;
    ImageView iv;
    double root1, root2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        solutionTextView = findViewById(R.id.result_textview);
        iv = findViewById(R.id.iv);

        a = getIntent().getDoubleExtra("a", 0);
        b = getIntent().getDoubleExtra("b", 0);
        c = getIntent().getDoubleExtra("c", 0);

        discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        } else if (discriminant == 0) {
            root1 = root2 = -b / (2 * a);
        }

        if ((discriminant > 0)) {
            if (a > 0) {
                iv.setImageResource(R.drawable.picture1);
            } else {
                iv.setImageResource(R.drawable.picture2);
            }
            solutionTextView.setText("Root 1: " + root1 + "\nRoot 2: " + root2);
        } else if (discriminant == 0) {
            if (a > 0) {
                iv.setImageResource(R.drawable.picture3);
            } else {
                iv.setImageResource(R.drawable.picture4);
            }
            solutionTextView.setText("Root 1: " + root1);

        } else {
            if (a > 0) {
                iv.setImageResource(R.drawable.picture5);
            } else {
                iv.setImageResource(R.drawable.picture6);
            }
            solutionTextView.setText("no solution");
        }
    }

    public void Back(View view) {
        finish();
    }
}