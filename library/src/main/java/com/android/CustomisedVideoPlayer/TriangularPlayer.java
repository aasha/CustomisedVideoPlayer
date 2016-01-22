package com.android.CustomisedVideoPlayer;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.widget.ImageView;
import com.android.CustomisedVideoPlayer.player.BasePlayer;
import com.android.CustomisedVideoPlayer.view.TriangularSurfaceView;
import com.google.android.exoplayer.AspectRatioFrameLayout;

public class TriangularPlayer extends BasePlayer {
    private static final String TAG = TriangularPlayer.class.getName();

    public TriangularPlayer(Context context) {
        super(context);
        mVideoFrame = (AspectRatioFrameLayout) mInflater.inflate(R.layout.triangular_player_view, null);
        mTranslucentView = (View) mVideoFrame.findViewById(R.id.translucent_view);
        mSurfaceView = (TriangularSurfaceView) mVideoFrame.findViewById(R.id.texture_view);
        mYTPreviewPlayer = (ImageView) mVideoFrame.findViewById(R.id.yt_preview_player);
        mTranslucentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartPlayer();
            }
        });
    }

    public void setDimention(Point x, Point y, Point z) {
        preparePlayer(false, x, y, z);
    }

    public void preparePlayer(boolean playWhenReady, Point x, Point y, Point z) {
        ((TriangularSurfaceView) mSurfaceView).x = x;
        ((TriangularSurfaceView) mSurfaceView).y = y;
        ((TriangularSurfaceView) mSurfaceView).z = z;
        super.preparePlayer(playWhenReady);
    }

}
