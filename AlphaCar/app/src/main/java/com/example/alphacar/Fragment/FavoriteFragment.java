package com.example.alphacar.Fragment;
import static com.example.alphacar.Common.CommonMethod.isNetworkConnected;
import static com.example.alphacar.LoginPageActivity.loginDTO;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alphacar.ATask.FavoriteSelect;
import com.example.alphacar.Adapter.FavoriteAdapter;
import com.example.alphacar.DTOS.FavoriteDTO;
import com.example.alphacar.MainActivity;
import com.example.alphacar.R;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class FavoriteFragment extends Fragment {
    MainActivity mActivity;
    ImageButton imageButton;
    ArrayList<FavoriteDTO> arrayList;
    FavoriteDTO dto;
    FavoriteSelect favoriteSelect;
    RecyclerView recyclerView;
    FavoriteAdapter favoriteAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.favoriteinside,
                container,false);
        mActivity = (MainActivity) getActivity();
        arrayList = new ArrayList<>();
        if(loginDTO != null) {
            if (isNetworkConnected(mActivity) == true) {
                favoriteSelect = new FavoriteSelect(dto, arrayList);
                //listDetail = new ListDetail(store_number);
                try {
                    favoriteSelect.execute().get();
                    //    Log.d(TAG, "onCreate: "+dto.getCustomer_email());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(mActivity, "인터넷이 연결되어 있지 않습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        }
        favoriteAdapter = new FavoriteAdapter(mActivity.getApplicationContext(), arrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                mActivity.getApplicationContext(), RecyclerView.VERTICAL, false
        );
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(favoriteAdapter);


        return rootView;
    }
}
