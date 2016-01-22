package com.android.CustomisedVideoPlayer.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;

/**
 * Created by aasha.medhi on 11/18/15.
 */
public class CircularSurfaceView extends SurfaceView {

    private Path circularPath;

    public CircularSurfaceView(Context context) {
        super(context);
    }

    public CircularSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircularSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int radius = 50;// default

    @Override
    protected void dispatchDraw(Canvas canvas) {
        circularPath = new Path();
        float density = this.getResources().getDisplayMetrics().density;
        circularPath.addCircle(this.getPivotX(), this.getPivotY(), radius * density, Path.Direction.CW);
        canvas.clipPath(circularPath);
        super.dispatchDraw(canvas);
    }

}
