package com.example.alphacar;


import static com.example.alphacar.Common.CommonMethod.isNetworkConnected;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.alphacar.ATask.ListAllDetail;
import com.example.alphacar.Adapter.MyGridViewAdapter;
import com.example.alphacar.DTOS.NowDTO;
import com.example.alphacar.DTOS.StoreDTO;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class NowActivity extends AppCompatActivity {
    GridView gridView;
    MyGridViewAdapter adapter;
    ArrayList<StoreDTO> list = new ArrayList<>();

    ListAllDetail listAllDetail;

    ArrayList<NowDTO> nowDTOArrayList = new ArrayList<>();

    //String customer_email = ;
    int store_number = 0;

    ImageView btn_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now);

        Intent intent = getIntent();
        store_number = intent.getIntExtra("store_number", 0);

        btn_back = findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        StoreDTO dto = new StoreDTO();
        if(isNetworkConnected(this) == true){
            listAllDetail = new ListAllDetail(store_number, list, adapter );
            //listDetail = new ListDetail(store_number);
            try {
                listAllDetail.execute().get();
                //Log.d(TAG, "onCreate: "+dto.getCustomer_email());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            Toast.makeText(this, "인터넷이 연결되어 있지 않습니다.",
                    Toast.LENGTH_SHORT).show();
        }
        gridView = findViewById(R.id.gridView);
        //dto.setNow_state("Y");
        for (int i = 0; i < list.size(); i++ ){
            if (list.get(i).getNow_state().equals("Y")){
                nowDTOArrayList.add(new NowDTO("able", "able"));
            } else if(list.get(i).getNow_state().equals("N")){
                nowDTOArrayList.add(new NowDTO("disable", "disable"));
            } else if(list.get(i).getNow_state().equals("X")) {
                nowDTOArrayList.add(new NowDTO("x", "x"));
            }
        }


        adapter = new MyGridViewAdapter(this, nowDTOArrayList);

        //gridview사이
/*        gridView.setVerticalSpacing(0);
        gridView.setHorizontalSpacing(0);*/

        //gridview 열 갯수
        gridView.setNumColumns(3);

        gridView.setAdapter(adapter);
        // gridView.setlayout(layoutManager);



    }


}
