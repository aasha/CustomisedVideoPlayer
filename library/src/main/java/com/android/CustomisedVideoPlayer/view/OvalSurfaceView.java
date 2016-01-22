package com.android.CustomisedVideoPlayer.view;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;

/**
 * Created by aasha.medhi on 11/18/15.
 */
public class OvalSurfaceView extends SurfaceView {

    private Path circularPath;

    public OvalSurfaceView(Context context) {
        super(context);
    }

    public OvalSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OvalSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int width = 250;// default
    public int height = 350;

    @Override
    protected void dispatchDraw(Canvas canvas) {
        circularPath = new Path();
        float density = this.getResources().getDisplayMetrics().density;
        circularPath.addOval(0, 0 , width, height ,Path.Direction.CW);
        canvas.clipPath(circularPath);
        super.dispatchDraw(canvas);
    }

}
