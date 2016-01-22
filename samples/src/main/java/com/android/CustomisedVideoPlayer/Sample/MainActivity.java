package com.android.CustomisedVideoPlayer.Sample;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.android.CustomisedVideoPlayer.CircularPlayer;
import com.android.CustomisedVideoPlayer.HexagonalPlayer;
import com.android.CustomisedVideoPlayer.player.BasePlayer;

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
        CUSTOM(3);
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
//        basePlayer = preparePlayer(PLAYER_TYPE.HEXAGONAL);
//        mainLayout.addView(basePlayer.getVideoFrame());
//        basePlayer.preparePlayer(true);
        HexagonalPlayer player = new HexagonalPlayer(this);
        player.setContentUri(Uri.parse("http://d3dxyccixtcsc2.cloudfront.net/vertical_videos/1113.mp4"));
        mainLayout.addView(player.getVideoFrame());
        player.preparePlayer(true);
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
                break;
            case 3:
                break;
        }
        player.setContentUri(Uri.parse("http://d3dxyccixtcsc2.cloudfront.net/vertical_videos/1113.mp4"));
        return player;
    }
}
