package com.android.CustomisedVideoPlayer.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;
import android.view.TextureView;

/**
 * Created by aasha.medhi on 11/18/15.
 */
public class HexagonalTextureView extends SurfaceView {

    private Path hexagonalPath;
    public int radius = 130;
    public HexagonalTextureView(Context context) {
        super(context);
        init();
    }

    public HexagonalTextureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HexagonalTextureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Log.e("AASHA", "init");
        //hexagonalPath = calculatePath(130, 155, 150);
        hexagonalPath = calculatePath(radius, this.getPivotX(), this.getPivotY());
        //hexagonalPath.addCircle(300, 330, 250, Path.Direction.CW);
        //hexagonalPath.addCircle(300, 300, 200, Path.Direction.CW);

    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        hexagonalPath = calculatePath(radius, this.getPivotX(), this.getPivotY());
        Log.e("AASHA", "Clipping");
        canvas.clipPath(hexagonalPath);
        super.dispatchDraw(canvas);
    }

    private Path calculatePath(int radius, float centerX, float centerY) {
        float triangleHeight = (float) (Math.sqrt(3) * radius / 2);
        Path hexagonPath = new Path();
        hexagonPath.moveTo(centerX, centerY + radius);
        hexagonPath.lineTo(centerX - triangleHeight, centerY + radius/2);
        hexagonPath.lineTo(centerX - triangleHeight, centerY - radius/2);
        hexagonPath.lineTo(centerX, centerY - radius);
        hexagonPath.lineTo(centerX + triangleHeight, centerY - radius/2);
        hexagonPath.lineTo(centerX + triangleHeight, centerY + radius/2);
        hexagonPath.moveTo(centerX, centerY + radius);
        return hexagonPath;
    }
}
