package com.example.alphacar.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alphacar.R;

public class Detail_SliderAdapter extends RecyclerView.Adapter<Detail_SliderAdapter.MyViewHolder> {

    int list[];

    public Detail_SliderAdapter(int[] list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //RecyclerView에 항목을 나타내는 지정된 형식의 새 항목이 필요한 경우 호출됩니다. viewholder 객체 생성
        //새 뷰홀더는 어댑터의 항목을 표시하는 데 사용됩니다.
        //ViewGroup parent: 어댑터 위치에 바인딩된 후 새 뷰가 추가되는 ViewGroup입니다.
        //viewtype = 새 뷰의 뷰 유형
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_slider_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //지정된 위치에 데이터를 표시합니다 뷰홀더에 데이터를 넣는 곳
        //holder = 업데이트해야 하는 뷰 홀더

        holder.view.setBackgroundColor(list[position]);
    }


    //어댑터가 보유한 데이터 집합의 총 항목 수를 반환
    @Override
    public int getItemCount() {
        return list.length;
    }


    //뷰홀더 = 각 뷰들을 보관하는 holder 객체
    public class MyViewHolder extends RecyclerView.ViewHolder {

        View view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.view);
        }
    }
}