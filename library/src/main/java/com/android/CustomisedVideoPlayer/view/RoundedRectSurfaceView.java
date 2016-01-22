package com.android.CustomisedVideoPlayer.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * Created by aasha.medhi on 11/18/15.
 */
public class RoundedRectSurfaceView extends SurfaceView {

    private Path rectPath;

    public RoundedRectSurfaceView(Context context) {
        super(context);
    }

    public RoundedRectSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundedRectSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int width = 100;// default
    public int height = 100;// default
    @Override
    protected void dispatchDraw(Canvas canvas) {
        rectPath = new Path();
        float density = this.getResources().getDisplayMetrics().density;
        rectPath.addRoundRect(0, 0, width * density, height * density, 50, 50, Path.Direction.CW);
        canvas.clipPath(rectPath);
        super.dispatchDraw(canvas);
    }

}
