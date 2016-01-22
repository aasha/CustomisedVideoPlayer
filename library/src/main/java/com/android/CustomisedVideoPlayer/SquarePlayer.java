package com.android.CustomisedVideoPlayer;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.android.CustomisedVideoPlayer.player.BasePlayer;
import com.android.CustomisedVideoPlayer.view.CircularSurfaceView;
import com.google.android.exoplayer.AspectRatioFrameLayout;

public class SquarePlayer extends BasePlayer {
    private static final String TAG = SquarePlayer.class.getName();
    public SquarePlayer(Context context) {
        super(context);
        //Just set width and height to the required square
    }


}
