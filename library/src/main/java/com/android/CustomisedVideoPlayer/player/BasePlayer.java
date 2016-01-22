package com.android.CustomisedVideoPlayer.player;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import com.android.CustomisedVideoPlayer.R;
import com.google.android.exoplayer.AspectRatioFrameLayout;
import com.google.android.exoplayer.util.Util;
import com.squareup.picasso.Picasso;

public class BasePlayer implements TextureView.SurfaceTextureListener{

    private static final String TAG = BasePlayer.class.getName();

    // Context of activity
    private Context mContext = null;

    // Layout inflater
    private LayoutInflater mInflater = null;

    // Exo player
    private DemoPlayer mExoPlayer = null;
    protected AspectRatioFrameLayout mVideoFrame = null;
    protected TextureView mTextureView = null;

    // Listener for clients
    private DemoPlayer.Listener mPlayerStateListener = null;

    // Player STATE flags
    private boolean mPlayerNeedsPrepare;
    private long mPlayerPosition = 3000;
    private View mTranslucentView = null;
    private ImageView mYTPreviewPlayer = null;
    // Content uri associated with this player
    private Uri mContentUri = null;


    public BasePlayer(Context context) {
        mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mVideoFrame = (AspectRatioFrameLayout) mInflater.inflate(R.layout.player_view, null);
        mTranslucentView = (View) mVideoFrame.findViewById(R.id.translucent_view);
        mTextureView = (TextureView)mVideoFrame.findViewById(R.id.texture_view);
        mTextureView.setSurfaceTextureListener(this);
        mYTPreviewPlayer = (ImageView) mVideoFrame.findViewById(R.id.yt_preview_player);
    }

    protected void preparePlayer(boolean playWhenReady) {
        if (mExoPlayer == null) {
            mExoPlayer = new DemoPlayer(getRendererBuilder());
            if (null != mPlayerStateListener) {
                mExoPlayer.addListener(mPlayerStateListener);
            }
            mPlayerNeedsPrepare = true;
        }
        mExoPlayer.seekTo(mPlayerPosition);
        if (mPlayerNeedsPrepare) {
            mExoPlayer.prepare();
            mPlayerNeedsPrepare = false;
        }
        Log.e("AASHA", "Texture view " + mTextureView.getClass());
        if(mTextureView.getSurfaceTexture() != null)
            mExoPlayer.setSurface(new Surface(mTextureView.getSurfaceTexture()));
        mExoPlayer.setPlayWhenReady(playWhenReady);
    }

    public void releasePlayer() {
        if (mExoPlayer != null) {
            mPlayerPosition = mExoPlayer.getCurrentPosition();
            mExoPlayer.release();
            mExoPlayer = null;
        }
    }

    public long getPlayerPosition() {
        if(mExoPlayer != null)
            return mExoPlayer.getCurrentPosition();
        return mPlayerPosition;
    }

    public void restartPlayer() {
        if (mExoPlayer == null) {
            return;
        }
        releasePlayer();
        mPlayerPosition = 0;
        preparePlayer(true);
    }

    protected DemoPlayer.RendererBuilder getRendererBuilder() {
        String userAgent = Util.getUserAgent(mContext, "ExoPlayerDemo");
        return new ExtractorRendererBuilder(mContext, userAgent, mContentUri);
    }

    public AspectRatioFrameLayout getVideoFrame() {
        return mVideoFrame;
    }

    public void setPlayerPosition(int seekPosition) {
        mPlayerPosition = seekPosition;
    }

    public void setContentUri(Uri uri) {
        mContentUri = uri;
    }

    public void setPlayerListener(DemoPlayer.Listener mDemoListener) {
        mPlayerStateListener = mDemoListener;
    }

    public void setPlayerNeedsPrepare(boolean b) {
        mPlayerNeedsPrepare = b;
    }

    public void setVideoOverlayClickListener(View.OnClickListener cl){
        mTranslucentView.setOnClickListener(cl);
    }

    public void setVideoOverlayTouchListener(View.OnTouchListener cl){
        mTranslucentView.setOnTouchListener(cl);
    }
    public void setYtPreviewPlayer(Uri uri){
        if(uri != null) {
            Picasso.with(mContext).load(uri).fit().into(mYTPreviewPlayer);
        }else{
            mYTPreviewPlayer.setVisibility(View.GONE);
        }
    }

    public void setYtPreviewVisibility(boolean isVisible){
        mYTPreviewPlayer.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        if(mExoPlayer != null)
            mExoPlayer.setSurface(new Surface(mTextureView.getSurfaceTexture()));
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }
}
