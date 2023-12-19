package com.example.twitter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        TabLayout tabLayout = rootView.findViewById(R.id.home_tb);

        // 탭 추가
        tabLayout.addTab(tabLayout.newTab().setText("For you"));
        tabLayout.addTab(tabLayout.newTab().setText("Following"));

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

        ImageView write_post = rootView.findViewById(R.id.home_wrtie_post);
        write_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //화면전환
                Intent intent = new Intent(requireContext(), WritepostActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

    private void replaceFragment(int position) {
        Fragment fragment;

        switch (position) {
            case 0:
                fragment = new ForyouFragment();
                break;
            case 1:
                fragment = new FollowingFragment();
                break;
            default:
                throw new IllegalArgumentException("Invalid tab position");
        }

        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.home_frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
