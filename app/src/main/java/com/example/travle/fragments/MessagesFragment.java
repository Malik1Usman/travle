package com.example.travle.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travle.R;
import com.example.travle.adapters.MessageAdapter;
import com.example.travle.models.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class MessagesFragment extends Fragment {
    private RecyclerView recyclerView;
    private MessageAdapter messageAdapter;
    private List<MessageModel> messageList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messages, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize the message list
        messageList = new ArrayList<>();
        messageList.add(new MessageModel("John Doe", "Online", "12:30 PM"));
        messageList.add(new MessageModel("Jane Smith", "Typing...", "11:45 AM"));

        // Set up the adapter
        messageAdapter = new MessageAdapter(getContext(), messageList);
        recyclerView.setAdapter(messageAdapter);

        return view;
    }
}
