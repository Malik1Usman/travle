package com.example.travle;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class forget extends AppCompatActivity {
    private static final String CHANNEL_ID = "random_number_channel";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);



        Button Button = findViewById(R.id.forgetButton);

        EditText editText=findViewById(R.id.username);





        Button.setOnClickListener(v -> {
            String email = editText.getText().toString().trim();

            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                editText.setError("Invalid email format");
            } else {
                Toast.makeText(this, "Valid email!", Toast.LENGTH_SHORT).show();


                        // Proceed with your action

                        // Generate a random five-digit number
                        int randomNumber = new Random().nextInt(90000) + 10000; // Ensures a number between 10000 and 99999

                        // Show the notification
                        showNotification(randomNumber);

                        Intent intent = new Intent(forget.this, verify.class);
                        startActivity(intent);


            }
        });
        }

        private void showNotification(int number) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            // Create Notification Channel (required for Android 8.0 and above)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(
                        CHANNEL_ID,
                        "Random Number Notifications",
                        NotificationManager.IMPORTANCE_DEFAULT
                );
                channel.setDescription("Channel for random number notifications");
                notificationManager.createNotificationChannel(channel);
            }

            // Build the notification
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("Random Number")
                    .setContentText("Your random 5-digit number is: " + number)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            // Display the notification
            notificationManager.notify(1, builder.build());
    }
}
