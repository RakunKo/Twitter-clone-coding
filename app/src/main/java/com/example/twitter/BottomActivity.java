package com.example.twitter;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
public class BottomActivity extends AppCompatActivity {
    Fragment home;
    Fragment search;
    Fragment alarm;
    Fragment user;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        home = new HomeFragment();
        search = new SearchFragment();
        alarm = new AlarmFragment();
        user = new UserinfoFragment();

        BottomNavigationView bn = findViewById(R.id.main_bnv);
        getSupportFragmentManager().beginTransaction().add(R.id.main_frm, home).commit(); //FrameLayout에 fragment.xml 띄우기
        // 리스너 등록
        bn.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frm, home).commitAllowingStateLoss();
                    return true;
                } else if (item.getItemId() == R.id.search) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frm, search).commitAllowingStateLoss();
                    return true;
                } else if (item.getItemId() == R.id.alarm) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frm, alarm).commitAllowingStateLoss();
                    return true;
                } else if (item.getItemId() == R.id.user) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frm, user).commitAllowingStateLoss();
                    return true;
                }
                return false;
            }
        });


    }
}
