package com.example.travle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class logIn extends AppCompatActivity {

    FirebaseAuth mAuth;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(logIn.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Initialize UI components
        Button submitButton = findViewById(R.id.loginButton);
        EditText Editemail = findViewById(R.id.username); // Assuming username is the email field
        EditText Editpassword = findViewById(R.id.password);
        TextView textView = findViewById(R.id.movetosignup);
        TextView forgetTextView = findViewById(R.id.forgotPassword);

        // Navigate to signUp activity
        textView.setOnClickListener(view -> {
            Intent intent = new Intent(logIn.this, signUp.class);
            startActivity(intent);
        });

        // Navigate to forget password activity
        forgetTextView.setOnClickListener(v -> {
            Intent intent = new Intent(logIn.this, forget.class);
            startActivity(intent);
        });

        submitButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String email, password;
                email = String.valueOf(Editemail.getText());
                password = String.valueOf(Editpassword.getText());
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(logIn.this," Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(logIn.this," Enter password", Toast.LENGTH_SHORT).show();
                    return;


                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(logIn.this, "Login Successful ",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(logIn.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(logIn.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });

//        // Validate and login using Firebase Authentication
//        submitButton.setOnClickListener(v -> {
//            String email = Eemail.getText().toString().trim();
//            String pass = password.getText().toString().trim();
//            boolean isValid = true;
//
//            if (email.isEmpty()) {
//                Eemail.setError("This field is required");
//                isValid = false;
//            }
//            if (pass.isEmpty()) {
//                password.setError("This field is required");
//                isValid = false;
//            }
//
//            if (isValid) {
//                // Sign in with Firebase Authentication
//                mAuth.signInWithEmailAndPassword(email, pass)
//                        .addOnCompleteListener(task -> {
//                            if (task.isSuccessful()) {
//                                // Login successful
//                                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(logIn.this, MainActivity.class);
//                                startActivity(intent);
//                                finish(); // Close the login activity
//                            } else {
//                                // Login failed
//                                Toast.makeText(this, "Login failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                            }
//                        });
//            }
//        });
    }
}
