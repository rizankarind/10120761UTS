package com.programmer.uts10120761;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Music extends AppCompatActivity {
    Context contextVideo, context;
    RecyclerView recyclerViewVideo, recyclerViewMusic;
    RecyclerView.Adapter recyclerViewAdapterVideo, recyclerViewAdapterMusic;
    RecyclerView.LayoutManager recylerViewLayoutManagerVideo, recylerViewLayoutManagerMusic;
    VideoView videoView;
    String[] subjectValuesVideo = {
            "Barista", "Kucing", "Info"
    };
    String[] subjectUrlVideo;
    String[] subjectValuesMusic = {
            "Bazzi - Beautiful",
            "Bazzi - Beautiful",
            "Bazzi - Beautiful",
            "Bazzi - Fantasy",
            "Bazzi - Fantasy",
            "Bazzi - Fantasy",
            "Bazzi - I.F.L.Y.",
            "Bazzi - I.F.L.Y.",
            "Bazzi - I.F.L.Y.",
            "Bazzi - Mine",
            "Bazzi - Mine",
            "Bazzi - Mine",
            "Bazzi - Mine"
};
    DrawerLayout drawerLayout;
@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        subjectUrlVideo=new String[]{
      "android.resource://"+getPackageName()+"/"+R.raw.video,
       "android.resource://"+getPackageName()+"/"+R.raw.video2,
        "android.resource://"+getPackageName()+"/"+R.raw.video3
        };
        contextVideo=getApplicationContext();
        recyclerViewVideo=findViewById(R.id.recyclerViewVideo);
        recylerViewLayoutManagerVideo=new LinearLayoutManager(this);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerViewVideo.setLayoutManager(recylerViewLayoutManagerVideo);
        recyclerViewAdapterVideo=new com.programmer.uts10120761.AdapterRecycleViewVideo(subjectValuesVideo,subjectUrlVideo,this);
        recyclerViewVideo.setAdapter(recyclerViewAdapterVideo);

        context=getApplicationContext();
        recyclerViewMusic=findViewById(R.id.recyclerViewMusic);
        recylerViewLayoutManagerMusic=new LinearLayoutManager(context);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerViewMusic.setLayoutManager(recylerViewLayoutManagerMusic);
        recyclerViewAdapterMusic=new com.programmer.uts10120761.AdapterRecycleViewMusic(subjectValuesMusic,context);
        recyclerViewMusic.setAdapter(recyclerViewAdapterMusic);

        //ass
        drawerLayout=findViewById(R.id.DrawerLayout);
        }
public void ClickMenu(View view){
        //Open drawer
        com.programmer.uts10120761.HomeActivity.openDrawer(drawerLayout);

        }
public void ClickLogo(View view){
        com.programmer.uts10120761.HomeActivity.closeDrawer(drawerLayout);
        }
public void ClickHome(View view){
        //redirect to home
        com.programmer.uts10120761.HomeActivity.redirectActivity(this, com.programmer.uts10120761.HomeActivity.class);
        }
public void ClickGallery(View view){
        //redirect to gallery
        com.programmer.uts10120761.HomeActivity.redirectActivity(this, com.programmer.uts10120761.Gallery.class);
        }

public void ClickDaily(View view){
        //redirect to gallery
        com.programmer.uts10120761.HomeActivity.redirectActivity(this, com.programmer.uts10120761.Daily.class);
        }
public void ClickMusic(View view){

        //recreate
        recreate();
        }
public void ClickProfile(View view){
        //redirect to profile
        com.programmer.uts10120761.HomeActivity.redirectActivity(this, com.programmer.uts10120761.Profile.class);
        }
public void ClickLogout(View view){
        //close
        com.programmer.uts10120761.HomeActivity.logout(this);
        }

@Override
protected void onPause(){
        super.onPause();
        //close drawer
        com.programmer.uts10120761.HomeActivity.closeDrawer(drawerLayout);
        }
        }