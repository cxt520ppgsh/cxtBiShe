package com.example.ryzen1400.abd.utils.mNetWork.mResponseBodyConverter;

import com.example.ryzen1400.abd.utils.mNetWork.Exception.ApiException;
import com.example.ryzen1400.abd.utils.mNetWork.mHttpResult.DefaultHttpResult;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;


import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by Charles on 2016/3/17.
 */
class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type type;

    GsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
           String response = value.string();
            //defaultHttpResult 只解析result字段
              System.out.println(response);
            DefaultHttpResult defaultHttpResult = gson.fromJson(response, DefaultHttpResult.class);
            if (defaultHttpResult.getErr_code() != 10000) {
             /*   if (defaultHttpResult.getErr_code()==10004
                        ||defaultHttpResult.getErr_code()==10005
                        ||defaultHttpResult.getErr_code()==10006
                        ||defaultHttpResult.getErr_code()==10007
                        ||defaultHttpResult.getErr_code()==10008
                        ||defaultHttpResult.getErr_code()==10009
                        ||defaultHttpResult.getErr_code()==10010
                        ||defaultHttpResult.getErr_code()==10011
                        ||defaultHttpResult.getErr_code()==10012
                        ||defaultHttpResult.getErr_code()==10013
                        ||defaultHttpResult.getErr_code()==10014
                        ||defaultHttpResult.getErr_code()==10015
                        ||defaultHttpResult.getErr_code()==10016
                        ||defaultHttpResult.getErr_code()==10017
                        ||defaultHttpResult.getErr_code()==10018
                        ||defaultHttpResult.getErr_code()==10019
                        ||defaultHttpResult.getErr_code()==10020
                        ||defaultHttpResult.getErr_code()==10021
                        ||defaultHttpResult.getErr_code()==10038
                        ||defaultHttpResult.getErr_code()==10040
                        ||defaultHttpResult.getErr_code()==10041
                        ||defaultHttpResult.getErr_code()==10042
                        ||defaultHttpResult.getErr_code()==10043
                        ||defaultHttpResult.getErr_code()==10044
                        ||defaultHttpResult.getErr_code()==10045
                        )*/
                throw new ApiException(defaultHttpResult.getErr_code());
            }
            return gson.fromJson(response, type);
    }
}
