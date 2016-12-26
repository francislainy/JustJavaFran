package com.example.android.justjavafran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPlus = (Button) findViewById(R.id.button_plus);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity++;
                display(view);
            }
        });

        Button buttonMinus = (Button) findViewById(R.id.button_minus);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantity > 1){
                    quantity--;
                }
                if(quantity == 1)
                    Toast.makeText(MainActivity.this, "Minimum number of cups of coffee reached", Toast.LENGTH_SHORT).show();
                display(view);
            }
        });
        

    }

    public void display(View view) {
        TextView textView = (TextView) findViewById(R.id.display_order_view);
        textView.setText(quantity + "");
    }

}