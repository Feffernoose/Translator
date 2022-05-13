package com.example.translator;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class SecondActivity extends YouTubeBaseActivity {

    String api_key = "AIzaSyCiosN_VGPX-gMjx4Hc4cnqDtGNqBDf0Hw";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

      
       // get reference to the view of VideoPlayer
        YouTubePlayerView ytPlayer = findViewById(R.id.ytPlayer);

        ytPlayer.initialize(
                api_key,
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess (
                            YouTubePlayer.Provider provider, YouTubePlayer youtubePlayer, boolean b)
                    {
                        youtubePlayer.loadVideo("dQw4w9WgXcQ");
                        youtubePlayer.play();
                    }
                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult YouTubeInitializationResult) {
                        Toast.makeText(getApplicationContext(), "Video Player Failed!", Toast.LENGTH_LONG).show();
                    }
                });


    }
}
