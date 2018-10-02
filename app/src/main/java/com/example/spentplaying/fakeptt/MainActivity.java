package com.example.spentplaying.fakeptt;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int POST = 0;
    private static final int SETTING = 1;
    private static final int LOG = 2;
    ArrayList<Post> postArrayList;
    MyBaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postArrayList = new ArrayList<>();
        adapter = new MyBaseAdapter(MainActivity.this,postArrayList);
        ListView listView = (ListView) findViewById(R.id.lsview);
        listView.setAdapter(adapter);
        PostOpenHelper mDBhelper = new PostOpenHelper(MainActivity.this);
        SQLiteDatabase db = mDBhelper.getReadableDatabase();
        Cursor cursor = db.query(
                PostContract.Post.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        int numOfRows = cursor.getCount();
        for(int i=0;i<numOfRows;i++){
            String name = cursor.getString(1);
            String nickname = cursor.getString(2);
            String title = cursor.getString(3);
            String content = cursor.getString(4);
            Log.d("QQ",name+" "+content);
            postArrayList.add(new Post(name,nickname,title,content));
            cursor.moveToNext();
        }
        Button btn_setting = (Button) findViewById(R.id.btn_setting);
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
        Button btn_post = (Button) findViewById(R.id.btn_post);
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostActivity.class);
                startActivityForResult(intent,POST);
            }
        });
        Button btn_log = (Button) findViewById(R.id.btn_log);
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.updatePostArrayLiset(postArrayList);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==POST){
            if(resultCode==RESULT_OK){
                String nickname = data.getStringExtra("nickname");
                String content = data.getStringExtra("content");
                postArrayList.add(new Post(null,nickname,null,content));
            }
        }
    }
}
