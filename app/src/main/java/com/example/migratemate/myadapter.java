package com.example.migratemate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.MyViewHolder> {

    private ArrayList<DataModel> dataList;
    private ItemClickListener clickListener;

    public myadapter(ArrayList<DataModel> dataList, ItemClickListener clickListener) {
        this.dataList = dataList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activitiesdesign, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataModel data = dataList.get(position);
        holder.imageView.setImageResource(data.getImage());
        holder.textViewTitle.setText(data.getDescription());
        holder.textViewDate.setText(data.getDate());

        holder.itemView.setOnClickListener(v -> clickListener.onItemClick(data));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    // Method to update the list based on search
    public void updateList(ArrayList<DataModel> filteredList) {
        this.dataList = filteredList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewTitle, textViewDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img1design);
            textViewTitle = itemView.findViewById(R.id.descriptiondesign);
            textViewDate = itemView.findViewById(R.id.datedesign);
        }
    }

    public interface ItemClickListener {
        void onItemClick(DataModel selectedItem);
    }
}
