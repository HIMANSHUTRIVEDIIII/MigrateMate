package com.example.migratemate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterforinfo extends RecyclerView.Adapter<adapterforinfo.myviewholderforinfo> {
    ArrayList<datamodelforinfo> dataholderforinfo;
    private ItemClickListener clickListener;

    public adapterforinfo(ArrayList<datamodelforinfo> dataholderforinfo, ItemClickListener clickListener) {
        this.dataholderforinfo = dataholderforinfo;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public myviewholderforinfo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_design, parent, false);
        return new myviewholderforinfo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholderforinfo holder, int position) {
        holder.img.setImageResource(dataholderforinfo.get(position).getImage());
        holder.detail.setText(dataholderforinfo.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = holder.getAdapterPosition();
                if (currentPosition != RecyclerView.NO_POSITION) {
                    clickListener.onItemClick(dataholderforinfo.get(currentPosition));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataholderforinfo.size();
    }

    class myviewholderforinfo extends RecyclerView.ViewHolder {
        ImageView img;
        TextView detail;

        public myviewholderforinfo(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img11design);
            detail = itemView.findViewById(R.id.detaildesign);
        }
    }

    public interface ItemClickListener {
        void onItemClick(datamodelforinfo datamodelforinfo);
    }
}
