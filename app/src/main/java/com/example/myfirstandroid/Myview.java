package com.example.myfirstandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

public class Myview extends View {
    public Myview(Context context){
        super(context);
    }
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        RectF rect = new RectF(0,0, 200, 200);
        canvas.drawRoundRect(rect, 10, 10, paint);
        paint.setColor(Color.RED);
        Path path = new Path();
        path.moveTo(rect.width(), rect.height() / 2);
        paint.setColor(Color.YELLOW);
        canvas.drawPath(path, paint);
        path.lineTo((float) (rect.width() * 0.75), (float) (rect.width() / 2 - rect.width() * Math.sqrt(3) / 4));
        paint.setColor(Color.BLUE);
        canvas.drawPath(path, paint);
        path.lineTo((float) (rect.width() * 0.25), (float) (rect.width() / 2 - rect.width()  * Math.sqrt(3) / 4));
        path.lineTo(0, rect.width() / 2);
        paint.setColor(Color.BLACK);
        canvas.drawPath(path, paint);
        path.lineTo((float) (rect.width() * 0.25), (float) (rect.width() / 2 + rect.width()  * Math.sqrt(3) / 4));
        path.lineTo((float) (rect.width() * 0.75), (float) (rect.width() / 2 + rect.width()  * Math.sqrt(3) / 4));
        path.lineTo(rect.width(), rect.height() / 2);
        canvas.drawPath(path, paint);
        canvas.drawPath(path, paint);
    }
}
