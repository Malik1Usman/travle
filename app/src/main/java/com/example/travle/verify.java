package com.example.travle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class verify extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.varify_email);






        button = findViewById(R.id.Backtoforget);
        button.setOnClickListener(v -> {
            // Navigate to SecondActivity
            Intent intent = new Intent(verify.this, forget.class);
            startActivity(intent);
        });





    }
}
