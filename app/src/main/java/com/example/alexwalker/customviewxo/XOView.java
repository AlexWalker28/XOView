package com.example.alexwalker.customviewxo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by alexwalker on 09.04.17.
 */

public class XOView extends View {

    private Canvas canvas;
    private Paint paintLine = new Paint();
    private Path path = new Path();

    public XOView(Context context) {
        super(context);
        init(null, 0);
    }

    public XOView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public XOView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init (AttributeSet attrs, int defStyle){
        paintLine.setColor(Color.BLACK);
        paintLine.setAntiAlias(true);
        paintLine.setStyle(Paint.Style.STROKE);
        paintLine.setStrokeWidth(16 * getResources().getDisplayMetrics().density);

    }

    @Override
    public void onDraw(Canvas canvas){
        this.canvas = canvas;
        super.onDraw(canvas);

        drawField();
        if(!path.isEmpty()){
            canvas.drawPath(path, paintLine);
        }




    }

    public void drawField(){
        canvas.drawLine(getWidth() / 3, 0, getWidth() / 3, getHeight(), paintLine); // первая вертикальная линия
        canvas.drawLine(getWidth() * 0.66f, 0, getWidth() * 0.66f, getHeight(), paintLine); // вторая вертикальная линия
        canvas.drawLine(0, getHeight() / 3, getWidth(), getHeight() / 3, paintLine); // первая горизонтальная линия
        canvas.drawLine(0, getHeight() * 0.66f, getWidth(), getHeight() * 0.66f, paintLine); //вторая горизонтальная линия

    }




    private void drawFigure(char figure) {
        switch (figure){
            case 'x':
                // draw x
                path.moveTo(0, 0);
                path.lineTo(getWidth()/3, getHeight()/3);
                path.moveTo(getWidth()/3, 0);
                path.lineTo(0, getHeight()/3);
                break;
            case 'o':
                //draw o
                path.addCircle(getWidth()/6, getHeight()/6, getHeight()/12, Path.Direction.CW);
                break;
        }

    }

}
