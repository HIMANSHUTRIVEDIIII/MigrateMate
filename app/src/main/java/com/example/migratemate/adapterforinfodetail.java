package com.example.migratemate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterforinfodetail extends RecyclerView.Adapter<adapterforinfodetail.myviewholderforinfodetail> {

    ArrayList<datamodelforinfodetail> dataholderforinfodetail;
    ItemClickListener itemClickListener;

    // Constructor
    public adapterforinfodetail(ArrayList<datamodelforinfodetail> dataholderforinfodetail, ItemClickListener itemClickListener) {
        this.dataholderforinfodetail = dataholderforinfodetail;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public myviewholderforinfodetail onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_detail_design_for_recyclerview, parent, false);
        return new myviewholderforinfodetail(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholderforinfodetail holder, int position) {
        datamodelforinfodetail currentItem = dataholderforinfodetail.get(position);
        holder.image.setImageResource(currentItem.getImage());
        holder.detail.setText(currentItem.getQuestion());

        // Handle item clicks
        holder.itemView.setOnClickListener(v -> itemClickListener.onItemClick(currentItem));
    }

    @Override
    public int getItemCount() {
        return dataholderforinfodetail.size();
    }

    class myviewholderforinfodetail extends RecyclerView.ViewHolder {
        ImageView image;
        TextView detail;

        public myviewholderforinfodetail(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageViewforinfodetail);
            detail = itemView.findViewById(R.id.textviewforinfodetail);
        }
    }

    // Interface to handle item clicks
    public interface ItemClickListener {
        void onItemClick(datamodelforinfodetail datamodelforinfodetail);
    }
}
