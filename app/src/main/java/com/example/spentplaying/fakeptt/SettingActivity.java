package com.example.spentplaying.fakeptt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {
    private String f_name="",l_name="";
    private String nickname="";
    void setview(){
        SharedPreferences settings = getSharedPreferences("NAME",MODE_PRIVATE);
        f_name = settings.getString("f_name","");
        l_name = settings.getString("l_name","");
        nickname = settings.getString("nickname","");
        TextView tx1 = (TextView) findViewById(R.id.tx1);
        tx1.setText("NAME : "+f_name+" "+l_name);
        TextView tx2 = (TextView) findViewById(R.id.tx2);
        tx2.setText("NICKNAME : "+nickname);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setview();
        Button btn_edit = (Button) findViewById(R.id.btn_edit);
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, EditActivity.class);
                startActivityForResult(intent,0);
            }
        });
        Button btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK){
            Log.d("QQ","QQ");
            setview();
        }
    }
}
