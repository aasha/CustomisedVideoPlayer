# CustomisedVideoPlayer
Play video in any shape. Be it a circular video or a hexagonal.

#Usage
* Create the player you want to use.
* Add the player to your layout.
* Call prepare player and you are done

#Sample Code
```
LinearLayout mainLayout = (LinearLayout)findViewById(R.id.main_layout);
HexagonalPlayer player = new HexagonalPlayer(MainActivity.this);
player.setContentUri(Uri.parse("file:///android_asset/video.mp4"));
mainLayout.addView(player.getVideoFrame());
player.prepare(true);

CircularPlayer player = new CircularPlayer(MainActivity.this);
player.setContentUri(Uri.parse("file:///android_asset/video.mp4"));
mainLayout.addView(player.getVideoFrame());
player.prepare(true);

```

#Screenshots
![alt tag](https://raw.githubusercontent.com/aasha/CustomisedVideoPlayer/master/samples/src/main/assets/screenshot.png)

# Library used
Exoplayer <https://github.com/google/ExoPlayer>

#Developer Name
Aasha <aasha.medhi2004@gmail.com>


