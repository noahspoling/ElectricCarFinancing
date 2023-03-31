package net.androidbootcamp.electriccarfinancing;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        //variable instances for xml layout tags
        TextView monthlyPayment = (TextView) findViewById(R.id.txtMonthlyPayment);
        ImageView image = (ImageView) findViewById(R.id.imgYears);

        //retrieve entries from last activity contained in shared preferences
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int intYears = sharedPref.getInt("key1", 0);
        int intLoan = sharedPref.getInt("key2", 0);
        float decInterest = sharedPref.getFloat("key3", 0);

        float decMonthlyPayment;
        decMonthlyPayment = ( intLoan * ( 1 + (decInterest*intYears) ) ) / (12 * intYears);
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        monthlyPayment.setText("Monthly Payment: " + currency.format(decMonthlyPayment));

        //sets the image based on value of intYears
        if (intYears == 3) {
            image.setImageResource(R.drawable.three);
        } else if (intYears == 4) {
            image.setImageResource(R.drawable.four);
        } else if (intYears == 5) {
            image.setImageResource(R.drawable.five);
        } else {
            monthlyPayment.setText("Enter 3, 4, or 5 years");
        }
    }
}