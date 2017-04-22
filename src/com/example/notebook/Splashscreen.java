package com.example.notebook;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

public class Splashscreen extends Activity {

	VideoView videoView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		  
		setContentView(R.layout.activity_splashscreen);
		 videoView = (VideoView)findViewById(R.id.videoView1);        
		 videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.splashscreenfinal);
		  
		 
		 videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
	            public void onCompletion(MediaPlayer mp) {
	                jump();
	            }
	        });
		 videoView.start(); 
	}
		 @Override
			public boolean onTouchEvent(MotionEvent event) {
			    jump();
			    return true;
			}
		 
		 private void jump() {
			    if (isFinishing())
			        return;
			    startActivity(new Intent(this, LoginActivity.class));
			    finish();
			}
}


