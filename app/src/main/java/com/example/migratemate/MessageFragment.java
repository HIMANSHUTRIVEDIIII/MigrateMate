package com.example.migratemate;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class MessageFragment extends Fragment {

    private RecyclerView recyclerView;
    private NotificationAdapter notificationAdapter;
    private List<String> notificationList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        // Initialize the notificationList here
        notificationList = new ArrayList<>();

        recyclerView = view.findViewById(R.id.recyclerViewNotifications);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        notificationAdapter = new NotificationAdapter(notificationList);
        recyclerView.setAdapter(notificationAdapter);

        return view;
    }

    public void addNotification(String notification) {
        if (notificationList != null) {
            Log.d("MessageFragment", "Adding notification: " + notification);
            notificationList.add(notification);
            notificationAdapter.notifyItemInserted(notificationList.size() - 1);
        } else {
            Log.e("MessageFragment", "notificationList is null");
        }
    }

}
