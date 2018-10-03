package com.example.spentplaying.fakeptt;

import android.content.Context;
import android.os.TestLooperManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyBaseAdapter extends BaseAdapter {
    LayoutInflater inflater;
    ArrayList<Post> postArrayList;
    public MyBaseAdapter(Context context, ArrayList<Post> _postArrayList){
        inflater = LayoutInflater.from(context);
        postArrayList=_postArrayList;
    }
    @Override
    public int getCount() {
        return postArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return postArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    static class ViewHolder{
        TextView nickname;
        TextView content;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_item_name,null);
            holder = new ViewHolder();
            holder.nickname = (TextView) convertView.findViewById(R.id.name);
            holder.content = (TextView) convertView.findViewById(R.id.content);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        Post post = (Post) getItem(position);
        holder.nickname.setText(post.getNickname());
        holder.content.setText(post.getContent());
        return convertView;
    }
    public void updatePostArrayList(ArrayList<Post> _postArrayList){
        postArrayList=_postArrayList;
        notifyDataSetChanged();
    }
}
