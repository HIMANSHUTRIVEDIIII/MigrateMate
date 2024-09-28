package com.example.migratemate;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class InfoFragment extends Fragment implements adapterforinfo.ItemClickListener {
    RecyclerView recyclerView;
    ArrayList<datamodelforinfo> dataholderforinfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        recyclerView = view.findViewById(R.id.recviewforinfo1);
        dataholderforinfo = new ArrayList<>();
        dataholderforinfo.add(new datamodelforinfo(R.drawable.baseline_sports_cricket_24, "Sports"));
        dataholderforinfo.add(new datamodelforinfo(R.drawable.baseline_travel_explore_24, "Culture"));
        dataholderforinfo.add(new datamodelforinfo(R.drawable.baseline_create_24, "Registration"));
        dataholderforinfo.add(new datamodelforinfo(R.drawable.baseline_house_24, "Arranging House"));
        dataholderforinfo.add(new datamodelforinfo(R.drawable.baseline_health_and_safety_24, "Health"));
        dataholderforinfo.add(new datamodelforinfo(R.drawable.baseline_transcribe_24, "Learning Hindi/Gujarati"));
        dataholderforinfo.add(new datamodelforinfo(R.drawable.baseline_screen_search_desktop_24, "Finding Job"));
        dataholderforinfo.add(new datamodelforinfo(R.drawable.baseline_menu_book_24, "Education"));

        adapterforinfo adapter = new adapterforinfo(dataholderforinfo, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        return view;
    }

    @Override
    public void onItemClick(datamodelforinfo selectedItem) {
        ListFragment listFragment = new ListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("category_name", selectedItem.getName()); // Pass the selected category
        listFragment.setArguments(bundle);

        FragmentTransaction transaction = getParentFragmentManager().beginTransaction(); // Use getParentFragmentManager()
        transaction.replace(R.id.container, listFragment); // Ensure R.id.fragment_container matches your layout
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
