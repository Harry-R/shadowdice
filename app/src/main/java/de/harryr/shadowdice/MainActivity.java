package de.harryr.shadowdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    NumberPicker numpicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find views
        numpicker = (NumberPicker) findViewById(R.id.numpicker);

        // set up numpicker
        numpicker.setMaxValue(30);
        numpicker.setMinValue(0);
        numpicker.setWrapSelectorWheel(false);
    }
}
