package com.example.elluminati.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elluminati.DataModel.Item;
import com.example.elluminati.DataModel.SpecificationItem;
import com.example.elluminati.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Item> items;

    public ItemAdapter(List<Item> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        String[] rows = new String[4];
        String[] price = new String[4];
        int i = 0;
        Item item = items.get(position);

        holder.ntitle.setText(item.getName().get(0));
        for (SpecificationItem specItem : item.getList())
        {
            rows[i] = specItem.getName().get(0);
            price[i] = "₹"+specItem.getPrice()+".00";
            i++;
        }
        if(item.getUnique_id() == 1617 || item.getUnique_id() == 1616){
            holder.r4.setVisibility(View.GONE);
            holder.item1.setText(rows[0]);
            holder.item2.setText(rows[1]);
            holder.item3.setText(rows[2]);
            holder.price1.setText(price[0]);
            holder.price2.setText(price[1]);
            holder.price3.setText(price[2]);
        } else if (item.getUnique_id() == 1614) {
            holder.r3.setVisibility(View.GONE);
            holder.r4.setVisibility(View.GONE);
            holder.item1.setText(rows[0]);
            holder.item2.setText(rows[1]);
            holder.price1.setText(price[0]);
            holder.price2.setText(price[1]);
        } else if (item.getUnique_id() == 1615) {
            holder.item1.setText(rows[0]);
            holder.item2.setText(rows[1]);
            holder.item3.setText(rows[2]);
            holder.item4.setText(rows[3]);
            holder.price1.setText(price[0]);
            holder.price2.setText(price[1]);
            holder.price3.setText(price[2]);
            holder.price4.setText(price[3]);
        }


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateItems(List<Item> newItems) {
        items = newItems;
        notifyDataSetChanged();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView ntitle, price1, price2, price3, price4;
        public CheckBox item1,item2,item3,item4;
        public TableRow r3,r4;
//        public TextView uniqueIdTextView;
//        public TextView specificationsTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ntitle = itemView.findViewById(R.id.title);
            price1 = itemView.findViewById(R.id.price1);
            price2 = itemView.findViewById(R.id.price2);
            price3 = itemView.findViewById(R.id.price3);
            price4 = itemView.findViewById(R.id.price4);
            item1 = itemView.findViewById(R.id.item1);
            item2 = itemView.findViewById(R.id.item2);
            item3 = itemView.findViewById(R.id.item3);
            item4 = itemView.findViewById(R.id.item4);
            r3 = itemView.findViewById(R.id.row3);
            r4 = itemView.findViewById(R.id.row4);
        }
    }
}
