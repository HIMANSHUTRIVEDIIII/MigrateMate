package com.example.migratemate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ActivitiesFragment homeFragment = new ActivitiesFragment();
    EducationFragment jobFragment = new EducationFragment();
    InfoFragment infoFragment = new InfoFragment();
    MessageFragment messageFragment = new MessageFragment();
    ProfileFragment profileFragment = new ProfileFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Activities:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                        return true;
                    case R.id.education:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, jobFragment).commit();
                        return true;
                    case R.id.messages:
                        // Replace the container with MessageFragment
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, messageFragment).commit();

                        // Use a handler to delay the notification slightly
                        new android.os.Handler().postDelayed(
                                new Runnable() {
                                    public void run() {
                                        sendNotification("This is your first notification");
                                        sendNotification("This is your second notification");
                                        sendNotification("This is your third notification");
                                        sendNotification("This is your fourth notification");
                                        sendNotification("This is your fifth notification");
                                    }
                                },
                                100 // delay in milliseconds
                        );

                        return true;
                    case R.id.info:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, infoFragment).commit();
                        return true;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
    private void sendNotification(String message) {
        Log.d("MainActivity", "Attempting to send notification: " + message);
        if (messageFragment != null && messageFragment.isAdded()) {
            Log.d("MainActivity", "MessageFragment is added, adding notification");
            messageFragment.addNotification(message);
        } else {
            Log.d("MainActivity", "MessageFragment is not added");
        }
    }


}