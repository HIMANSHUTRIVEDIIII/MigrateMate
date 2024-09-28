package com.example.migratemate;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListFragment extends Fragment implements adapterforinfodetail.ItemClickListener {

    private RecyclerView recyclerView;
    private List<datamodelforinfodetail> dataholderforinfodetail;
    private String categoryName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment_of_info, container, false);

        retrieveCategoryName(); // Make sure to retrieve the category name first
        setupToolbar(view);
        initializeRecyclerView(view);
        loadCategoryData();
        setupAdapter();

        return view;
    }

    private void setupToolbar(View view) {
        Toolbar toolbar = view.findViewById(R.id.toolbarforinfodetail);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        if (categoryName != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(categoryName);
        }
    }

    private void initializeRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recviewforinfodetail);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void retrieveCategoryName() {
        if (getArguments() != null) {
            categoryName = getArguments().getString("category_name");
        }
    }

    private void loadCategoryData() {
        dataholderforinfodetail = new ArrayList<>();
        Map<String, List<datamodelforinfodetail>> categoryData = getCategoryData();

        if (categoryData.containsKey(categoryName)) {
            dataholderforinfodetail.addAll(categoryData.get(categoryName));
        }
    }

    private Map<String, List<datamodelforinfodetail>> getCategoryData() {
        Map<String, List<datamodelforinfodetail>> categoryData = new HashMap<>();

        categoryData.put("Sports", getSportsQuestions());
        categoryData.put("Culture", getCultureQuestions());
        categoryData.put("Health", getHealthQuestions());
        categoryData.put("Education", getEducationQuestions());
        categoryData.put("Registration", getRegistrationQuestions());
        categoryData.put("Arranging House", getHouseQuestions());
        categoryData.put("Learning Hindi/Gujarati", getLanguageQuestions());
        categoryData.put("Finding Job", getJobQuestions());

        return categoryData;
    }

    private List<datamodelforinfodetail> getSportsQuestions() {
        List<datamodelforinfodetail> questions = new ArrayList<>();
        questions.add(new datamodelforinfodetail(R.drawable.baseline_keyboard_arrow_right_24,
                "What are the local sports facilities?",
                "Local sports facilities include gyms, swimming pools, and sports complexes that cater to various activities such as tennis, basketball, and football."));
        // Add more questions and answers here...
        return questions;
    }

    private List<datamodelforinfodetail> getCultureQuestions() {
        List<datamodelforinfodetail> questions = new ArrayList<>();
        questions.add(new datamodelforinfodetail(R.drawable.baseline_keyboard_arrow_right_24,
                "What are the must-visit cultural landmarks?",
                "Some of the must-visit cultural landmarks include the City Museum, Historic Center, and the famous Opera House."));
        // Add more questions and answers here...
        return questions;
    }

    // Similarly, add methods for other categories
    private List<datamodelforinfodetail> getHealthQuestions() {
        List<datamodelforinfodetail> questions = new ArrayList<>();
        questions.add(new datamodelforinfodetail(R.drawable.baseline_keyboard_arrow_right_24,
                "Where can I find a good hospital?",
                "There are several good hospitals in the area, including General Hospital, City Health Center, and the University Medical Center."));
        return questions;
    }

    private List<datamodelforinfodetail> getEducationQuestions() {
        List<datamodelforinfodetail> questions = new ArrayList<>();
        questions.add(new datamodelforinfodetail(R.drawable.baseline_keyboard_arrow_right_24,
                "What are the best schools in the area?",
                "The best schools in the area include Sunshine High School, City Academy, and Green Valley School."));
        return questions;
    }

    private List<datamodelforinfodetail> getRegistrationQuestions() {
        List<datamodelforinfodetail> questions = new ArrayList<>();
        questions.add(new datamodelforinfodetail(R.drawable.baseline_keyboard_arrow_right_24,
                "How do I register for residency?",
                "To register for residency, visit the local municipal office with your identification documents and proof of address."));
        return questions;
    }

    private List<datamodelforinfodetail> getHouseQuestions() {
        List<datamodelforinfodetail> questions = new ArrayList<>();
        questions.add(new datamodelforinfodetail(R.drawable.baseline_keyboard_arrow_right_24,
                "How do I find a rental house?",
                "You can find rental houses through local real estate agents, online property portals, or community notice boards."));
        return questions;
    }

    private List<datamodelforinfodetail> getLanguageQuestions() {
        List<datamodelforinfodetail> questions = new ArrayList<>();
        questions.add(new datamodelforinfodetail(R.drawable.baseline_keyboard_arrow_right_24,
                "Where can I learn Hindi?",
                "You can learn Hindi at the local language school or through online courses available on platforms like Duolingo and Coursera."));
        return questions;
    }

    private List<datamodelforinfodetail> getJobQuestions() {
        List<datamodelforinfodetail> questions = new ArrayList<>();
        questions.add(new datamodelforinfodetail(R.drawable.baseline_keyboard_arrow_right_24,
                "Where can I find job listings?",
                "Job listings can be found on online job portals such as Indeed, LinkedIn, and local employment agencies."));
        return questions;
    }

    private void setupAdapter() {
        adapterforinfodetail adapter = new adapterforinfodetail((ArrayList<datamodelforinfodetail>) dataholderforinfodetail, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(datamodelforinfodetail datamodelforinfodetail) {
        Detail_about_info_list_fragment fragment = new Detail_about_info_list_fragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", datamodelforinfodetail.getQuestion());  // Set the question as the title
        bundle.putString("detail", datamodelforinfodetail.getAnswer());  // Set the corresponding answer
        bundle.putString("additionalInfo", "Additional information can go here."); // Optional additional info
        fragment.setArguments(bundle);

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment); // Ensure this ID matches the parent container in your activity
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
