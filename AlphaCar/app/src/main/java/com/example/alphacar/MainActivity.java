package com.example.alphacar;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.alphacar.LoginPage.loginDTO;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_go, btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_go = findViewById(R.id.btn_go);
        btn_go.setOnClickListener(new View.OnClickListener() {
            // 로그인 화면으로 이동
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);
            }
        });

        btn_update = findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            // 회원정보 수정으로 이동
            @Override
            public void onClick(View v) {
                //로그인 되어 있지 않을 경우 로그인페이지로 이동
                if(loginDTO == null){
                    Toast.makeText(MainActivity.this, "로그인을 먼저 해주세요.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                    startActivity(intent);
                }
                Intent intent = new Intent(getApplicationContext(), MemberUpdatePage.class);
                startActivity(intent);
            }
        });
    }

}