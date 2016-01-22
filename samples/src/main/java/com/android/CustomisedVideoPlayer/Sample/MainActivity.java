package com.android.CustomisedVideoPlayer.Sample;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import com.android.CustomisedVideoPlayer.*;
import com.android.CustomisedVideoPlayer.player.BasePlayer;

import java.io.File;

/**
 * Created by aasha.medhi on 1/21/16.
 */
public class MainActivity extends Activity{
    LinearLayout mainLayout;
    BasePlayer basePlayer;
    enum PLAYER_TYPE {
        HEXAGONAL(0),
        CIRCULAR(1),
        SQUARE(2),
        OVAL(3),
        TRIANGULAR(4),
        ROUNDED_RECT(5),
        CUSTOM(6);
        private int value;
        private PLAYER_TYPE(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mainLayout = (LinearLayout)findViewById(R.id.main_layout);
        basePlayer = preparePlayer(PLAYER_TYPE.HEXAGONAL);
        basePlayer.getVideoFrame().setPadding(50, 50, 50 , 50);
        mainLayout.addView(basePlayer.getVideoFrame());
        basePlayer.preparePlayer(true);

        basePlayer = preparePlayer(PLAYER_TYPE.CIRCULAR);
        basePlayer.getVideoFrame().setPadding(0, 50, 50 , 50);
        mainLayout.addView(basePlayer.getVideoFrame());
        basePlayer.preparePlayer(true);

        basePlayer = preparePlayer(PLAYER_TYPE.ROUNDED_RECT);
        basePlayer.getVideoFrame().setPadding(0, 50, 50 , 50);
        mainLayout.addView(basePlayer.getVideoFrame());
        basePlayer.preparePlayer(true);

        basePlayer = preparePlayer(PLAYER_TYPE.TRIANGULAR);
        basePlayer.getVideoFrame().setPadding(0, 50, 50 , 50);
        mainLayout.addView(basePlayer.getVideoFrame());
        basePlayer.preparePlayer(true);

        basePlayer = preparePlayer(PLAYER_TYPE.OVAL);
        basePlayer.getVideoFrame().setPadding(0, 50, 50 , 50);
        mainLayout.addView(basePlayer.getVideoFrame());
        basePlayer.preparePlayer(true);

        basePlayer = preparePlayer(PLAYER_TYPE.SQUARE);
        basePlayer.getVideoFrame().setPadding(0, 50, 50 , 50);
        mainLayout.addView(basePlayer.getVideoFrame());
        basePlayer.preparePlayer(true);
    }

    private BasePlayer preparePlayer(PLAYER_TYPE player_type){
        int value = player_type.getValue();
        BasePlayer player = null;
        switch (value){
            case 0:
                player = new HexagonalPlayer(this);
                break;
            case 1:
                player = new CircularPlayer(this);
                break;
            case 2:
                player = new SquarePlayer(this);
                break;
            case 3:
                player = new OvalPlayer(this);
                break;
            case 4:
                player = new TriangularPlayer(this);
                break;
            case 5:
                player = new RoundedRectPlayer(this);
                break;
        }

        player.setContentUri(Uri.parse("file:///android_asset/video.mp4"));
        return player;
    }
}
