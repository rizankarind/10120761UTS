package com.programmer.uts10120761;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class WalkThrough1 extends AppCompatActivity {
    private com.programmer.uts10120761.OnBoardingAdapter onBoardingAdapter;
    private LinearLayout LayoutOnBoardingIndicators;
    private Button OnBoardingAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_through1);

        LayoutOnBoardingIndicators = findViewById(R.id.vp1_layoutOnBoardingIndicator);
        OnBoardingAction = findViewById(R.id.vp1_buttonOnBoard);

        setupOnBoardingItems();

        ViewPager2 onBoardingViewPager = findViewById(R.id.vp1_onboardingvp);
        onBoardingViewPager.setAdapter(onBoardingAdapter);

        setupOnBoardingIndicators();
        setCurrentOnBoardingIndicator(0);

        onBoardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnBoardingIndicator(position);
            }
        });

        OnBoardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onBoardingViewPager.getCurrentItem() + 1 < onBoardingAdapter.getItemCount()){
                    onBoardingViewPager.setCurrentItem(onBoardingViewPager.getCurrentItem() + 1);
                }else {
                    startActivity(new Intent(getApplicationContext(), com.programmer.uts10120761.HomeActivity.class));
                    finish();
                }
            }
        });
    }
    private void setupOnBoardingItems(){
        List<com.programmer.uts10120761.OnBoardingItem> onBoardingItems = new ArrayList<>();
        com.programmer.uts10120761.OnBoardingItem item1 = new com.programmer.uts10120761.OnBoardingItem();
        item1.setTittle("Halo Semua");
        item1.setDescription("Selamat Datang di Aplikasi Rizan Apps");
        item1.setImage(R.drawable.welcome);

        com.programmer.uts10120761.OnBoardingItem item2 = new com.programmer.uts10120761.OnBoardingItem();
        item2.setTittle("Profil, Kegiatan, Galeri, Musik & Video");
        item2.setDescription("Kamu dapat menemukan profil, kegiatan sehari-hari, galeri foto, musik, dan video favoritk saya disini");
        item2.setImage(R.drawable.ic_profil);

        com.programmer.uts10120761.OnBoardingItem item3 = new com.programmer.uts10120761.OnBoardingItem();
        item3.setTittle("Kontak Saya");
        item3.setDescription("Kamu juga bisa menyapa saya melalui salah satu sosial media yang ada");
        item3.setImage(R.drawable.communicate);

        onBoardingItems.add(item1);
        onBoardingItems.add(item2);
        onBoardingItems.add(item3);

        onBoardingAdapter = new com.programmer.uts10120761.OnBoardingAdapter(onBoardingItems);
    }
    private void setupOnBoardingIndicators(){
        ImageView[] indicators = new ImageView[onBoardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0,8,0);
        for (int i = 0 ; i < indicators.length; i++){
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboard_indicator_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            LayoutOnBoardingIndicators.addView(indicators[i]);

        }
    }

    private void setCurrentOnBoardingIndicator(int index){
        int childCount = LayoutOnBoardingIndicators.getChildCount();
        for (int i = 0; i < childCount; i++){
            ImageView imageView = (ImageView)LayoutOnBoardingIndicators.getChildAt(i);
            if(i == index){
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_active)
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboard_indicator_inactive)
                );
            }
        }
        if (index == onBoardingAdapter.getItemCount() - 1 ){
            OnBoardingAction.setText("Start");

        }else {
            OnBoardingAction.setText("Next");
        }


    }
}