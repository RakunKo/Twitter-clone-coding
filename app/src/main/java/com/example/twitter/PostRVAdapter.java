package com.example.twitter;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class PostRVAdapter extends ArrayAdapter<String> {

    private List<String> itemList;

    public PostRVAdapter(@NonNull Context context, @NonNull List<String> itemList) {
        super(context, R.layout.item_post, itemList);
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_post, parent, false);

        String item = itemList.get(position);

        return convertView;
    }

    static class ViewHolder {
        TextView textView;
    }
}

