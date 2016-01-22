package com.android.CustomisedVideoPlayer;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.android.CustomisedVideoPlayer.player.BasePlayer;
import com.android.CustomisedVideoPlayer.view.CircularSurfaceView;
import com.android.CustomisedVideoPlayer.view.HexagonalSurfaceView;
import com.google.android.exoplayer.AspectRatioFrameLayout;

public class HexagonalPlayer extends BasePlayer {
    private static final String TAG = HexagonalPlayer.class.getName();
    public HexagonalPlayer(Context context) {
        super(context);
        mVideoFrame = (AspectRatioFrameLayout) mInflater.inflate(R.layout.hexagonal_player_view, null);
        mTranslucentView = (View) mVideoFrame.findViewById(R.id.translucent_view);
        mSurfaceView = (HexagonalSurfaceView) mVideoFrame.findViewById(R.id.texture_view);
        mYTPreviewPlayer = (ImageView) mVideoFrame.findViewById(R.id.yt_preview_player);
    }

    public void setRadius(int radius){
        preparePlayer(false, radius);
    }

    public void preparePlayer(boolean playWhenReady, int radius) {
        if(radius != 0) {
            ((HexagonalSurfaceView)mSurfaceView).radius = radius;
        }
        super.preparePlayer(playWhenReady);
    }
}
