package com.programmer.uts10120761;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Gallery extends AppCompatActivity {
    Context contextGallery;
    RecyclerView recyclerViewGallery;
    RecyclerView.Adapter recyclerViewAdapterGallery;
    RecyclerView.LayoutManager recylerViewLayoutManagerGallery;
    String[] subjectsGallery = {
            "Gambar 1", "Gambar 2", "Gambar 3","Gambar 4", "Gambar 5", "Gambar 6","Gambar 7", "Gambar 8", "Gambar 9","Gambar 10", "Gambar 11", "Gambar 12"
    };
    int[] subjectImageGallery={
            R.drawable.gb1,R.drawable.gb2,
            R.drawable.gb3,

            R.drawable.gb4,R.drawable.gb5,
            R.drawable.gb6,

            R.drawable.gb7,R.drawable.gb8,
            R.drawable.gb9,

            R.drawable.gb7,R.drawable.gb8,
            R.drawable.gb9
    };
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gallery);
        contextGallery = getApplicationContext();
        recyclerViewGallery = findViewById(R.id.recyclerViewGallery);
        recylerViewLayoutManagerGallery = new GridLayoutManager( contextGallery, 2);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerViewGallery.setLayoutManager(recylerViewLayoutManagerGallery);
        recyclerViewAdapterGallery = new com.programmer.uts10120761.AdapterRecyclerViewGallery(subjectsGallery, subjectImageGallery,contextGallery );
        recyclerViewGallery.setAdapter(recyclerViewAdapterGallery);
        //ass
        drawerLayout = findViewById(R.id.DrawerLayout);
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
        //recreate
        recreate();
    }

    public void ClickDaily(View view){
        //redirect to gallery
        com.programmer.uts10120761.HomeActivity.redirectActivity(this, com.programmer.uts10120761.Daily.class);
    }
    public void ClickMusic(View view){
        //redirect to music
        com.programmer.uts10120761.HomeActivity.redirectActivity(this, com.programmer.uts10120761.Music.class);
    }
    public void ClickProfile(View view){
        //redirect to profile
        com.programmer.uts10120761.HomeActivity.redirectActivity(this,Profile.class);
    }
    public void ClickLogout(View view){
        //close
        com.programmer.uts10120761.HomeActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        com.programmer.uts10120761.HomeActivity.closeDrawer(drawerLayout);
    }
}