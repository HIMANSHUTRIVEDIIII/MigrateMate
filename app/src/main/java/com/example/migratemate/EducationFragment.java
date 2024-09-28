package com.example.migratemate;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class EducationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_education, container, false);

        // Set up click listeners for CardViews
        view.findViewById(R.id.cardView1).setOnClickListener(this::onCardViewClick);
        view.findViewById(R.id.cardView2).setOnClickListener(this::onCardViewClick);
        view.findViewById(R.id.cardView3).setOnClickListener(this::onCardViewClick);
        view.findViewById(R.id.cardView4).setOnClickListener(this::onCardViewClick);

        return view;
    }

    public void onCardViewClick(View view) {
        Fragment destinationFragment = null;

        switch (view.getId()) {
            case R.id.cardView1:
                destinationFragment = new detailofeducation_fragment(); // Replace with your destination fragment
                break;
            case R.id.cardView2:
                destinationFragment = new detailofeducation_fragment(); // Replace with your destination fragment
                break;
            case R.id.cardView3:
                destinationFragment = new detailofeducation_fragment(); // Replace with your destination fragment
                break;
            case R.id.cardView4:
                destinationFragment = new detailofeducation_fragment(); // Replace with your destination fragment
                break;
            default:
                Toast.makeText(getContext(), "Error: Fragment not found", Toast.LENGTH_SHORT).show();
                break;
        }

        if (destinationFragment != null) {
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.container, destinationFragment); // Ensure the container ID matches your layout
            transaction.addToBackStack(null); // Add to back stack if you want to navigate back
            transaction.commit();
        }
    }
}
