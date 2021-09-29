package com.example.tinwhistle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;

import com.example.tinwhistle.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String beforeNotes = binding.beforeNotes.getText().toString();
                String[] splitNotes = beforeNotes.split("");
                String[] afterNotesAr = new String[splitNotes.length];
                int counter = 0;
                for(String s:splitNotes){
                    int inc = Integer.parseInt(s) + 1;
                    afterNotesAr[counter] = inc +"";
                    counter++;
                }
                String afterNotes = "";
                String newBeforeNotes = "";
                for(String s:afterNotesAr){
                    afterNotes += s + " ";
                }
                for(String s:afterNotesAr){
                    newBeforeNotes += s;
                }
                binding.afterNotes.setText(afterNotes.trim());
                binding.afterNotes.setVisibility(View.VISIBLE);
                binding.beforeNotes.setText(newBeforeNotes);
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Notes", afterNotes.trim());
                clipboard.setPrimaryClip(clip);
            }
        });
        binding.down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String beforeNotes = binding.beforeNotes.getText().toString();
                String[] splitNotes = beforeNotes.split("");
                String[] afterNotesAr = new String[splitNotes.length];
                int counter = 0;
                for(String s:splitNotes){
                    int inc = Integer.parseInt(s) - 1;
                    afterNotesAr[counter] = inc +"";
                    counter++;
                }
                String afterNotes = "";
                String newBeforeNotes = "";
                for(String s:afterNotesAr){
                    afterNotes += s + " ";
                }
                for(String s:afterNotesAr){
                    newBeforeNotes += s;
                }
                binding.afterNotes.setText(afterNotes.trim());
                binding.afterNotes.setVisibility(View.VISIBLE);
                binding.beforeNotes.setText(newBeforeNotes);
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Notes", afterNotes.trim());
                clipboard.setPrimaryClip(clip);
            }
        });
    }
}