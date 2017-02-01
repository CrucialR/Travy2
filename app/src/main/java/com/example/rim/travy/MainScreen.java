package com.example.rim.travy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;


public class MainScreen extends YouTubeBaseActivity {

    Button start;
    private YouTubePlayerView youTubePlayerView; // 유투브
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    private YouTubeThumbnailView thumbnailView;
    private YouTubeThumbnailLoader thumbnailLoader;
    public  String DeveloperKey= "AIzaSyAsbqUJeKi1hgVykPamYicsHXn890zQOk0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        youTubePlayerView=(YouTubePlayerView)findViewById(R.id.youtube_view);
        startActivity(new Intent(this, popup.class));


//        thumbnailView = new YouTubeThumbnailView(this);
//        thumbnailView.initialize(DeveloperKey, (YouTubeThumbnailView.OnInitializedListener) this);

       onInitializedListener=new YouTubePlayer.OnInitializedListener(){
            @Override
           public void onInitializationSuccess(YouTubePlayer.Provider provider,YouTubePlayer youTubePlayer,boolean start){
                youTubePlayer.loadVideo("a4NT5iBFuZs");
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult){
            }
        };
        start=(Button)findViewById(R.id.button);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            youTubePlayerView.initialize("AIzaSyAsbqUJeKi1hgVykPamYicsHXn890zQOk0",onInitializedListener);

            }
        });

    }

}