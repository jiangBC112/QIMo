package com.example.wlw.qimo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText regNameEdT=(EditText)findViewById(R.id.regName);
        EditText regPwdEdT=(EditText)findViewById(R.id.regPwd) ;
        EditText regPWd2EdT=(EditText)findViewById(R.id.regPwd2);
        Button registerBtn=(Button)findViewById(R.id.registbtn2);
        Button exitbtn=(Button)findViewById(R.id.exit);
        final String regName=regNameEdT.getText().toString();
        final String regPwd=regPwdEdT.getText().toString();
        final String regPwd2=regPWd2EdT.getText().toString();
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(regPwd.equals(regPwd2)){


                SharedPreferences sp=getSharedPreferences("RegiMsg",MODE_PRIVATE);
                SharedPreferences.Editor editor=sp.edit();
                editor.putString("regName",regName);
                editor.putString("regPwd",regPwd);
                }else{

                        Toast.makeText(RegisterActivity.this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();

                }

            }
        });
        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
