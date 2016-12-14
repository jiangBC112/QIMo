package com.example.wlw.qimo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Registerbtn=(Button)findViewById(R.id.register);
        final EditText usernameEdT=(EditText)findViewById(R.id.username);
        final EditText pwdEdT=(EditText)findViewById(R.id.pwd);
        Button Loginbtn=(Button)findViewById(R.id.login);
        Loginbtn.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                String username=usernameEdT.getText().toString();
             String pwd=pwdEdT.getText().toString();
              if(username.equals("abc")&&pwd.equals("123")){
                    Bundle bundle=new Bundle();
                  bundle.putString("username",username);
                  bundle.putString("pwd",pwd);
                  Intent intent=new Intent(MainActivity.this,MessageActivity.class);
                  intent.putExtras(bundle);
                  startActivity(intent);
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                }
            }
       });
        Registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
               startActivity(intent);
            }
        });

    }
}
