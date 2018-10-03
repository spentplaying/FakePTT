package com.example.spentplaying.fakeptt;

public class Post {
    String name;
    String nickname;
    String title;
    String content;

    public Post(String _name,String _nickname,String _title,String _content){
        name = _name;
        nickname = _nickname;
        title = _title;
        content = _content;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

}
