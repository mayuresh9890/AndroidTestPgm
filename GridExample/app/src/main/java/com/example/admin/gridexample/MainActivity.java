package com.example.admin.gridexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String list[] = {"Dog", "Cat", "Mouse", "Elephant", "Rat", "Parrot"};;

    CanvasTest CTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //CTest = new CanvasTest(this);
        //setContentView(CTest);

        final GridView gridView = (GridView) findViewById(R.id.TableGridView);
        gridView.setAdapter(new CustomImageAdapter(this, list));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //text.setText((String) (gridView.getItemAtPosition(position)));
                Log.i("ITEM_CLICKED", "" + (String) (gridView.getItemAtPosition(position)));
            }
        });
    }

    //Not use
    private class CanvasTest extends View {
        public CanvasTest(Context context) {
            super(context);
        }

        @Override protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            // custom drawing code here
            Paint paint = new Paint();
            //Paint paintText = new Paint();
            paint.setStyle(Paint.Style.FILL);

            // make the entire canvas white
            paint.setColor(Color.WHITE);
            canvas.drawPaint(paint);

            // draw blue circle with anti aliasing turned off
            int x = 60;
            int y = 90;
            int r = 55;
            int value = 10;
            paint.setAntiAlias(false);
            paint.setColor(Color.BLUE);
            canvas.drawCircle(x, y, r, paint);
            paint.setColor(Color.BLACK);
            paint.setTextSize(20);
            canvas.drawText("Mayu", 35, 90, paint);
            //x = x + x + x;
            for(int i = 1; i <= value - 1; i++){
                x += 120;
                paint.setAntiAlias(false);
                paint.setColor(Color.RED);
                canvas.drawCircle(x, y, r, paint);
                if(i == 6){
                    System.getProperty("line.separator");
                }
            }
            canvas.restore();
        }
        }
    }
