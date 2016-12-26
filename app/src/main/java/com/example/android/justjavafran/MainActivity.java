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

        Button plusButton = (Button) findViewById(R.id.button_plus);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity++;
                display(view);
            }
        });

        Button minusButton = (Button) findViewById(R.id.button_minus);
        minusButton.setOnClickListener(new View.OnClickListener() {
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

        Button orderButton = (Button) findViewById(R.id.submit_order_button);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) findViewById(R.id.display_order_view);
                int price = 5;
                String message = "Thanks for buying with us\nYou bought " + quantity + " cups of coffee";
                message+= "\nThe total price amounts to: " + (price*quantity) + " euros";
                textView.setText(message);
                
            }
        });
    }

    public void display(View view) {
        TextView textView = (TextView) findViewById(R.id.display_quantity_view);
        textView.setText(quantity + "");
    }

}