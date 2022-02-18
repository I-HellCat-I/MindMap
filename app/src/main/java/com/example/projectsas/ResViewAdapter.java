package com.example.projectsas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResViewAdapter extends RecyclerView.Adapter<ResViewAdapter.MindMapViewHolder> {
    ArrayList<MindMapFA> MindMaps;
    private int numberOfItems;
    private static int viewHolderCount;
    protected Context parent;

    ResViewAdapter (@NonNull Context parent, int numberOfItems, ArrayList<MindMapFA> mindMaps){
        this.numberOfItems = numberOfItems;
        this.parent = parent;
        this.MindMaps = mindMaps;
        viewHolderCount = 0;
    }

    @NonNull
    @Override
    public MindMapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.mindmap_rv_element, parent, false);
        MindMapViewHolder viewHolder;
        try {
            viewHolder = new MindMapViewHolder(v, MindMaps.get(viewHolderCount).getName());
            viewHolderCount++;
        } catch (IndexOutOfBoundsException e) {
            viewHolder = new MindMapViewHolder(v, "");
        }
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
        String name;
        TextView listMindMapNameView;
        TextView viewHolderIndex;
        ImageView preview;
        public MindMapViewHolder(@NonNull View itemView, String name) {
            super(itemView);

            listMindMapNameView = itemView.findViewById(R.id.rv_mm_item);
            viewHolderIndex = itemView.findViewById(R.id.rv_mm_view_holder_number);
            this.name = name;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int positionIndex = getAdapterPosition();
                    MainActivity.changeFragment("editorFragment", null);
                }
            });
        }
        void bind(int listIndex){
            listMindMapNameView.setText(String.valueOf(name));
        }
    }
}
