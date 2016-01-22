package com.android.CustomisedVideoPlayer.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * Created by aasha.medhi on 11/18/15.
 */
public class HexagonalSurfaceView extends SurfaceView {

    private Path circularPath;
    public int radius = 50;
    public HexagonalSurfaceView(Context context) {
        super(context);
    }

    public HexagonalSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HexagonalSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        circularPath = calculatePath(this.getPivotX(), this.getPivotY());
        canvas.clipPath(circularPath);
        super.dispatchDraw(canvas);
    }

    private Path calculatePath(float centerX, float centerY) {
        float density = this.getResources().getDisplayMetrics().density;
        float radiusDp = radius*density;
        float triangleHeight = (float) (Math.sqrt(3) * radiusDp / 2);
        Path hexagonPath = new Path();
        hexagonPath.moveTo(centerX, centerY + radiusDp);
        hexagonPath.lineTo(centerX - triangleHeight, centerY + radiusDp/2);
        hexagonPath.lineTo(centerX - triangleHeight, centerY - radiusDp/2);
        hexagonPath.lineTo(centerX, centerY - radiusDp);
        hexagonPath.lineTo(centerX + triangleHeight, centerY - radiusDp/2);
        hexagonPath.lineTo(centerX + triangleHeight, centerY + radiusDp/2);
        hexagonPath.moveTo(centerX, centerY + radiusDp);
        return hexagonPath;
    }
}
