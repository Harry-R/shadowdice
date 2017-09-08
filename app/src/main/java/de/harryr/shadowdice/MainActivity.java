package de.harryr.shadowdice;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // declare UI elements
    NumberPicker numpicker;
    TextView txtv_content;
    TextView txtv_headline;


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
        txtv_headline = (TextView) findViewById(R.id.txtv_headline);

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

            txtv_content.setText(String.format(Locale.US, "%s %d ",
                    txtv_content.getText().toString(), result));

            if (result >= 5) {
                hits++;
            } else if (result == 1) {
                glitches++;
            }
        }

        // check for (critical) glitch
        if (glitches > hits && hits == 0) {
            txtv_headline.setText(R.string.critical_glitch);
            txtv_headline.setTextColor(Color.RED);
        } else if (glitches > hits) {
            txtv_headline.setText(R.string.glitch);
            txtv_headline.setTextColor(Color.RED);
        } else {
            txtv_headline.setText(String.format(Locale.US, "%d hits!", hits));
            txtv_headline.setTextColor(Color.GREEN);
        }
        txtv_content.setText(String.format(Locale.US, "%s hits: %d glitches: %d\n",
                txtv_content.getText().toString(), hits, glitches));
    }


    /**
     * On click listener for "roll dices" button
     * @param v view, that activated the on click listener
     */
    public void btn_rollDices_onclick(View v) {
        rollDices(numpicker.getValue());
    }


    /**
     * Clear text fields
     * @param v view, that activated the on click listener
     */
    public void btn_clearLog_onClick(View v) {
        txtv_headline.setText("");
        txtv_content.setText("");
    }
}
