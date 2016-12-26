package com.example.android.justjavafran;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int quantity = 1;
    private boolean addWhippedCream = false;
    private boolean addChocolate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = (EditText) findViewById(R.id.name_edittext);
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText("");
            }
        });

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
                if (quantity > 1) {
                    quantity--;
                }
                if (quantity == 1)
                    Toast.makeText(MainActivity.this, "Minimum number of cups of coffee reached", Toast.LENGTH_SHORT).show();
                display(view);
            }
        });

        Button orderButton = (Button) findViewById(R.id.submit_order_button);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String orderDetails = calculateOrderDetails();
                sendEmail(orderDetails);
            }
        });

        final CheckBox addWhippedCreamcheckBox = (CheckBox) findViewById(R.id.add_whipped_cream_checkbox);
        addWhippedCreamcheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (addWhippedCreamcheckBox.isChecked()) {
                    Log.v("MainActivity", "addWhippedCreamcheckBox.isChecked()");
                    addWhippedCream = true;
                }
            }
        });

        final CheckBox addChocolateCheckBox = (CheckBox) findViewById(R.id.add_chocolate_checkbox);
        addChocolateCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (addChocolateCheckBox.isChecked()) {
                    addChocolate = true;
                }
            }
        });
    }

    @NonNull
    private String calculateOrderDetails() {
        int price = 5;
        String addedWhippedCream = "No";
        String addedChocolate = "No";
        if (addWhippedCream) {
            price += 1;
            addedWhippedCream = "Yes";
        }
        if (addChocolate) {
            price += 2;
            addedChocolate = "Yes";
        }

        String message = "Thanks for buying with us!\nYou've bought " + quantity + " cups of coffee";
        message += "\nHave you added whipped cream? " + addedWhippedCream;
        message += "\nHave you added chocolate? " + addedChocolate;
        message += "\nThe total price amounts to: " + (price * quantity) + " euros";
        return message;
    }

    @NonNull
    private void sendEmail(String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "java@udacity.com");
        final EditText name = (EditText) findViewById(R.id.name_edittext);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order for " + name.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }

    public void display(View view) {
        TextView textView = (TextView) findViewById(R.id.display_quantity_view);
        textView.setText(quantity + "");
    }

}