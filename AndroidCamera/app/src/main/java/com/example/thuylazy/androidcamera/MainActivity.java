package com.example.thuylazy.androidcamera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    VideoView videoView;
    Button btnImage, btnVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //checkPermission();
        init();
    }

//    void checkPermission(){
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
//            if(!Settings.System.canWrite(getApplicationContext())){
//                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS, Uri.parse("packet: " + getPackageName()));
//                startActivityForResult(intent,200);
//            }
//        }
//    }

    void init(){
        imageView = (ImageView) findViewById(R.id.image);
        videoView = (VideoView)findViewById(R.id.video);
        btnImage= (Button) findViewById(R.id.btnImage);
        btnVideo = (Button) findViewById(R.id.btnVideo);

        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });

        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

                //thu muc luu tru ngoai
                File dir = Environment.getExternalStorageDirectory();
                if(!dir.exists()){
                    dir.mkdir();
                }
                // file:///storage/emulated/0/myvideo.mp4
                String savePath = dir.getAbsolutePath() + "/myvideo.mp4";
                File videoFile = new File(savePath);
                Uri videoUri = Uri.fromFile(videoFile);

                //vi tri luu file video khi quay
                intent.putExtra(MediaStore.EXTRA_OUTPUT, videoUri);
                startActivityForResult(intent,300);
            }
        });

    }

    protected void  onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100){
            if (resultCode == RESULT_OK){
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(bitmap);
            }else if(resultCode == RESULT_CANCELED){
                Toast.makeText(this,"Action canceled", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, "Action Failed", Toast.LENGTH_LONG).show();
            }
        }else  if (requestCode == 300){
            if (resultCode == RESULT_OK){
                Uri videoUri = data.getData();
                Log.i("Min", "video save to : " + videoUri);
                videoView.setVideoURI(videoUri);
                videoView.start();
            }else if(resultCode == RESULT_CANCELED){
                Toast.makeText(this,"Action canceled", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this,"Action failed", Toast.LENGTH_LONG).show();
            }
        }
    }
}
