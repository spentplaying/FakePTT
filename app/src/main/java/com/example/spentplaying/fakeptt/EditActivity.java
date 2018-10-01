package com.example.spentplaying.fakeptt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    private String f_name,l_name;
    private String nickname;
    void setview(){
        SharedPreferences settings = getSharedPreferences("NAME",MODE_PRIVATE);
        f_name = settings.getString("f_name","");
        l_name = settings.getString("l_name","");
        nickname = settings.getString("nickname","");
        EditText tx_l = (EditText) findViewById(R.id.l_name);
        EditText tx_f = (EditText) findViewById(R.id.f_name);
        EditText tx_e = (EditText) findViewById(R.id.n_name);
        tx_l.setText(l_name);
        tx_f.setText(f_name);
        tx_e.setText(nickname);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        setview();
        Button btn_cancel = (Button) findViewById(R.id.cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                setResult(RESULT_CANCELED,resultIntent);
                finish();
            }
        });
        Button btn_save = (Button) findViewById(R.id.save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                EditText tx_l = (EditText) findViewById(R.id.l_name);
                EditText tx_f = (EditText) findViewById(R.id.f_name);
                EditText tx_e = (EditText) findViewById(R.id.n_name);
                f_name = tx_f.getText().toString();
                l_name = tx_l.getText().toString();
                nickname = tx_e.getText().toString();
                SharedPreferences settings = getSharedPreferences("NAME",MODE_PRIVATE);
                SharedPreferences.Editor editor= settings.edit();
                editor.putString("f_name",f_name);
                editor.putString("l_name",l_name);
                editor.putString("nickname",nickname);
                editor.commit();
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });
    }
}
