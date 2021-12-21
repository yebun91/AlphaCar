package com.example.alphacar.ATask;

import static com.example.alphacar.Common.CommonMethod.ipConfig;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ReviewInsert extends AsyncTask<Void, Void, String> {
    private static final String TAG = "main:ReviewInsert";

    // 생성자를 만들어서 데이터를 받는다
    int store_number;
    String email, rating, reviewTitle, reviewContent, imgPath;

    public ReviewInsert(int store_number, String email, String rating, String reviewTitle, String reviewContent, String imgPath) {
        this.store_number = store_number;
        this.email = email;
        this.rating = rating;
        this.reviewTitle = reviewTitle;
        this.reviewContent = reviewContent;
        this.imgPath = imgPath;

        Log.d(TAG, "ReviewInsert: " + imgPath);
    }

    String state = "";
    // 반드시 선언해야 할것들 : 무조건 해야함  복,붙
    HttpClient httpClient;       // 클라이언트 객체
    HttpPost httpPost;           // 클라이언트에 붙일 본문
    HttpResponse httpResponse;   // 서버에서의 응답받는 부분
    HttpEntity httpEntity;       // 응답내용

    // 실질적으로 일을하는 부분 : 접근 못함
    @Override
    protected String doInBackground(Void... voids) {
        try {
            // MultipartEntityBuilder 생성 : 무조건 해야함  복,붙
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            builder.setCharset(Charset.forName("UTF-8"));

            // 여기가 우리가 수정해야 하는 부분 : 서버로 보내는 데이터
            // builder 에 문자열 및 데이터 추가하기
            builder.addTextBody("store_number", String.valueOf(store_number), ContentType.create("Multipart/related", "UTF-8"));
            builder.addTextBody("email", email, ContentType.create("Multipart/related", "UTF-8"));
            builder.addTextBody("rating", rating, ContentType.create("Multipart/related", "UTF-8"));
            builder.addTextBody("reviewTitle", reviewTitle, ContentType.create("Multipart/related", "UTF-8"));
            builder.addTextBody("reviewContent", reviewContent, ContentType.create("Multipart/related", "UTF-8"));

            // 파일을 전송할때 추가하기
            if(imgPath.equals("")){
                builder.addTextBody("imgRealPath", imgPath, ContentType.create("Multipart/related", "UTF-8"));
            }else{
                builder.addPart("imgRealPath", new FileBody(new File(imgPath)));
            }

            // 전송
            // 전송 url : 우리가 수정해야 하는 부분
            String postURL = ipConfig + "/alphacar/android/review";
            // 그대로 사용  복,붙
            InputStream inputStream = null;
            httpClient = AndroidHttpClient.newInstance("Android");
            httpPost = new HttpPost(postURL);
            httpPost.setEntity(builder.build());
            httpResponse = httpClient.execute(httpPost);  // 보내고 응답 받는 부분
            httpEntity = httpResponse.getEntity();    // 응답내용을 저장
            inputStream = httpEntity.getContent();    // 응답내용을 inputStream 에 넣음

            // 응답 처리 : 문자열 형태
            BufferedReader bufferedReader = new
                    BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line + "\n");
            }
            state = stringBuilder.toString();

            inputStream.close();

        }catch (Exception e){
            e.getMessage();
        }finally {
            if(httpEntity != null){
                httpEntity = null;
            }
            if(httpResponse != null){
                httpResponse = null;
            }
            if(httpPost != null){
                httpPost = null;
            }
            if(httpClient != null){
                httpClient = null;
            }
        }

        return state;
    }

    // doInBackground 끝난후에 실행하는 부분
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
    }
}
