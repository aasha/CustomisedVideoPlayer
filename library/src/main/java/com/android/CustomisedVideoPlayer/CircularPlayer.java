package com.android.CustomisedVideoPlayer;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.*;
import android.widget.ImageView;
import com.android.CustomisedVideoPlayer.player.BasePlayer;
import com.android.CustomisedVideoPlayer.view.CircularSurfaceView;
import com.google.android.exoplayer.AspectRatioFrameLayout;

public class CircularPlayer extends BasePlayer {
    private static final String TAG = CircularPlayer.class.getName();
    public CircularPlayer(Context context) {
        super(context);
        mVideoFrame = (AspectRatioFrameLayout) mInflater.inflate(R.layout.circular_player_view, null);
        mTranslucentView = (View) mVideoFrame.findViewById(R.id.translucent_view);
        mSurfaceView = (CircularSurfaceView) mVideoFrame.findViewById(R.id.texture_view);
        mYTPreviewPlayer = (ImageView) mVideoFrame.findViewById(R.id.yt_preview_player);
        mTranslucentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartPlayer();
            }
        });
    }

    public void setRadius(int radius){
        preparePlayer(false, radius);
    }
    public void preparePlayer(boolean playWhenReady, int radius) {
        if(radius != 0) {
            ((CircularSurfaceView)mSurfaceView).radius = radius;
        }
        super.preparePlayer(playWhenReady);
    }
}
