package com.android.CustomisedVideoPlayer;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.android.CustomisedVideoPlayer.player.BasePlayer;
import com.android.CustomisedVideoPlayer.view.HexagonalTextureView;

public class HexagonalPlayer extends BasePlayer {
    private static final String TAG = HexagonalPlayer.class.getName();
    // Context of activity
    private Context mContext = null;
    HexagonalTextureView mTextureView;
    public HexagonalPlayer(Context context) {
        super(context);
        Log.e("AASHA", "Good");
        mContext = context;
        mTextureView = (HexagonalTextureView) mVideoFrame.findViewById(R.id.texture_view);
    }

    public void preparePlayer(boolean playWhenReady, int radius) {
        Log.e("AASHA", "Prepare ");
        if (radius == 0) {
            DisplayMetrics dm = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) mContext
                    .getSystemService(Context.WINDOW_SERVICE);
            windowManager.getDefaultDisplay().getMetrics(dm);
            radius = (int) (56 * dm.density) / 2;
        }
        //mTextureView.radius = radius;
        super.preparePlayer(playWhenReady);
    }
    public void preparePlayer(boolean playWhenReady) {
        Log.e("AASHA", "Prepare ");
            DisplayMetrics dm = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) mContext
                    .getSystemService(Context.WINDOW_SERVICE);
            windowManager.getDefaultDisplay().getMetrics(dm);
            int radius = (int) (56 * dm.density) / 2;
        //mTextureView.radius = radius;
        super.preparePlayer(playWhenReady);
    }
}
