package de.harryr.shadowdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // declare UI elements
    NumberPicker numpicker;
    TextView txtv_content;

    /**
     * Called on App creation, init the UI
     * @param savedInstanceState saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init UI elements
        numpicker = (NumberPicker) findViewById(R.id.numpicker);
        txtv_content = (TextView) findViewById(R.id.txtv_content);

        // set up numpicker
        numpicker.setMaxValue(30);
        numpicker.setMinValue(0);
        numpicker.setWrapSelectorWheel(false);
    }


    /**
     * "core" function, roll dices, evaluates hits and glitches, write to text fields
     * @param numberDices dice pool size
     */
    private void rollDices(int numberDices) {
        int hits = 0;
        int glitches = 0;
        int result;

        Random rand = new Random();

        for (int i = 0; i < numberDices; i++) {

            result = (rand.nextInt(6) + 1);

            txtv_content.setText(String.format("%s %d ", txtv_content.getText().toString(), result));

            if (result >= 5) {
                hits++;
            } else if (result == 1) {
                glitches++;
            }
        }
        txtv_content.setText(String.format("%s hits: %d glitches: %d\n", txtv_content.getText().toString(), hits, glitches));
    }


    /**
     * On click listener for "roll dices" button
     * @param v view, that activated the on click listener
     */
    public void btn_rollDices_onclick(View v) {
        rollDices(numpicker.getValue());
    }
    
}
