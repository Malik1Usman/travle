package com.example.travle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signUp extends AppCompatActivity {
FirebaseAuth mAuth;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(signUp.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        mAuth=FirebaseAuth.getInstance();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button submitButton = findViewById(R.id.SignupButton);
//        EditText Editusername = findViewById(R.id.username);
        EditText Editemail = findViewById(R.id.email);
//        EditText confirmpassword = findViewById(R.id.confirmpassword);
        EditText Editpassword = findViewById(R.id.password);
        TextView textView = findViewById(R.id.movetologin);

submitButton.setOnClickListener(new View.OnClickListener() {


    @Override
    public void onClick(View view) {
        String email, password,username;

        email = String.valueOf(Editemail.getText());
        password = String.valueOf(Editpassword.getText());

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(signUp.this," Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(signUp.this," Enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(signUp.this, "Account Created",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(signUp.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(signUp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
});

//        // Validate and submit form
//        submitButton.setOnClickListener(v -> {
//            String email =Eemail.getText().toString().trim();
//            boolean isValid = true;
//
//            if (username.getText().toString().trim().isEmpty()) {
//                username.setError("This field is required");
//                isValid = false;
//            }
//            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
//                Eemail.setError("Invalid email format");
//            }
//            if (password.getText().toString().trim().isEmpty()) {
//                password.setError("This field is required");
//                isValid = false;
//            }
//            if (confirmpassword.getText().toString().trim().isEmpty()) {
//                confirmpassword.setError("This field is required");
//                isValid = false;
//            }
//
//            if (isValid) {
//
//
//                // Proceed to MainActivity
//                Toast.makeText(this, "All fields are valid!", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(signUp.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });


        textView.setOnClickListener(v -> {
            // Navigate to SecondActivity
            Intent intent = new Intent(signUp.this, logIn.class);
            startActivity(intent);
        });



    }
}





