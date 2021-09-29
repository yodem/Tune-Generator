package com.example.tinwhistle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tinwhistle.databinding.ActivityMainBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Entrance extends AppCompatActivity {

    List<Integer> TuneList = new ArrayList<Integer>();
    int[] noteArr;
    EditText TuneInput;
    Button createTune;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);
        TuneInput = (EditText) findViewById(R.id.TuneNotes);
        createTune = (Button) findViewById(R.id.CreateTuneSheet);
        createTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayToList(TuneInput);
                createATuneSheet(v);
            }
        });

    }
    public void createATuneSheet(View view){
        Intent intent = new Intent(Entrance.this, DisplayTune.class);
        intent.putExtra("TuneNotes", (Serializable) TuneList);
        startActivity(intent);
    }

    public void ArrayToList(EditText et){
        EditTextToArray(et);
        for(int note : noteArr){
            TuneList.add(note);
        }
    }

    public void EditTextToArray(EditText et){
        if(!et.getText().toString().isEmpty()) {
            noteArr = new int[et.getText().toString().length()];

            for (int i = 0; i < et.getText().toString().length(); i++) {
                noteArr[i] = Character.getNumericValue(et.getText().toString().charAt(i));
            }
        }
    }
}