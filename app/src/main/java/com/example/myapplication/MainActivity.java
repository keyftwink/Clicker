package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int counter = 0;
    int limit = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("SetTextI18n")
    public void onButtonAdd(View view) {
        counter++;
        TextView counterView = findViewById(R.id.textView);
        TextView figureOval = findViewById(R.id.textView2);
        if (counter >= limit) {
            ViewGroup.LayoutParams ovalParams = figureOval.getLayoutParams();
            ovalParams.width = (figureOval.getWidth() + 40);
            ovalParams.height = (figureOval.getHeight() + 40);
            figureOval.setLayoutParams(ovalParams);
            limit *= 10;
        }
        counterView.setText(Integer.toString(counter));
    }

    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray("data", new int[]{counter, limit});
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("data")) {
            int[] data = savedInstanceState.getIntArray("data");
            counter = data[0];
            limit = data[1];
            resetUI();
        }
    }

    protected void resetUI() {
        TextView counterView = findViewById(R.id.textView);
        counterView.setText(String.valueOf(counter));
    }
}
