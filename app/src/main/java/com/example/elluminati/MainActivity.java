package com.example.elluminati;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button customize, viewcrt , increment;
    CounterView counterView;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.holo_blue_light)));
        customize = findViewById(R.id.btn_customize);
        viewcrt = findViewById(R.id.viewcart);
        counterView = findViewById(R.id.counterView);

        Intent intent = getIntent();
        Integer i = intent.getIntExtra("btnvisible",0);
        Integer price = intent.getIntExtra("totalprice",0);
        if( i == 1){
            customize.setVisibility(View.GONE);
            counterView.setVisibility(View.VISIBLE);

        }

        customize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Customize.class);
                startActivity(intent);
            }
        });

        viewcrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Checkout.class);
                i.putExtra("totalprice",price);
                startActivity(i);
            }
        });
    }


}