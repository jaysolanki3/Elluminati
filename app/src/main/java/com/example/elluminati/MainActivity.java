package com.example.elluminati;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ListIterator;

import me.leolin.shortcutbadger.ShortcutBadger;

public class MainActivity extends AppCompatActivity {

    Button customize, viewcrt , increment;
    LinearLayout counterView;
    TextView btndecr,btnincr,display;
    Integer counter= 0;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.holo_blue_light)));

        customize = findViewById(R.id.btn_customize);
        viewcrt = findViewById(R.id.viewcart);
        btndecr = findViewById(R.id.button_decrement);
        btnincr = findViewById(R.id.button_increment);
        display = findViewById(R.id.text_count);
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

                if(counter == 0){
                    counter = 1;
                    Intent intent = new Intent(getApplicationContext(), Customize.class);
                    startActivity(intent);
                }
                else {
                showDialog();}
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

    private void showDialog(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_dialog);

        Button btnCustom = dialog.findViewById(R.id.btn_cust);
        Button btRepeat = dialog.findViewById(R.id.btn_repeat);

        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Customization",Toast.LENGTH_SHORT).show();
            }
        });
        btRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Repeat",Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }


}