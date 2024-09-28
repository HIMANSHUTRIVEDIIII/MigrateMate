package com.example.migratemate;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivitiesFragment extends Fragment implements myadapter.ItemClickListener {

    RecyclerView recyclerView1, recyclerView2, recyclerView3, recyclerView4, recyclerView5;
    ArrayList<DataModel> dataHolder1, dataHolder2, dataHolder3, dataHolder4, dataHolder5;
    myadapter adapter1, adapter2, adapter3, adapter4, adapter5;
    SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activities, container, false);

        searchView = view.findViewById(R.id.search_view);
        AutoCompleteTextView searchTextView = searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        searchTextView.setTextColor(Color.BLACK);
        searchTextView.setHintTextColor(Color.BLACK);

        recyclerView1 = view.findViewById(R.id.recview1);
        recyclerView2 = view.findViewById(R.id.recview2);
        recyclerView3 = view.findViewById(R.id.recview3);
        recyclerView4 = view.findViewById(R.id.recview4);
        recyclerView5 = view.findViewById(R.id.recview5);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(layoutManager1);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(layoutManager3);
        LinearLayoutManager layoutManager4 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView4.setLayoutManager(layoutManager4);
        LinearLayoutManager layoutManager5 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView5.setLayoutManager(layoutManager5);

        // Add data to each RecyclerView
        dataHolder1 = new ArrayList<>();
        dataHolder1.add(new DataModel(R.drawable.img, "Date & Time: Multiple dates in October 2024", "Western Vadodara Navratri Mahotsav 2024", "https://allevents.in/vadodara/western-vadodara-navratri-mahotsav-2024/200024642018532", "- About: Celebrate the spirit of Navratri with traditional Garba and Dandiya performances. This festival will feature vibrant music, dance, and cultural activities, perfect for families and friends to enjoy."));
        dataHolder1.add(new DataModel(R.drawable.demoimage, "18-1-2024/15:00", "Networking event", "https://www.example.com", "A great opportunity to network with professionals from various fields."));

        dataHolder2 = new ArrayList<>();
        dataHolder2.add(new DataModel(R.drawable.demoimage, "19-1-2024/10:00", "Family gathering", "https://www.familyexample.com", "A casual family get-together with food and games."));
        dataHolder2.add(new DataModel(R.drawable.demoimage, "20-1-2024/12:00", "Birthday party", "https://www.birthdayexample.com", "Celebrate John's 30th birthday with friends and family."));

        dataHolder3 = new ArrayList<>();
        dataHolder3.add(new DataModel(R.drawable.demoimage, "21-1-2024/09:00", "Workshop", "https://www.workshopexample.com", "Hands-on workshop on the latest trends in technology."));
        dataHolder3.add(new DataModel(R.drawable.demoimage, "22-1-2024/11:00", "Seminar", "https://www.seminarexample.com", "A seminar on the future of AI in healthcare."));

        dataHolder4 = new ArrayList<>();
        dataHolder4.add(new DataModel(R.drawable.demoimage, "23-1-2024/08:00", "Morning Yoga", "https://www.yogaexample.com", "Start your day with a refreshing morning yoga sessionStart your day with a refreshing morning yoga sessionStart your day with a refreshing morning yoga sessionStart your day with a refreshing morning yoga sessionStart your day with a refreshing morning yoga sessionStart your day with a refreshing morning yoga session."));
        dataHolder4.add(new DataModel(R.drawable.demoimage, "24-1-2024/07:00", "Cycling Event", "https://www.cyclingexample.com", "Join us for a scenic cycling event around the city."));

        dataHolder5 = new ArrayList<>();
        dataHolder5.add(new DataModel(R.drawable.demoimage, "25-1-2024/18:00", "Dinner Party", "https://www.dinnerexample.com", "An elegant dinner party with a three-course meal."));
        dataHolder5.add(new DataModel(R.drawable.demoimage, "26-1-2024/20:00", "Concert", "https://www.concertexample.com", "Enjoy live music performances by top artists."));

        // Create adapters for each RecyclerView
        adapter1 = new myadapter(dataHolder1, this);
        recyclerView1.setAdapter(adapter1);

        adapter2 = new myadapter(dataHolder2, this);
        recyclerView2.setAdapter(adapter2);

        adapter3 = new myadapter(dataHolder3, this);
        recyclerView3.setAdapter(adapter3);

        adapter4 = new myadapter(dataHolder4, this);
        recyclerView4.setAdapter(adapter4);

        adapter5 = new myadapter(dataHolder5, this);
        recyclerView5.setAdapter(adapter5);

        // Set up the search functionality
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Perform final filtering when the user submits the query
                filterData(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Perform filtering as the user types
                filterData(newText);
                return false;
            }
        });

        return view;
    }

    private void filterData(String query) {
        query = query.toLowerCase();
        ArrayList<DataModel> filteredList1 = new ArrayList<>();
        ArrayList<DataModel> filteredList2 = new ArrayList<>();
        ArrayList<DataModel> filteredList3 = new ArrayList<>();
        ArrayList<DataModel> filteredList4 = new ArrayList<>();
        ArrayList<DataModel> filteredList5 = new ArrayList<>();

        for (DataModel item : dataHolder1) {
            if (item.getDescription().toLowerCase().contains(query) || item.getDate().toLowerCase().contains(query)) {
                filteredList1.add(item);
            }
        }

        for (DataModel item : dataHolder2) {
            if (item.getDescription().toLowerCase().contains(query) || item.getDate().toLowerCase().contains(query)) {
                filteredList2.add(item);
            }
        }

        for (DataModel item : dataHolder3) {
            if (item.getDescription().toLowerCase().contains(query) || item.getDate().toLowerCase().contains(query)) {
                filteredList3.add(item);
            }
        }

        for (DataModel item : dataHolder4) {
            if (item.getDescription().toLowerCase().contains(query) || item.getDate().toLowerCase().contains(query)) {
                filteredList4.add(item);
            }
        }

        for (DataModel item : dataHolder5) {
            if (item.getDescription().toLowerCase().contains(query) || item.getDate().toLowerCase().contains(query)) {
                filteredList5.add(item);
            }
        }

        // Update adapters with the filtered lists
        adapter1.updateList(filteredList1);
        adapter2.updateList(filteredList2);
        adapter3.updateList(filteredList3);
        adapter4.updateList(filteredList4);
        adapter5.updateList(filteredList5);
    }

    @Override
    public void onItemClick(DataModel selectedItem) {
        detail_about_activities_fragment detailFragment = new detail_about_activities_fragment();

        Bundle bundle = new Bundle();
        bundle.putInt("image", selectedItem.getImage());
        bundle.putString("title", selectedItem.getDescription());
        bundle.putString("date", selectedItem.getDate());
        bundle.putString("url", selectedItem.getUrl());
        bundle.putString("additionalInfo", selectedItem.getAdditionalInfo()); // Pass additional information

        detailFragment.setArguments(bundle);

        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.container, detailFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
