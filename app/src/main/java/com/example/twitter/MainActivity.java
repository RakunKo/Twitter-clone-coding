package com.example.twitter;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.twitter.CommentFragment;
import com.example.twitter.LikeFragment;
import com.example.twitter.MediaFragment;
import com.example.twitter.PostFragment;
import com.example.twitter.R;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.main_content_tb);

        // 탭 추가
        tabLayout.addTab(tabLayout.newTab().setText("게시글"));
        tabLayout.addTab(tabLayout.newTab().setText("답글"));
        tabLayout.addTab(tabLayout.newTab().setText("미디어"));
        tabLayout.addTab(tabLayout.newTab().setText("마음에 들어요"));

        // 탭 선택 리스너 등록
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // 선택된 탭에 따라 프래그먼트를 교체
                replaceFragment(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        // 초기화면 설정
        replaceFragment(0);
    }
    private void replaceFragment(int position) {
        Fragment fragment;

        switch (position) {
            case 0:
C                break;
            case 1:
                fragment = new CommentFragment();
                break;
            case 2:
                fragment = new MediaFragment();
                break;
            case 3:
                fragment = new LikeFragment();
                break;
            default:
                throw new IllegalArgumentException("Invalid tab position");
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}