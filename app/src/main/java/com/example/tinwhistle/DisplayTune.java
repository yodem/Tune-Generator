package com.example.tinwhistle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.os.Bundle;

import java.util.List;

public class DisplayTune extends AppCompatActivity {

    List<Integer> Tune;
    CreateTune cr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_tune);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Tune = extras.getIntegerArrayList("TuneNotes");
            cr = new CreateTune(getApplicationContext(),5,Tune);
            setContentView(cr);
            //The key argument here must match that used in the other activity
        }
    }
}