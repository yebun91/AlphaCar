package com.example.alphacar;




import static com.example.alphacar.Common.CommonMethod.isNetworkConnected;

import android.os.Bundle;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;


import com.example.alphacar.ATask.DetailSelect;
import com.example.alphacar.ATask.ReviewSelect;
import com.example.alphacar.Adapter.DetailAdapter;
import com.example.alphacar.Adapter.Detail_SliderAdapter;
import com.example.alphacar.DTOS.ReviewDTO;
import com.example.alphacar.DTOS.StoreDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailActivity extends AppCompatActivity{
    //사업장 정보를 id값 기준으로 가져와야함
    DetailSelect detailSelect;
    ReviewSelect reviewSelect;

    //ArrayList<String> review = new ArrayList<>();
    // List<String> review = new ArrayList<>();
    String[] review;
    StoreDTO dto = new StoreDTO();
    ReviewDTO rdto = new ReviewDTO();
    ArrayList<ReviewDTO> dtos = new ArrayList<>();

    ImageButton like_btn;

    TextView store_name;
    TextView store_price;
    TextView store_addr;

    String customer_email= "qqq@naver.com";

    ScrollView scrollView;

    //---------ViewPager Indicator---------
    ViewPager2 imageContainer;
    Detail_SliderAdapter adapter;
    int list[]; //슬라이더 개수에 넣어줄 리스트
    TextView[] dots; //점
    LinearLayout layout;
    //----------ViewPager Indicator---------

    //-----------expandableListView----------
    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> store_info;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    //-----------expandableListView------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);


        //영업장 정보 불러오는 atask
        if(isNetworkConnected(this) == true){
            detailSelect = new DetailSelect(customer_email);
            //    reviewSelect = new ReviewSelect(customer_email,dtos,rdto);
            try {
                dto = detailSelect.execute().get();
                //    reviewSelect.execute().get();
                //     reviewSelect.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            Toast.makeText(this, "인터넷이 연결되어 있지 않습니다.",
                    Toast.LENGTH_SHORT).show();
        }
        //리뷰 정보 불러오는 atask
        if(isNetworkConnected(this) == true){

            reviewSelect = new ReviewSelect(customer_email,dtos,rdto);
            try {
                reviewSelect.execute().get();
                //     reviewSelect.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            Toast.makeText(this, "인터넷이 연결되어 있지 않습니다.",
                    Toast.LENGTH_SHORT).show();
        }

        scrollView = findViewById(R.id.detail_scroll);

        //세차장 이름, 가격, 위치 가져오기
        store_name = findViewById(R.id.detail_store_name);
        store_price = findViewById(R.id.detail_store_price);
        store_addr = findViewById(R.id.detail_store_addr);

        store_name.setText(dto.getStore_name());
        store_price.setText(dto.getStore_price());
        store_addr.setText(dto.getStore_addr());


        like_btn = findViewById(R.id.detail_favorite_btn);
        //좋아요 버튼 누르면 FAV_NUMBER, CUSTOMER_EMAIL, STORE_NUMBER값을 Favorite테이블에 넣어줌
        like_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //유저 메일 = dd 인 사람이 현재 가게를 등록한다
                //1. 즐겨찾기 버튼은 로그인 된 상태에서만 활성화 된다
                //2. 즐겨찾기 버튼을 누르면 사용자의 이메일을 기준으로 favorite에 값이 담긴다
                //insert into favorite values (FAV_NUMBER ,CUSTOMER_EMAIL ,STORE_NUMBER)
                //select * from favorite where customer_email
            }
        });


        //------------ViewPager Indicator-----------------------
        layout = findViewById(R.id.dots_container);
        imageContainer = findViewById(R.id.image_container);


        // 사업장 이미지를 가져와서 넣어야 함
        list = new int[3];
       /* list[0] = getResources().getColor(R.color.black);
        list[1] = getResources().getColor(R.color.white);
        list[2] = getResources().getColor(R.color.teal_200);*/

        list[0] = getResources().getColor(R.color.black);
        list[1] = getResources().getColor(R.color.white);
        list[2] = getResources().getColor(R.color.teal_200);


        //어댑터에 리스트를 담아서 보내줌
        adapter = new Detail_SliderAdapter(list);
        imageContainer.setAdapter(adapter);

        //점 만드는거
        dots = new TextView[3];

        //점 만드는거
        setIndicators();

        //선택한 페이지의 변경 상태에 응답하기 위한 콜백 인터페이스
        imageContainer.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            //새 페이지를 선택하면 호출되는 메소드
            @Override
            public void onPageSelected(int position) {
                selectedDots(position);
                super.onPageSelected(position);
            }
        });
        //------------------------ViewPager Indicator------------------

        //-----------------------expandableListView--------------------

        //소개, 리뷰를 가져와서 넣어야함

        //부모리스트 생성
        createGroupList();
        //부모리스트에 자식리스트 넣기
        createCollection();


        expandableListView = findViewById(R.id.store_info_main);
        expandableListAdapter = new DetailAdapter(this, groupList, store_info);
        expandableListView.setAdapter(expandableListAdapter);

        //스크롤뷰 안에 리스트 뷰가 들어있을때 리스트 뷰 스크롤을 사용할때 메인 스크롤이 움직이지 않게 하는 메소드
        expandableListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                scrollView.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        //부모리스트를 펼쳤을때
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int lastExpandedPosition = -1;
            @Override
            public void onGroupExpand(int i) {
                if(lastExpandedPosition != -1 && i != lastExpandedPosition){
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = i;
            }
        });


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            //리뷰 눌렀을때 디테일하게 보기
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                String selected = expandableListAdapter.getChild(i,i1).toString();
                Toast.makeText(getApplicationContext(), "Selected: " + selected, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        //-----------------------expandableListView--------------------
    }
    //-----------------------expandableListView--------------------
    private void createCollection() {

        //소개, 리뷰를 가져와서 넣어야함
        String[] intro = {dto.getIntroduce(),"쉬는 날 :" + dto.getStore_dayoff(),"영업 시간 : " + dto.getStore_time()};//dto.getIntroduce()

        review = new String[dtos.size()];

        for(int i = 0; i <dtos.size(); i++){
            review[i] = dtos.get(i).getContent();
        }
        //일단 arrayDTO 사이즈만큼 배열 크기 주고 for문 돌리기


        //String에 부모리스트, List<String>에 자식리스트
        store_info = new HashMap<String, List<String>>();


        for(String group : groupList){
            if (group.equals("소개")){
                loadChild(intro);
            } else if (group.equals("리뷰"))
                loadChild(review);
            store_info.put(group, childList);
        }
    }

    //부모리스트 안에 자식 리스트 담는 메소드
    private void loadChild(String[] store_info) {
        childList = new ArrayList<>();
        for(String model : store_info){
            childList.add(model);
        }
    }

    //부모리스트 생성 메소드
    private void createGroupList() {
        groupList = new ArrayList<>();
        groupList.add("소개");
        groupList.add("리뷰");

    }
    //-----------------------expandableListView--------------------


    //------------ViewPager Indicator-----------------------
    //사진이 선택되었을때 점에 색깔 넣어주기
    private void selectedDots(int position) {
        for (int i = 0; i < dots.length; i++) {
            if (i == position) {
                dots[i].setTextColor(list[position]);
            } else {
                //   dots[i].setTextColor(getResources().getColor(R.color.grey));
            }
        }
    }


    //점 만들어주는 메소드
    private void setIndicators() {
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#9679;"));
            dots[i].setTextSize(14);
            layout.addView(dots[i]);
        }

    }
    //------------ViewPager Indicator-----------------------
}