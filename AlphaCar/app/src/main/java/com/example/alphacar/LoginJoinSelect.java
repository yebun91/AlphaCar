package com.example.alphacar;

import static com.example.alphacar.LoginPage.loginDTO;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginJoinSelect extends AppCompatActivity {
    TextView  loginjoin_bt_join;
    TextView loginjoin_bt_login;
    ImageButton btn_back;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_join_select);

        loginjoin_bt_join = findViewById(R.id.loginjoin_bt_join);
        btn_back = findViewById(R.id.btn_back);
        loginjoin_bt_login = findViewById(R.id.loginjoin_bt_login);
        if(loginDTO != null){ loginjoin_bt_login.setText("정보 수정");
            loginjoin_bt_join.setText("로그 아웃");
        }


        //상단 뒤로가기
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });




       // 로그인 페이지로 이동
        loginjoin_bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if(loginDTO != null){
                     intent = new Intent(getApplicationContext(),MemberUpdatePage.class);
                    startActivity(intent);
                }else{
                     intent = new Intent(getApplicationContext(),LoginPage.class);
                    startActivity(intent);
                }

            }
        });
    
        //회원가입 페이지로 이동
        loginjoin_bt_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginDTO != null){
                   loginDTO = null;
                   Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                   startActivity(intent);
                }else{
                    Intent intent = new Intent(getApplicationContext(),JoinPage.class);
                    startActivity(intent);
                }


            }
        });
    }
}