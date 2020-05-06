package com.example.test_bmi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BMIAdapter extends RecyclerView.Adapter<BMIAdapter.ViewHolder> {
    @NonNull

    private List<item_list> bmilist;

    public BMIAdapter(@NonNull List<item_list> bmilist) {
        this.bmilist = bmilist;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        item_list item_list = bmilist.get(position);
        holder.height.setText(item_list.height);
        holder.weight.setText(item_list.weight);
        holder.bmi.setText(item_list.bmi);

    }

    @Override
    public int getItemCount() {
        if(bmilist != null) {
            return bmilist.size();
        } else {
            return 0;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView height;
        private final TextView weight;
        private final TextView bmi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            height = (TextView) itemView.findViewById(R.id.tv_height);
            weight = (TextView) itemView.findViewById(R.id.tv_weight);
            bmi = (TextView) itemView.findViewById(R.id.tv_bmi);
        }
    }
}

