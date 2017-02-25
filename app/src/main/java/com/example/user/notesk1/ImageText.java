package com.example.user.notesk1;

import android.Manifest;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.R.attr.path;

public class ImageText extends AppCompatActivity {
    private static final String TAG = "   a    ";
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_text);
        final FrameLayout frameLayout = (FrameLayout)findViewById(R.id.frame);
        TextView tv1=(TextView)findViewById(R.id.textView1);
        final Intent intent=getIntent();
        final String q=intent.getStringExtra("text");
        tv1.setText(q);
//        final String path=Environment.getExternalStorageDirectory().getAbsolutePath()+ "file.png";

        Button bt = (Button) findViewById(R.id.button3);
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //isStoragePermissionGranted();
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                String term = q; // term which you want to search for
                intent.putExtra(SearchManager.QUERY, term);
                startActivity(intent);



            }

        });
    }



    }








