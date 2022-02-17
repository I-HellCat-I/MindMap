package com.example.projectsas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResViewAdapter extends RecyclerView.Adapter<ResViewAdapter.MindMapViewHolder> {
    ArrayList<MindMapFA> MindMaps;
    private int numberOfItems;
    private static int viewHolderCount;
    protected Context parent;

    ResViewAdapter (@NonNull Context parent, int numberOfItems){
        this.numberOfItems = numberOfItems;
        this.parent = parent;
        viewHolderCount = 0;
    }

    @NonNull
    @Override
    public MindMapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.mindmap_rv_element, parent, false);
        MindMapViewHolder viewHolder = new MindMapViewHolder(v);
        viewHolder.viewHolderIndex.setText("ViewHolder Index: " + viewHolderCount);
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MindMapViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberOfItems;
    }

    class MindMapViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        TextView listItemNumberView;
        TextView viewHolderIndex;
        ImageView preview;
        public MindMapViewHolder(@NonNull View itemView) {
            super(itemView);

            listItemNumberView = itemView.findViewById(R.id.rv_mm_item);
            viewHolderIndex = itemView.findViewById(R.id.rv_mm_view_holder_number);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int positionIndex = getAdapterPosition();
                    Toast.makeText(parent, "Not today: " + positionIndex, Toast.LENGTH_SHORT).show();
                }
            });
        }
        void bind(int listIndex){
            listItemNumberView.setText(String.valueOf(listIndex));
        }
    }
}
