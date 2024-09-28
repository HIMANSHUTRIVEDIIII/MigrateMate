package com.example.migratemate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

public class detail_about_activities_fragment extends Fragment {

    private ImageView imageViewOfActivities;
    private TextView textViewTitle;
    private TextView textViewDate;
    private TextView additionalInfoTextView;
    private TextView showMoreTextView;
    private TextView linkTextView;
    private boolean isExpanded = false;

    private static final String SHOW_MORE = "Show More";
    private static final String SHOW_LESS = "Show Less";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_about_activities_fragment, container, false);

        // Set up the Toolbar
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
            activity.getSupportActionBar().setTitle("Event Detail"); // Set the title
        }

        imageViewOfActivities = view.findViewById(R.id.imageViewofactivities);
        textViewTitle = view.findViewById(R.id.textView14);
        textViewDate = view.findViewById(R.id.textView15);
        additionalInfoTextView = view.findViewById(R.id.additionalInfoTextView);
        showMoreTextView = view.findViewById(R.id.showMoreTextView);
        linkTextView = view.findViewById(R.id.linkTextView);

        // Get the arguments passed from the ActivitiesFragment
        Bundle bundle = getArguments();
        if (bundle != null) {
            int imageResId = bundle.getInt("image", R.drawable.demoimage); // Default image
            String title = bundle.getString("title", "Event Title");
            String date = bundle.getString("date", "Event Date");
            String additionalInfo = bundle.getString("additionalInfo", "Additional information not available.");
            String url = bundle.getString("url", "");

            // Populate views with data
            imageViewOfActivities.setImageResource(imageResId);
            textViewTitle.setText(title);
            textViewDate.setText(date);
            additionalInfoTextView.setText(additionalInfo);

            // Handle the clickable link
            if (!TextUtils.isEmpty(url)) {
                linkTextView.setVisibility(View.VISIBLE);
                linkTextView.setOnClickListener(v -> openUrl(url));
            } else {
                linkTextView.setVisibility(View.GONE);
            }

            // Show More functionality
            if (additionalInfo.length() > 100) { // Check if the info is long enough to justify this feature
                showMoreTextView.setVisibility(View.VISIBLE);
                showMoreTextView.setOnClickListener(v -> {
                    if (isExpanded) {
                        additionalInfoTextView.setMaxLines(2);
                        additionalInfoTextView.setEllipsize(TextUtils.TruncateAt.END);
                        showMoreTextView.setText(SHOW_MORE);
                    } else {
                        additionalInfoTextView.setMaxLines(Integer.MAX_VALUE);
                        additionalInfoTextView.setEllipsize(null);
                        showMoreTextView.setText(SHOW_LESS);
                    }
                    isExpanded = !isExpanded;
                });
            } else {
                showMoreTextView.setVisibility(View.GONE);
            }
        }

        return view;
    }

    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
