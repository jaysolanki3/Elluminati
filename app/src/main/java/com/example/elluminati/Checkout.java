package com.example.elluminati;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Checkout extends AppCompatActivity {

    TextView totalprice, totalprice1, totalprice2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_checkout);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.holo_blue_light)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        totalprice = findViewById(R.id.totalprice);
        totalprice1 = findViewById(R.id.totalprice1);
        totalprice2 = findViewById(R.id.totalpricefinal);

        Intent intent = getIntent();
        Integer price = intent.getIntExtra("totalprice",0);

        totalprice.setText("₹ "+price+".00");
        totalprice1.setText("₹ "+price+".00");

        Integer price1 = price +195;

        totalprice2.setText("₹ "+price1+".40");
    }
}