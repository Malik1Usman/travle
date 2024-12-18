package com.example.travle.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.travle.R;
import com.example.travle.logIn;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeFragment extends Fragment {

    private FirebaseAuth auth;
    private FirebaseUser user;
    private Button logoutButton;
    private TextView userDetails;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance();

        // Find views
        logoutButton = view.findViewById(R.id.logout);
        userDetails = view.findViewById(R.id.user_details);

        // Check if user is logged in
        user = auth.getCurrentUser();
        if (user == null) {
            // Redirect to logIn activity if user is not logged in
            Intent intent = new Intent(getActivity(), logIn.class);
            startActivity(intent);
            getActivity().finish();
        } else {
            // Display user email
            userDetails.setText(user.getEmail());
        }

        // Handle logout button click
        logoutButton.setOnClickListener(v -> {
            // Sign out the user
            auth.signOut();
            // Redirect to logIn activity
            Intent intent = new Intent(getActivity(), logIn.class);
            startActivity(intent);
            getActivity().finish();
        });

        return view;
    }
}
