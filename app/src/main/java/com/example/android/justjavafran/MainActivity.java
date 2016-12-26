package com.example.android.justjavafran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = (Button) findViewById(R.id.button_plus);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(v);
            }
        });

    }






//        final TextView textView = (TextView) findViewById(R.id.display_order_view);
//        Button buttonPlus = (Button) findViewById(R.id.button_plus);
//        buttonPlus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                quantity++;
//                Log.v("MainActivity", "quantity " + quantity);
//                textView.setText(quantity+"");
//            }
//        });

    public void display(View view) {
        Log.v("MainActivity", "quantity " + quantity);
        quantity++;
        TextView textView = (TextView) findViewById(R.id.display_order_view);
        textView.setText(quantity + "");
    }

}

