package com.example.elluminati;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CounterView extends LinearLayout {

    private int count = 1;
    private TextView textCount;
    private TextView buttonIncrement;
    private TextView buttonDecrement;

    public CounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CounterView(Context context) {
        super(context);
        init(context);
    }
    public CounterView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_counter, this, true);
        setOrientation(HORIZONTAL);

        textCount = findViewById(R.id.text_count);
        buttonIncrement = findViewById(R.id.button_increment);
        buttonDecrement = findViewById(R.id.button_decrement);

        buttonIncrement.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementCount();
            }
        });

        buttonDecrement.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementCount();
            }
        });

        updateCountText();
    }

    private void incrementCount() {
        count++;
        updateCountText();
    }

    private void decrementCount() {
        if (count > 1) {
            count--;
            updateCountText();
        }
    }

    private void updateCountText() {
        textCount.setText(String.valueOf(count));
    }

    public int getCounter() {
        return count;
    }

    public void setCounter(int counter) {
        this.count = count;
        textCount.setText(String.valueOf(counter));
    }
}
