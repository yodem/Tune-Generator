package com.example.tinwhistle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CreateTune extends View {

    private List<Integer> Tune;
    private int Scale;
    public CreateTune(Context context, int Scale, List<Integer> Tune) {
        super(context);
        this.Tune = Tune;
        this.Scale = Scale;
    }
    public void onDraw(Canvas canvas){
        TinWhistle tempTin;
        for (int i = 0; i < Tune.size(); i++) {
            tempTin = new TinWhistle(getContext(),this.Scale, Tune.get(i));
            tempTin.draw(canvas);
        }
    }
}
