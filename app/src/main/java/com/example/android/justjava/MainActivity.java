package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view)
    {
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whippedCream);
                boolean haswhippedCream = whippedCream.isChecked();

        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate);
                boolean hasChocolate = chocolate.isChecked();

        EditText text1 = (EditText) findViewById(R.id.customerName);
        String input =  text1.getText().toString();

        int price = calculatePrice();
        String priceMsg= createOrderSummary(input, price, haswhippedCream, hasChocolate) ;
        displayMessage(priceMsg );
    }


    /**
     * Calculates the price of the order.
     *return totalprice
     */
    private int calculatePrice()
    {
        int price = quantity * 5;
        return price;
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberr) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberr);
    }

    public void increment(View view)
    {
        quantity = quantity + 1 ;
        displayQuantity(quantity);
    }

    public void decrement(View view)
    {
        quantity = quantity - 1 ;
        displayQuantity(quantity);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_Textview);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView  orderSummaryTextView = (TextView) findViewById(R.id.order_summary_Textview);
        orderSummaryTextView.setText(message);

    }

    private String createOrderSummary( String input, int price, boolean addwhippedCream, boolean chocolatee)
    {
     String priceMsg = "Name:" +input;
     priceMsg += "\nAdd whipped cream??" +addwhippedCream;
     priceMsg += "\nHas Chocolate??" + chocolatee;
     priceMsg = priceMsg + "\nQuantity " +quantity;
     priceMsg = priceMsg + "\nTotal:" +price;
     priceMsg = priceMsg + " \nThank you" ;

     return priceMsg;
    }
}