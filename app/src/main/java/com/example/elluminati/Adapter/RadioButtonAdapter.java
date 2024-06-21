package com.example.elluminati.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elluminati.Customize;
import com.example.elluminati.DataModel.SpecificationItem;
import com.example.elluminati.R;

import java.util.List;

public class RadioButtonAdapter extends RecyclerView.Adapter<RadioButtonAdapter.RadioButtonViewHolder> {

    private List<SpecificationItem> items;
    private int selectedPosition = 0;
    private OnItemClickListener onItemClickListener;
    String modifier;

    Button addtocart;


    public interface OnItemClickListener {
        void onItemClick(SpecificationItem item,String modifier, Integer price);
    }


    public RadioButtonAdapter(List<SpecificationItem> items, OnItemClickListener onItemClickListener) {
        this.items = items;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public RadioButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_radio_button, parent, false);
        return new RadioButtonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RadioButtonViewHolder holder, int position) {
        SpecificationItem item = items.get(position);
        holder.radioButton.setChecked(position == selectedPosition);
        holder.textViewName.setText(item.getName().get(0));
        holder.textViewPrice.setText("₹ " + item.getPrice() + ".00");

        String flag = "First";
        if(selectedPosition == 0){
            onItemClickListener.onItemClick(item,"First",item.getPrice());
        }

        holder.itemView.setOnClickListener(v -> {
            selectedPosition = holder.getAdapterPosition();


            //if(selectedPosition == 0 ){modifier = "1 BHK";}
            if ( selectedPosition == 1){ modifier = "2 BHK"; }
            else if ( selectedPosition == 2){ modifier = "3 BHK"; }
            else if ( selectedPosition == 3){ modifier = "4 BHK"; }
            else if ( selectedPosition == 4){ modifier = ">4 BHK"; }
            else  { modifier = "1 BHK"; }

            notifyDataSetChanged();
            onItemClickListener.onItemClick(item,modifier,item.getPrice());
        });

        holder.radioButton.setOnClickListener(v -> {
            selectedPosition = holder.getAdapterPosition();

            Log.i("Position", String.valueOf(selectedPosition ));
            //if(selectedPosition == 0 ){modifier = "1 BHK";}
             if ( selectedPosition == 1){ modifier = "2 BHK"; }
            else if ( selectedPosition == 2){ modifier = "3 BHK"; }
            else if ( selectedPosition == 3){ modifier = "4 BHK"; }
            else if ( selectedPosition == 4){ modifier = ">4 BHK"; }
            else  { modifier = "1 BHK"; }
            notifyDataSetChanged();
            onItemClickListener.onItemClick(item,modifier,item.getPrice());
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class RadioButtonViewHolder extends RecyclerView.ViewHolder {
        RadioButton radioButton;
        TextView textViewName;
        TextView textViewPrice;

        public RadioButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            radioButton = itemView.findViewById(R.id.radioButton);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }
    }

}
