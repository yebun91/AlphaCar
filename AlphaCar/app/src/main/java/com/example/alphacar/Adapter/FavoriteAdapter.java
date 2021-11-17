package com.example.alphacar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.alphacar.DTOS.StoreDTO;
import com.example.alphacar.R;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ItemViewHolder> {

    Context mContext;
    ArrayList<StoreDTO> storedto;

    public FavoriteAdapter(Context mContext, ArrayList<StoreDTO> storedto) {
        this.mContext = mContext;
        this.storedto = storedto;
    }

    //RecyclerView는 ViewHolder를 새로 만들어야 할 때마다 이 메서드를 호출합니다.
    //View를 생성하고 초기화하지만 뷰의 콘텐츠를 채우지는 않습니다.
    // ViewHolder가 아직 특정 데이터에 바인딩된 상태가 아니기 때문입니다.
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.favorite, parent, false);

        return null;
    }

    //RecyclerView는 ViewHolder를 데이터와 연결할 때 이 메서드를 호출합니다.
    //이 메서드는 적절한 데이터를 가져와서 그 데이터를 사용하여 뷰 홀더의 레이아웃을 채웁니다.
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        StoreDTO item = storedto.get(position);
        holder.setItem(item);
    }


    //데이터 세트 크기를 가져올 때 이 메서드를 호출합니다.
    //예를 들어 주소록 앱에서는 총 주소 개수가 여기에 해당할 수 있습니다.
    @Override
    public int getItemCount() {
        return storedto.size();
    }

    // 리사이클러뷰 내용 모두 지우기
    public void removeAllItem(){
        storedto.clear();
    }

    // 특정 인덱스 항목 가져오기
    public StoreDTO getItem(int position) {
        return storedto.get(position);
    }

    // 특정 인덱스 항목 셋팅하기
    public void setItem(int position, StoreDTO item){
        storedto.set(position, item);
    }

    // arrayList 통째로 셋팅하기
    public void setItems(ArrayList<StoreDTO> arrayList){
        this.storedto = arrayList;
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {

        public ImageView storeImg;
        public TextView storeName;
        public Button fabt;




        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            storeImg = itemView.findViewById(R.id.faImg);
            storeName = itemView.findViewById(R.id.faTv);
            fabt = itemView.findViewById(R.id.fabt);


        }

        public void setItem(StoreDTO item){
            Glide.with(itemView).load(item.getImgpath()).into(storeImg);
            storeName.setText(item.getStore_name());

        }
    }
}






