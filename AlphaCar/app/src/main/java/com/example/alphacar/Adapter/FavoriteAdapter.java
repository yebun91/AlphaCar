package com.example.alphacar.Adapter;

import static com.example.alphacar.Common.CommonMethod.isNetworkConnected;
import static com.example.alphacar.LoginPage.loginDTO;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.alphacar.ATask.DetailSelect;
import com.example.alphacar.ATask.FavoriteDelect;
import com.example.alphacar.ATask.FavoriteSelect;
import com.example.alphacar.DTOS.FavoriteDTO;
import com.example.alphacar.DTOS.StoreDTO;
import com.example.alphacar.R;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ItemViewHolder>  {

    private static final String TAG = "main:FavoriteAdapter";

    Context mContext;
    ArrayList<FavoriteDTO> favoriteDTOS;
    FavoriteDelect favoriteDelect;

    int fav_number;


    public FavoriteAdapter(Context mContext, ArrayList<FavoriteDTO> favoriteDTOS) {
        this.mContext = mContext;
        this.favoriteDTOS = favoriteDTOS;
    }


    // dtos에 dto 추가하는 매소드
    public void addDto(FavoriteDTO dto){
        favoriteDTOS.add(dto);
    }

    // dtos의 특정위치에 dto를 삭제할수 있는 매소드
    public void delDto(int position){
        favoriteDTOS.remove(position);
    }

    // 리사이클러뷰 내용 모두 지우기
    public void removeAllItem(){
        favoriteDTOS.clear();
    }

    // 특정 인덱스 항목 가져오기
    public FavoriteDTO getItem(int position) {
        return favoriteDTOS.get(position);
    }

    // 특정 인덱스 항목 셋팅하기
    public void setItem(int position, FavoriteDTO item){
        favoriteDTOS.set(position, item);
    }

    // arrayList 통째로 셋팅하기
    public void setItems(ArrayList<FavoriteDTO> arrayList){
        this.favoriteDTOS = arrayList;
    }

    //데이터 세트 크기를 가져올 때 이 메서드를 호출합니다.
    //예를 들어 주소록 앱에서는 총 주소 개수가 여기에 해당할 수 있습니다.
    @Override
    public int getItemCount() {
        return favoriteDTOS.size();
    }

    //RecyclerView는 ViewHolder를 새로 만들어야 할 때마다 이 메서드를 호출합니다.
    //View를 생성하고 초기화하지만 뷰의 콘텐츠를 채우지는 않습니다.
    // ViewHolder가 아직 특정 데이터에 바인딩된 상태가 아니기 때문입니다.
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.favorite, parent, false);



        return new ItemViewHolder(itemView);
    }

    //RecyclerView는 ViewHolder를 데이터와 연결할 때 이 메서드를 호출합니다.
    //이 메서드는 적절한 데이터를 가져와서 그 데이터를 사용하여 뷰 홀더의 레이아웃을 채웁니다.
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder,@SuppressLint("RecyclerView") int position) {

        FavoriteDTO item = favoriteDTOS.get(position);
        holder.setItem(item);



        holder.del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNetworkConnected(mContext) == true){

                    favoriteDelect = new FavoriteDelect(item.getFav_number());
                    //listDetail = new ListDetail(store_number);
                    try {
                        favoriteDelect.execute().get();
                        //    Log.d(TAG, "onCreate: "+dto.getCustomer_email());
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {

                }
                // 특정위치에 있는 항목 지우기
                //dtos.remove(position);
                delDto(position);
                // 화면 갱신해주기
                notifyDataSetChanged();
            }
        });

    }








    public class ItemViewHolder extends RecyclerView.ViewHolder {

        public ImageView storeImg;
        public TextView storeName;
        public TextView fabt;
        public ImageButton del_btn;






        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            storeImg = itemView.findViewById(R.id.faImg);
            storeName = itemView.findViewById(R.id.faTv);
            fabt = itemView.findViewById(R.id.fabt);
            del_btn = itemView.findViewById(R.id.fadel);




        }

        public void setItem(FavoriteDTO item){
            Glide.with(itemView).load(item.getImgpath()).into(storeImg);
            storeName.setText(item.getStore_name());


        }
    }
}






