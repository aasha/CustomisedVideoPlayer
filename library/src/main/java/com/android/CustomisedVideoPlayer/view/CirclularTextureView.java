package com.android.CustomisedVideoPlayer.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.TextureView;

/**
 * Created by aasha.medhi on 11/18/15.
 */
public class CirclularTextureView extends TextureView {

    private Path circularPath;
    public CirclularTextureView(Context context) {
        super(context);
    }

    public CirclularTextureView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CirclularTextureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int mRadius = 30;// default

    @Override
    protected void dispatchDraw(Canvas canvas) {
        circularPath = new Path();
        float density = this.getResources().getDisplayMetrics().density;
        circularPath.addCircle(this.getPivotX(), this.getPivotY(), mRadius*density + 1, Path.Direction.CW);
        canvas.clipPath(circularPath);
    }

}
