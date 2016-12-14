package com.example.wlw.qimo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MessageActivity extends AppCompatActivity {
    private EditText riji=(EditText)findViewById(R.id.riji);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        Button savebtn=(Button)findViewById(R.id.Savebtn) ;
        Button Exitbtn=(Button)findViewById(R.id.Msgexit) ;
        TextView usernameTxv=(TextView)findViewById(R.id.usernameTxV);//获取用户名
        final String riji=((EditText)findViewById(R.id.riji)).getText().toString();//获取日记内容
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String username=bundle.getString("username");
        usernameTxv.setText(username+"你好");

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getSharedPreferences("RiJi",MODE_PRIVATE);
                SharedPreferences.Editor editor=sp.edit();
                editor.putString("riji",riji);

            }
        });
        Exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private Handler handler=new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
           {
                case 1:
                    String response=(String) msg.obj;
                    riji.setText(response);

            }
       }
    };
}
