package com.example.ryzen1400.abd.utils.mNetWork.mApi;

import com.example.ryzen1400.abd.model.bean.ErrorCode;
import com.example.ryzen1400.abd.model.bean.PriceItem;
import com.example.ryzen1400.abd.model.bean.User;
import com.example.ryzen1400.abd.utils.mNetWork.mHttpResult.DefaultHttpResult;

import java.util.ArrayList;


import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Longgest Chan on 2017/1/9.
 */

public interface NetWorkApi {
    //http://shoubing.gzinterest.com/index.php?g=Platform&m=API&a=memberLogin&token=
      //&a=[接口名] &token=[token字符串]
    //参数phone password
    @FormUrlEncoded
    @POST("index.php?g=Platform&m=API")
    Observable<DefaultHttpResult<User>> register(@Query("a") String a, @Query("token") String token, @Field("phone") String phone, @Field("password") String password, @Field("num") String num, @Field("nickname") String nickname);



    @FormUrlEncoded
    @POST("index.php?g=Platform&m=API")
    Observable<ErrorCode> upUseRecord(@Query("a") String a,
                                      @Query("token") String token,
                                      @Query("cache_token") String cache_token,
                                      @Field("uid") String uid,
                                      @Field("type") String type
    );
    @FormUrlEncoded
    @POST("index.php?g=Platform&m=API")
    Observable<DefaultHttpResult<PriceItem>> getPriceFragmentData();
}
