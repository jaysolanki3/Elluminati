package com.example.elluminati.Adapter;

import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elluminati.DataModel.Item;
import com.example.elluminati.DataModel.SpecificationItem;
import com.example.elluminati.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {


    Integer totalprice = 0;
    private List<Item> items;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(Item item, CheckBox[] cb, Integer flag);
    }

    public ItemAdapter(List<Item> items, OnItemClickListener onItemClickListener) {
        this.items = items;
        this.onItemClickListener = (OnItemClickListener) onItemClickListener;
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
        Integer[] price = new Integer[4];
        Integer[] id = new Integer[4];
        int i = 0;
        Item item = items.get(position);
        List<SpecificationItem> filteredItems = new ArrayList<>();



        holder.ntitle.setText(item.getName().get(0));
        for (SpecificationItem specItem : item.getList())
        {
            id[i] = specItem.getUnique_id();
            rows[i] = specItem.getName().get(0);
            price[i] = specItem.getPrice();
            i++;
        }

        if(item.getUnique_id() == 1617 || item.getUnique_id() == 1616){
            holder.r4.setVisibility(View.GONE);
            holder.item1.setText(rows[0]);
            holder.item2.setText(rows[1]);
            holder.item3.setText(rows[2]);
            holder.price1.setText("₹"+price[0]+".00");
            holder.price2.setText("₹"+price[1]+".00");
            holder.price3.setText("₹"+price[2]+".00");
        } else if (item.getUnique_id() == 1614) {
            holder.r3.setVisibility(View.GONE);
            holder.r4.setVisibility(View.GONE);
            holder.item1.setText(rows[0]);
            holder.item2.setText(rows[1]);
            holder.price1.setText("₹"+price[0]+".00");
            holder.price2.setText("₹"+price[1]+".00");
        } else if (item.getUnique_id() == 1615) {
            holder.item1.setText(rows[0]);
            holder.item2.setText(rows[1]);
            holder.item3.setText(rows[2]);
            holder.item4.setText(rows[3]);
            holder.price1.setText("₹"+price[0]+".00");
            holder.price2.setText("₹"+price[1]+".00");
            holder.price3.setText("₹"+price[2]+".00");
            holder.price4.setText("₹"+price[3]+".00");
        }
        Integer j;

        for( j =0 ; j<4 ;j++){
            Integer finalJ = j;
            holder.cb[j].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        for(SpecificationItem specitem : item.getList()){
                            if(specitem.getUnique_id() == id[finalJ]){
                                specitem.setIs_default_selected(true);
                            }
                        }
                    }
                    onItemClickListener.onItemClick(item,holder.cb,0);
                    Log.e("ITEMADAPTER", "HIII");
                }
            });
        }
        onItemClickListener.onItemClick(item,holder.cb,1);
        Log.e("ITEMADAPTER", "HELLOOOOOO");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateItems(List<Item> newItems)
    {
        items = newItems;

        notifyDataSetChanged();
    }

    public void updateItems1() {
        notifyDataSetChanged();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        CheckBox[] cb = new CheckBox[4];
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
            cb[0] = item1;
            cb[1] = item2;
            cb[2] = item3;
            cb[3] = item4;
        }
    }
}
