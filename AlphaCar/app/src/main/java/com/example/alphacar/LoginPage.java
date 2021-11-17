package com.example.alphacar;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.se.omapi.Session;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.alphacar.ATask.LoginSelect;
import com.example.alphacar.Dto.MemberDTO;

import java.util.concurrent.ExecutionException;

public class LoginPage extends AppCompatActivity {

    // 로그인이 성공하면 static 로그인DTO 변수에 담아서
    // 어느곳에서나 접근할 수 있게 한다
    public static MemberDTO loginDTO = null;

    EditText memberlogin_et_email, memberlogin_et_pw;
    Button memberlogin_bt_login, memberlogin_bt_join;
    ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        checkDangerousPermissions();

        memberlogin_et_email = findViewById(R.id.memberlogin_et_email);
        memberlogin_et_pw = findViewById(R.id.memberlogin_et_pw);

        memberlogin_bt_login = findViewById(R.id.memberlogin_bt_login);
        memberlogin_bt_join = findViewById(R.id.memberlogin_bt_join);
        btn_back = findViewById(R.id.btn_back);

        //상단 뒤로가기
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // 로그인 버튼
        memberlogin_bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(memberlogin_et_email.getText().toString().length() != 0 && memberlogin_et_pw.getText().toString().length() != 0){
                    String customer_email = memberlogin_et_email.getText().toString();
                    String customer_pw = memberlogin_et_pw.getText().toString();

                    LoginSelect loginSelect = new LoginSelect(customer_email, customer_pw);

                    try {
                        loginSelect.execute().get();
                    } catch (ExecutionException e) {
                        e.getMessage();
                    } catch (InterruptedException e) {
                        e.getMessage();
                    }

                } else {
                    Toast.makeText(LoginPage.this, "아이디와 암호를 모두 입력하세요.", Toast.LENGTH_SHORT).show();
                    Log.d("main:login", "아이디와 암호를 모두 입력하세요.");
                    return;
                }

                if(loginDTO != null){
                    Toast.makeText(LoginPage.this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                    Log.d("main:login", loginDTO.getCustomer_name() + "님 로그인 되었습니다.");

                    // 로그인 정보에 값이 있으면 로그인이 되었으므로 메인화면으로 이동
                    if(loginDTO != null){
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }

                }else {
                    Toast.makeText(LoginPage.this, "아이디나 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    Log.d("main:login", "아이디나 비밀번호가 일치하지 않습니다.");
                    memberlogin_et_email.setText("");
                    memberlogin_et_pw.setText("");
                    memberlogin_et_email.requestFocus();
                }

            }
        });

        // 회원 가입 버튼
        memberlogin_bt_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 회원가입 화면
                Intent intent = new Intent(getApplicationContext(), JoinPage.class);
                startActivity(intent);
            }
        });


    }

    //권한설정
    private void checkDangerousPermissions() {
        String[] permissions = {
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.CHANGE_WIFI_STATE,
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.ACCESS_MEDIA_LOCATION,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (int i = 0; i < permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            //Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
        } else {
            //Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                //Toast.makeText(this, "권한 설명 필요함.", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    //Toast.makeText(this, permissions[i] + " 권한이 승인됨.", Toast.LENGTH_LONG).show();
                } else {
                    //Toast.makeText(this, permissions[i] + " 권한이 승인되지 않음.", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}