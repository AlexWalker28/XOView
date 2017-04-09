package com.example.alexwalker.customviewxo;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    XOView view;
    int coordinateX;
    int coordinateY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = (XOView) findViewById(R.id.xoField);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float touchX = event.getX();
                float touchY = event.getY();

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (touchX < v.getWidth() / 3 && touchY < view.getHeight() / 3) {
                        setCoordinates(0, 0);
                        Log.v("Coordinates", "Coordinates are: " + "x = " + getCoordinateX() + ", " + "y = " + getCoordinateY());
                    } else if (touchX < v.getWidth() * 0.66 && touchX > v.getWidth() / 3 && touchY < v.getHeight() / 3) {
                        setCoordinates(1, 0);
                        Log.v("Coordinates", "Coordinates are: " + "x = " + getCoordinateX() + ", " + "y = " + getCoordinateY());
                    } else if (touchX > v.getWidth() * 0.66 && touchY < v.getHeight() / 3) {
                        setCoordinates(2, 0);
                        Log.v("Coordinates", "Coordinates are: " + "x = " + getCoordinateX() + ", " + "y = " + getCoordinateY());
                    } else if (touchX < v.getWidth() / 3 && touchY > v.getHeight() / 3 && touchY < v.getHeight() * 0.66) {
                        setCoordinates(0, 1);
                        Log.v("Coordinates", "Coordinates are: " + "x = " + getCoordinateX() + ", " + "y = " + getCoordinateY());
                    } else if (touchX < v.getWidth() * 0.66 && touchX > v.getWidth() / 3 && touchY > v.getHeight() / 3 && touchY < v.getHeight() * 0.66) {
                        setCoordinates(1, 1);
                        Log.v("Coordinates", "Coordinates are: " + "x = " + getCoordinateX() + ", " + "y = " + getCoordinateY());
                    } else if (touchX > v.getWidth() * 0.66 && touchY > v.getHeight() / 3 && touchY < v.getHeight() * 0.66) {
                        setCoordinates(2, 1);
                        Log.v("Coordinates", "Coordinates are: " + "x = " + getCoordinateX() + ", " + "y = " + getCoordinateY());
                    } else if (touchX < v.getWidth() / 3 && touchY > v.getHeight() * 0.66) {
                        setCoordinates(0, 2);
                        Log.v("Coordinates", "Coordinates are: " + "x = " + getCoordinateX() + ", " + "y = " + getCoordinateY());
                    } else if (touchX > v.getWidth() / 3 && touchX < v.getWidth() * 0.66 && touchY > v.getHeight() * 0.66) {
                        setCoordinates(1, 2);
                        Log.v("Coordinates", "Coordinates are: " + "x = " + getCoordinateX() + ", " + "y = " + getCoordinateY());
                    } else if (touchX > v.getWidth() * 0.66 && touchY > v.getHeight() * 0.66) {
                        setCoordinates(2, 2);
                        Log.v("Coordinates", "Coordinates are: " + "x = " + getCoordinateX() + ", " + "y = " + getCoordinateY());
                    }
                }
                return true;
            }
        });

    }

    private void setCoordinates(int x, int y){
        this.coordinateX = x;
        this.coordinateY = y;
    }
    public int getCoordinateX(){
        return this.coordinateX;
    }
    public int getCoordinateY(){
        return this.coordinateY;
    }



}
