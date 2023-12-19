package com.example.twitter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class PostFragment extends Fragment {

    private List<String> itemList;
    private PostRVAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_post, container, false);

        // Initialize itemList
        itemList = new ArrayList<>();

        itemList.add("1");
        itemList.add("2");
        itemList.add("3");
        itemList.add("4");

        adapter = new PostRVAdapter(requireContext(), itemList);
        ListView listView = rootView.findViewById(R.id.post_lv);
        // ListView에 어댑터 설정
        listView.setAdapter(adapter);

        return rootView;
    }

    private void addItem(String newItem) {
        itemList.add(newItem);
        adapter.notifyDataSetChanged();
    }
}