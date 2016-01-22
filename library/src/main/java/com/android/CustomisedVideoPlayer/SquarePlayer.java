package com.android.CustomisedVideoPlayer;

import android.content.Context;
import com.android.CustomisedVideoPlayer.player.BasePlayer;

public class SquarePlayer extends BasePlayer {
    private static final String TAG = SquarePlayer.class.getName();

    public SquarePlayer(Context context) {
        super(context);
        //Just set width and height to the required square
    }


}
