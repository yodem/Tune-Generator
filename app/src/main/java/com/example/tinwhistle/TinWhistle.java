package com.example.tinwhistle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class TinWhistle extends View {

    private int TinH, TinW, TinD, Scale, CircleDistance, CircleRadius;
    private static int counter, row = 0;
    private int InitialPosX = 20;
    private int InitialPosY = 100;
    private int Multiply = 60;
    private int Div = 4;
    private int Add = 10;
    private Notes note;
    private Paint brushS,brushF;

    public TinWhistle(Context context, int Scale, int note) {
        super(context);
        this.Scale = Scale;
        this.TinH = Scale*Multiply;
        this.TinW = TinH/Div;
        this.TinD = TinW;
        this.CircleDistance = (TinH-Scale*4)/6;
        this.CircleRadius = (Add*Scale)/3;
        this.note = new Notes(note);
        init();
    }
    public void init(){
        brushS = new Paint(Paint.ANTI_ALIAS_FLAG);
        brushF = new Paint(Paint.ANTI_ALIAS_FLAG);
        brushS.setStrokeWidth(10f);
        brushS.setStrokeCap(Paint.Cap.BUTT);
        brushF.setColor(Color.BLACK);
        brushS.setColor(Color.BLACK);
        brushF.setStyle(Paint.Style.FILL);
        brushS.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(counter == 12){
            row -= TinH + TinW;
            counter = 0;
        }
        Rect cr = new Rect(InitialPosX + (counter*TinD) ,InitialPosY + TinH - row, InitialPosX + TinW + (counter*TinD) , InitialPosY - row);
        canvas.drawRect(cr, brushS);
        drawNotes(brushF,brushS,canvas,cr);
        canvas.save();
        this.counter+=1;
        super.onDraw(canvas);

    }
    public void drawNotes(Paint fillBrush, Paint strokeBrush,Canvas canvas,Rect cr){
        int cnum = 0;
        for(Boolean bool: note.Fill){
            if(bool){
                canvas.drawCircle(cr.centerX(), cr.top - CircleRadius - 30 - CircleDistance*cnum, CircleRadius, fillBrush);
            } else{
                canvas.drawCircle(cr.centerX(), cr.top - CircleRadius - 30 - CircleDistance*cnum, CircleRadius, strokeBrush);
            }
            cnum++;
        }
    }
}
