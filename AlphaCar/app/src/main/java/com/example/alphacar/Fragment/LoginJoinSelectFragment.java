package com.example.alphacar.Fragment;

import static com.example.alphacar.LoginPageActivity.loginDTO;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.alphacar.Fragment.JoinPageFragment;
import com.example.alphacar.LoginPageActivity;
import com.example.alphacar.MainActivity;
import com.example.alphacar.MemberUpdatePageActivity;
import com.example.alphacar.R;

public class LoginJoinSelectFragment extends AppCompatActivity {
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
                     intent = new Intent(getApplicationContext(), MemberUpdatePageActivity.class);
                    startActivity(intent);
                }else{
                     intent = new Intent(getApplicationContext(), LoginPageActivity.class);
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
                   Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                   startActivity(intent);
                }else{
                    Intent intent = new Intent(getApplicationContext(), JoinPageFragment.class);
                    startActivity(intent);
                }


            }
        });
    }
}