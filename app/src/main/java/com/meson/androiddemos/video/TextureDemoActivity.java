package com.meson.androiddemos.video;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.meson.androiddemos.R;

public class TextureDemoActivity extends AppCompatActivity implements View.OnClickListener {

    // Video file url
    private static final String FILE_URL = "http://www.w3schools.com/html/mov_bbb.mp4";
    private static int SCALE_DURATION = 500;
    private FastVideoView mTextureVideoView;
    private float currentScale = 1.0f;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texture_demo);
        initView();
    }

    private void initView() {
        mTextureVideoView = findViewById(R.id.cropTextureView);
        //mTextureVideoView.setVideoURI(Uri.parse(FILE_URL));

        findViewById(R.id.btn_shrink).setOnClickListener(this);
        findViewById(R.id.btn_expand).setOnClickListener(this);
        findViewById(R.id.btn_play).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_play:
                mTextureVideoView.setVideoURI(Uri.parse("android.resource://"+ getPackageName() +"/raw/video"));
                mTextureVideoView.start();
                break;
            case R.id.btn_shrink:
                shrink();
                break;
            case R.id.btn_expand:
                expand();
                break;
        }
    }

    private void shrink() {
        currentScale = 2.0f;
        ObjectAnimator animScale1 = ObjectAnimator.ofFloat(mTextureVideoView, "scaleX", currentScale, 2.0f);
        ObjectAnimator animScale2 = ObjectAnimator.ofFloat(mTextureVideoView, "scaleY", currentScale, 2.0f);
        AnimatorSet animSet = new AnimatorSet();
        animScale1.setDuration(SCALE_DURATION);
        animScale2.setDuration(SCALE_DURATION);
        animSet.play(animScale1);
        animSet.play(animScale2);
        animSet.start();
    }

    private void expand() {
        currentScale = 0.2f;
        ObjectAnimator animScale1 = ObjectAnimator.ofFloat(mTextureVideoView, "scaleX", currentScale, 0.2f);
        ObjectAnimator animScale2 = ObjectAnimator.ofFloat(mTextureVideoView, "scaleY", currentScale, 0.2f);
        AnimatorSet animSet = new AnimatorSet();
        animScale1.setDuration(SCALE_DURATION);
        animScale2.setDuration(SCALE_DURATION);
        animSet.play(animScale1);
        animSet.play(animScale2);
        animSet.start();
    }
}
