package com.example.spentplaying.fakeptt;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        Button btn_cancel = (Button) findViewById(R.id.cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                setResult(RESULT_CANCELED,resultIntent);
                finish();
            }
        });
        Button btn_post = (Button) findViewById(R.id.post);
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                setResult(RESULT_OK,resultIntent);
                EditText tx_f = (EditText) findViewById(R.id.title);
                EditText tx_e = (EditText) findViewById(R.id.content);
                String title = tx_f.getText().toString();
                String content = tx_e.getText().toString();
                SharedPreferences settings = getSharedPreferences("NAME",MODE_PRIVATE);
                String f_name = settings.getString("f_name","");
                String l_name = settings.getString("l_name","");
                String name = f_name + " " + l_name ;
                ContentValues values = new ContentValues();
                // Read the data  and save it in SQLite
                PostOpenHelper mDBhelper = new PostOpenHelper(PostActivity.this);
                SQLiteDatabase db = mDBhelper.getWritableDatabase();
                values.put(PostContract.Post.COLUMN_NAME_USER,name);
                values.put(PostContract.Post.COLUMN_NAME_TITLE,title);
                values.put(PostContract.Post.COLUMN_NAME_CONTENT,content);
                db.insert(
                        PostContract.Post.TABLE_NAME,
                        PostContract.Post.COLUMN_NAME_USER,
                        values
                );
                finish();
            }
        });
    }
}
