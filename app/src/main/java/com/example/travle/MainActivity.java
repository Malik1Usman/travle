package com.example.travle;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.travle.fragments.CalendarFragment;
import com.example.travle.fragments.HomeFragment;
import com.example.travle.fragments.MessagesFragment;
import com.example.travle.fragments.ProfileFragment;
import com.example.travle.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            handleNavigation(item.getItemId()); // Call your navigation handler here
            if (item.getItemId() == R.id.navigation_search) {
                // Handle Search button click
                openSearchFragment();
            }
            return true;
        });
    }

    private void handleNavigation(int itemId) {
        if (itemId == R.id.navigation_home) {
            // Handle home navigation
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
        } else if (itemId == R.id.navigation_calendar) {
            // Handle calendar navigation
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new CalendarFragment())
                    .commit();
        } else if (itemId == R.id.navigation_messages) {
            // Handle messages navigation
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new MessagesFragment())
                    .commit();

        } else if (itemId == R.id.navigation_profile) {
            // Handle profile navigation
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ProfileFragment())
                    .commit();
        }
    }
    private void openSearchFragment() {
        SearchFragment searchFragment = new SearchFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, searchFragment)  // Replace the fragment container with SearchFragment
                .addToBackStack(null)  // Optional: Adds to back stack to enable back navigation
                .commit();


//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
//
//        bottomNavigationView.setOnItemSelectedListener(item -> {
//            Fragment selectedFragment = null;
//
//            if (item.getItemId() == R.id.nav_home) {
//                selectedFragment = new HomeFragment();
//            } else if (item.getItemId() == R.id.nav_profile) {
//                selectedFragment = new ProfileFragment();
//            } else if (item.getItemId() == R.id.nav_messages) {
//                selectedFragment = new MessagesFragment();
//            } else if (item.getItemId() == R.id.nav_search) { // Fixed ID
//                selectedFragment = new SearchFragment();
//            } else if (item.getItemId() == R.id.nav_calendar) {
//                selectedFragment = new CalendarFragment();
//            }
//
//            if (selectedFragment != null) {
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragment_container, selectedFragment)
//                        .commit();
//            }
//            return true;
//        });

//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
//            handleNavigation(item.getItemId()); // Call your navigation handler here
//            if (item.getItemId() == R.id.navigation_search) {
//                // Handle Search button click
//                openSearchFragment();
//            }
//            return true;
//        });
//    }
//
//    private void handleNavigation(int itemId) {
//        if (itemId == R.id.navigation_home) {
//            // Handle home navigation
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragment_container, new HomeFragment())
//                    .commit();
//        } else if (itemId == R.id.navigation_calendar) {
//            // Handle calendar navigation
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragment_container, new CalendarFragment())
//                    .commit();
//        } else if (itemId == R.id.navigation_messages) {
//            // Handle messages navigation
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragment_container, new MessagesFragment())
//                    .commit();
//
//        } else if (itemId == R.id.navigation_profile) {
//            // Handle profile navigation
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragment_container, new ProfileFragment())
//                    .commit();
//        }
//    }
//    private void openSearchFragment() {
//        SearchFragment searchFragment = new SearchFragment();
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container, searchFragment)  // Replace the fragment container with SearchFragment
//                .addToBackStack(null)  // Optional: Adds to back stack to enable back navigation
//                .commit();
    }

}