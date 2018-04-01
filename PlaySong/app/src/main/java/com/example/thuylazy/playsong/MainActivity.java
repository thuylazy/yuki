//package com.example.thuylazy.playsong;
//
//import android.media.MediaPlayer;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ListView;
//import android.widget.SeekBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//
//    MediaPlayer mp;
//    MediaPlayer playSound;
//    Button btnPlay, btnStop;
//    SeekBar seekBar;
//    TextView textView;
//    ListView listView;
//    List<String> list;
//    ArrayAdapter<String> arrayAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        btnPlay = (Button) findViewById(R.id.btnPlay);
//        btnStop = (Button) findViewById(R.id.btnStop);
//
//        listView = (ListView) findViewById(R.id.listView) ;
//
//        list = new ArrayList<>();
//        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list );
//        listView.setAdapter(arrayAdapter);
//
//        mp = new MediaPlayer();
//        playSound = MediaPlayer.create(this, R.raw.min123);
//        btnPlay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (playSound != null)
//                playSound.start();
//            }
//        });
//        btnStop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (playSound != null)
//                playSound.stop();
//            }
//        });
//
//        seekBar = (SeekBar) findViewById(R.id.seekBar);
////        textView = (TextView) findViewById(R.id.tv);
//
//        seekBar.setMax(250);
//        //textView.setText("Progress: "+ seekBar.getProgress() + "/" + seekBar.getMax());
//
//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//
//
//
//            //khi thay doi gia tri
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//            }
//
//            //khi ng dung bat dau cu chi keo thanh gat
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            //khi ng dung ket thuc cu chi keo thanh gat
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
////                textView.setText("Progress: " + seekBar.getProgress() + "/" + seekBar.getMax());
////                Log.i("Min", "Stopped tracking seekbar");
////                Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
//                //textView.setText("Progress: " + seekBar.getProgress() + "/" + seekBar.getMax());
//
//                String value = String.valueOf(seekBar.getProgress());
//                Log.d("Min", "value progress: " + value);
//                list.add(value);
//                arrayAdapter.notifyDataSetChanged();
//                listView.invalidate();
//
//
//            }
//        });
//    }
//
//}
//
////          1, add value get dc vao 1 array
////        2, set array do vao listview
////        3, set arrray vao listview ntn thi hoc cach su dung listview cuar android

package com.example.thuylazy.playsong;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    SeekBar seekBar;
    ListView listView;
    List<String> value;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView) ;

        value = new ArrayList<>();

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setMax(250);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {



            //khi thay doi gia tri
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {



            }

            //khi ng dung bat dau cu chi keo thanh gat

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            //khi ng dung ket thuc cu chi keo thanh gat
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


                value.add(seekBar.getProgress() + "");
                Log.d("Min", "value progress: " + value);
                arrayAdapter.notifyDataSetChanged();
                listView.invalidate();


            }
        });

        //String [] string = value.toArray(new String[value.size()]);
        //Log.e("Min", "string" + string);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,value );
        listView.setAdapter(arrayAdapter);


    }

}

