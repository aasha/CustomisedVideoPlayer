package com.android.CustomisedVideoPlayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.*;
import android.widget.ImageView;
import com.android.CustomisedVideoPlayer.player.BasePlayer;
import com.android.CustomisedVideoPlayer.player.DemoPlayer;
import com.android.CustomisedVideoPlayer.player.ExtractorRendererBuilder;
import com.android.CustomisedVideoPlayer.view.CirclularTextureView;
import com.android.CustomisedVideoPlayer.view.HexagonalTextureView;
import com.google.android.exoplayer.AspectRatioFrameLayout;
import com.google.android.exoplayer.util.Util;

public class CircularPlayer extends BasePlayer{
    private static final String TAG = CircularPlayer.class.getName();
    // Context of activity
    private Context mContext = null;
    public CircularPlayer(Context context) {
        super(context);
        mTextureView = (CirclularTextureView) mVideoFrame.findViewById(R.id.texture_view);
    }

    public void preparePlayer(boolean playWhenReady, int radius) {
        if(radius == 0) {
            DisplayMetrics dm = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) mContext
                    .getSystemService(Context.WINDOW_SERVICE);
            windowManager.getDefaultDisplay().getMetrics(dm);
            radius = (int)(56 * dm.density)/2;
        }
       // mTextureView.radius = radius;
        super.preparePlayer(playWhenReady);
    }
}
