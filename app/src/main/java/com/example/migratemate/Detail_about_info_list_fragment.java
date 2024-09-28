package com.example.migratemate;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class Detail_about_info_list_fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_about_info_list_fragment, container, false);

        TextView titleTextView = view.findViewById(R.id.titleTextView);
        TextView detailTextView = view.findViewById(R.id.detailTextView);
        TextView additionalInfoTextView = view.findViewById(R.id.additionalInfoTextView);

        // Retrieve data from bundle
        Bundle bundle = getArguments();
        if (bundle != null) {
            String title = bundle.getString("title");
            String detail = bundle.getString("detail");
            String additionalInfo = bundle.getString("additionalInfo");

            // Set data to TextViews
            titleTextView.setText(title);
            detailTextView.setText(detail);
            additionalInfoTextView.setText(additionalInfo);
        }

        return view;
    }
}
