package com.example.spentplaying.fakeptt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.spentplaying.fakeptt.PostContract;

public class PostOpenHelper extends SQLiteOpenHelper{
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGRE_TYPE = " INTEGER";
    private static final String COMMA_SEP = " ,";
    private static final String POST_TABLE_CREATE =
            "CREATE TABLE IF NOT EXISTS " + PostContract.Post.TABLE_NAME + "(" +
                    PostContract.Post._ID +" INTEGER PRIMARY KEY," +
                    PostContract.Post.COLUMN_NAME_USER + TEXT_TYPE + COMMA_SEP +
                    PostContract.Post.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    PostContract.Post.COLUMN_NAME_CONTENT + TEXT_TYPE  +" )";
    private static final String POST_TABLE_DELETE =
            "DROP TABLE IF EXISTS "+ PostContract.Post.TABLE_NAME;
    private static  final  int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "post.db";
    PostOpenHelper(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(POST_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion) db.execSQL(POST_TABLE_DELETE);
        onCreate(db);
    }
}
