package com.android.CustomisedVideoPlayer.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * Created by aasha.medhi on 11/18/15.
 */
public class TriangularSurfaceView extends SurfaceView {

    private Path circularPath;

    public TriangularSurfaceView(Context context) {
        super(context);
    }

    public TriangularSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TriangularSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Point x = new Point(50, 0);// default
    public Point y = new Point(0, 100);// default
    public Point z = new Point(100, 100);// default

    @Override
    protected void dispatchDraw(Canvas canvas) {
        circularPath = new Path();
        float density = this.getResources().getDisplayMetrics().density;
        circularPath.moveTo(x.x * density, x.y * density);
        circularPath.lineTo(y.x * density, y.y * density);
        circularPath.lineTo(z.x * density, z.y * density);
        circularPath.lineTo(x.x * density, x.y * density);
        canvas.clipPath(circularPath);
        super.dispatchDraw(canvas);
    }

}
