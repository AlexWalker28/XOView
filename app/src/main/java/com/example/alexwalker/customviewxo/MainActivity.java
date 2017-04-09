package com.example.alexwalker.customviewxo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    XOView view;
    int x;
    int y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        XOView xoView = (XOView)findViewById(R.id.xoField);

        xoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*x = view.getCoordinateX();
                y = view.getCoordinateY();*/
                Log.e("Coordinates", "Coordinates are:" + x + "," + y);
            }
        });

        xoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                /*x = view.getCoordinateX();
                y = view.getCoordinateY();*/
                Log.e("Coordinates", "Coordinates are:" + x + "," + y);
                return true;
            }
        });
    }
}
