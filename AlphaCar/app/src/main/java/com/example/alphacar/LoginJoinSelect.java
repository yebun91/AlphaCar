package com.example.alphacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LoginJoinSelect extends AppCompatActivity {
    Button loginjoin_bt_login, loginjoin_bt_join;
    ImageButton btn_back;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginjoin_bt_join = findViewById(R.id.loginjoin_bt_join);
        btn_back = findViewById(R.id.btn_back);
        loginjoin_bt_login = findViewById(R.id.loginjoin_bt_login);
        
        //상단 뒤로가기
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        
        //로그인 페이지로 이동
        loginjoin_bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginPage.class);
                startActivity(intent);
            }
        });
    
        //회원가입 페이지로 이동
        loginjoin_bt_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),JoinPage.class);
                startActivity(intent);
            }
        });
    }
}