package com.example.spentplaying.fakeptt;

import android.provider.BaseColumns;

public final class PostContract {
    private PostContract(){}
    public static final class Post implements BaseColumns{
        private Post(){};
        public static final String TABLE_NAME = "post";
        public static final String COLUMN_NAME_USER = "username";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_CONTENT = "content";
    }
}


