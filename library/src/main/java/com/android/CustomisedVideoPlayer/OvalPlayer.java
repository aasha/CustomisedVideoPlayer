package com.android.CustomisedVideoPlayer;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.android.CustomisedVideoPlayer.player.BasePlayer;
import com.android.CustomisedVideoPlayer.view.OvalSurfaceView;
import com.google.android.exoplayer.AspectRatioFrameLayout;

public class OvalPlayer extends BasePlayer {
    private static final String TAG = OvalPlayer.class.getName();

    public OvalPlayer(Context context) {
        super(context);
        mVideoFrame = (AspectRatioFrameLayout) mInflater.inflate(R.layout.oval_player_view, null);
        mTranslucentView = (View) mVideoFrame.findViewById(R.id.translucent_view);
        mSurfaceView = (OvalSurfaceView) mVideoFrame.findViewById(R.id.texture_view);
        mYTPreviewPlayer = (ImageView) mVideoFrame.findViewById(R.id.yt_preview_player);
        mTranslucentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartPlayer();
            }
        });
    }

    public void setDimension(int width, int height) {
        preparePlayer(false, width, height);
    }

    public void preparePlayer(boolean playWhenReady, int width, int height) {
        if (width != 0 && height != 0) {
            ((OvalSurfaceView) mSurfaceView).width = width;
            ((OvalSurfaceView) mSurfaceView).height = height;
        }
        super.preparePlayer(playWhenReady);
    }

}
