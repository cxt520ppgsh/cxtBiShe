package com.example.ryzen1400.abd.utils.mNetWork.mHttpResult;


import com.example.ryzen1400.abd.utils.mNetWork.Exception.ApiException;

import rx.functions.Func1;

/**
 * Created by Longgest Chan on 2017/1/10.
 */

//Func1传入map将HttpResult<T>转换为T
public class DefaultHttpResultFunc<T> implements Func1<DefaultHttpResult<T>, T> {
    @Override
    public T call(DefaultHttpResult<T> defaultHttpResult) {
        System.out.println(defaultHttpResult.getErr_code());
        if (defaultHttpResult.getErr_code() != 10000||defaultHttpResult==null) {
           /* if (defaultHttpResult.getErr_code()==10004
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
            {throw new ApiException(defaultHttpResult.getErr_code());}


        }
        return defaultHttpResult.getResult();
    }
}
