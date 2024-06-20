package com.example.elluminati;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elluminati.Adapter.ItemAdapter;
import com.example.elluminati.Adapter.RadioButtonAdapter;
import com.example.elluminati.DataModel.Item;
import com.example.elluminati.DataModel.SpecificationItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Customize extends AppCompatActivity {

    Toolbar toolbar;
    private List<Item> allItems;
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    Button addtocart;

    private RecyclerView recyclerView1;
    private RadioButtonAdapter adapter;
    private List<SpecificationItem> radioButtonItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customize);

        addtocart = findViewById(R.id.viewcart);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar ()!= null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView1 = findViewById(R.id.recyclerView1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        radioButtonItems = new ArrayList<>();
        radioButtonItems.add(new SpecificationItem("1 BHK", 999));
        radioButtonItems.add(new SpecificationItem("2 BHK", 1999));
        radioButtonItems.add(new SpecificationItem("3 BHK", 2999));
        radioButtonItems.add(new SpecificationItem("4 BHK", 3999));
        radioButtonItems.add(new SpecificationItem(">4 BHK", 4999));

        adapter = new RadioButtonAdapter(radioButtonItems, this::updateDetailList);
        loadJsonFromAssets();

        itemAdapter = new ItemAdapter(allItems);

        recyclerView1.setAdapter(adapter);
        recyclerView.setAdapter(itemAdapter);

    }
    private void updateDetailList(SpecificationItem item,String modifier,Integer price) {

        List<Item> newDetails = new ArrayList<>();
        for(Item item2 : allItems){
            if(item2.getModifierName().equalsIgnoreCase(modifier)){
                newDetails.add(item2);
            }
        }
        itemAdapter.updateItems(newDetails);
        String btn = "ADD TO CART ₹"+price+".00";
        addtocart.setText(btn);
        Log.e("price",btn);
    }

    private void loadJsonFromAssets() {
        // List<Item> items = new ArrayList<>();
        try {
            InputStream is = getAssets().open("item_data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");

            // Using Gson to parse JSON
            Gson gson = new Gson();
            Type itemType = new TypeToken<ArrayList<Item>>() {}.getType();
            allItems = gson.fromJson(json, itemType);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Item> filterItemsByModifier(String modifier) {
        List<Item> filteredItems = new ArrayList<>();
        for (Item item : allItems) {
//            for (SpecificationItem specItem : item.getList()) {
//                if (specItem.getName().get(0).equalsIgnoreCase(modifier)) {
//                    filteredItems.add(item);
//                    break;
//                }
//            }
            if(item.getModifierName().equalsIgnoreCase(modifier)){
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }
}