package net.androidbootcamp.electriccarfinancing;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //non-static variables for xml tag element's values
    int intYears;
    int intLoan;
    float decInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //constant variables referencing xml tag elements
        final EditText years = (EditText)findViewById(R.id.txtYears);
        final EditText loan = (EditText)findViewById(R.id.txtLoan);
        final EditText interest = (EditText)findViewById(R.id.txtInterest);

        Button button = (Button) findViewById(R.id.btnPayment);
        final SharedPreferences sharePref = PreferenceManager.getDefaultSharedPreferences(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reads user input values when button element is pressed
                intYears = Integer.parseInt(years.getText().toString());
                intLoan = Integer.parseInt(loan.getText().toString());
                decInterest = Float.parseFloat(interest.getText().toString());

                //save entered values in editor variable
                SharedPreferences.Editor editor = sharePref.edit();
                editor.putInt("key1", intYears);
                editor.putInt("key2", intLoan);
                editor.putFloat("key3", decInterest);
                editor.commit();

                //load payment activity
                startActivity(new Intent(MainActivity.this, Payment.class));
            }
        });
    }
}