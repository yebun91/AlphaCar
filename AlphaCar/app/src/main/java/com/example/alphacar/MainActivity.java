package com.example.alphacar;

import static com.example.alphacar.Common.CommonMethod.isNetworkConnected;
import static com.example.alphacar.LoginPage.loginDTO;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.example.alphacar.ATask.Storelist;
import com.example.alphacar.Adapter.ViewpagerAdapter;
import com.example.alphacar.DTOS.MemberVO;
import com.example.alphacar.DTOS.StoreDTO;
import com.example.alphacar.Fragment.ViewpagerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "main:MainActivity";
    
    NavigationView nav_view;
    DrawerLayout draw_layout;
    ViewPager pager;
    ArrayList<StoreDTO> storeDTOArrayList;
    BottomNavigationView bottomNavigationView;
    SearchView searchView ;
    Fragment viewpagerfragment;
    StoreDTO dto;
    Storelist storelist;
    LottieAnimationView animationView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pager = findViewById(R.id.pager);


        nav_view = findViewById(R.id.nav_view);
        // implement Listener 할 떄는 반드시 아래와 같이 정의 한다.
        nav_view.setNavigationItemSelectedListener(this);
        draw_layout = findViewById(R.id.draw_layout);
      //  viewPager2 = findViewById(R.id.pager);
        searchView = findViewById(R.id.searchView);
        storeDTOArrayList = new ArrayList<>();

        View headerView = nav_view.getHeaderView(0);
        ImageView login_image = headerView.findViewById(R.id.loginImage);
        TextView login_text =headerView.findViewById(R.id.loginID);
        TextView login_str =  headerView.findViewById(R.id.loginStr);

        if(isNetworkConnected(this) == true){
            storelist  = new Storelist(dto, storeDTOArrayList);
            //listDetail = new ListDetail(store_number);
            try {
                storelist.execute().get();
            //    Log.d(TAG, "onCreate: "+dto.getCustomer_email());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            Toast.makeText(this, "인터넷이 연결되어 있지 않습니다.",
                    Toast.LENGTH_SHORT).show();
        }

// 메인 뷰페이저
///////////////////////////////////////////////////////////////////////////////
        /* 메인 뷰페이저 스프링에서 데이터받아온 만큼 횡스크롤로 뿌려줌 */
        ArrayList<Fragment> list = new ArrayList<>();
        for (int i =0; i<storeDTOArrayList.size(); i++){
            list.add(new ViewpagerFragment(storeDTOArrayList.get(i)));
        }

        ViewpagerAdapter viewpagerAdapter =
                new ViewpagerAdapter(getSupportFragmentManager());
        viewpagerAdapter.setList(list);
        pager.setAdapter(viewpagerAdapter);

////////////////////////////////////////////////////////////////////////////////

/*        Intent intent = new Intent(MainActivity.this, LoadingPageActivity.class);
        startActivity(intent);*/



  /*          animationView = findViewById(R.id.lottie);
            animationView.setAnimation("test8.json");
            animationView.loop(true);
            animationView.playAnimation();
            animationView.setRepeatCount(2);
*/

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        /* 메인 뷰페이저에 데이터 집어넣기 */
             storeDTOArrayList = new ArrayList<StoreDTO>();

        /*tab2 즐겨찾기*/
        findViewById(R.id.tab2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), FavoriteActivity.class);
                startActivity(intent);
            }
        });

        /*tab3 로그인,회원가입*/
        findViewById(R.id.tab3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), LoginJoinSelect.class);
                startActivity(intent);
            }
        });

      //  ImageView login_image






        /*tab4 마이페이지 */
       findViewById(R.id.tab4).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if(loginDTO != null){
                //   login_image.setImageResource(loginDTO.getCustomer_picture());
                   Glide.with(MainActivity.this)
                           .load(loginDTO.getCustomer_picture())
                           // .load("https://upload3.inven.co.kr/upload/2020/06/21/bbs/i015955522648.gif")//.load("url넣기 png,gif,jpg파일 밖에 안됨")
                           .circleCrop()
                           .into(login_image);
                   login_text.setText(loginDTO.getCustomer_name());
                   login_str.setText(loginDTO.getCustomer_email());
               }

               draw_layout.openDrawer(GravityCompat.START);

           }
       });


        /*메인 뷰페이저*/



        /*바텀 네비게이션*/
        bottomNavigationView = findViewById(R.id.bottom_navi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {



                return true;
                }

    });
    }

    /*바텀 네비게이션*/
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        // 클릭한 아이템의 아이디를 얻는다.
        int id = item.getItemId();

        if (id == R.id.nav_favorite){
            Intent intent = new Intent(getApplicationContext(), FavoriteActivity.class);
            startActivity(intent);
        }else if (id == R.id.nav_myPage){
            Intent intent = new Intent(getApplicationContext(), MemberUpdatePage.class);
            startActivity(intent);
        }else if (id == R.id.nav_noti){
            Intent intent = new Intent(getApplicationContext(), FavoriteActivity.class);
            startActivity(intent);
        }else if(id == R.id.nav_logout){
            loginDTO = null;
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }

        // 메뉴 선택 후 드로어가 사라지게 한다.
        draw_layout.closeDrawer(GravityCompat.START);

        return true;

    }

    // 뒤로가기를 눌렀을때 만약 드로어 창이 열려있으면 드로어 창을 닫고
    // 아니면 그냥 뒤로가기 원래 작업을 한다(여기서는 앱 종료).
    @Override
    public void onBackPressed() {
        if (draw_layout.isDrawerOpen(GravityCompat.START)){
            draw_layout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }

}