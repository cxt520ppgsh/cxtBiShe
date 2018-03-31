package com.example.ryzen1400.abd.utils.mNetWork.mDownload;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Longgest Chan on 2017/1/12.
 */




/**
 * 我们还需要一个Helper类，对上传或者下载进行监听设置。文件的上传其实很简单，
 * 将我们的原始RequestBody和监听器 传入，返回我们的包装的ProgressRequestBody ，
 * 使用包装后的ProgressRequestBody 进行请求即可，但是文件的下载呢，OkHttp给我们返回的是Response，
 * 我们如何将我们包装的ProgressResponseBody设置进去呢，答案之前已经说过了，就是拦截器，具体见代码吧
 */
public class DownloadProgressInterceptor implements Interceptor {

    private DownloadProgressListener listener;

    public DownloadProgressInterceptor(DownloadProgressListener listener) {
        this.listener = listener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

      /*  Request oldRequest = chain.request();
        // 添加新的参数
        HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
                .newBuilder()
                .scheme(oldRequest.url().scheme())
                .host(oldRequest.url().host())
                .addQueryParameter(MarvelService.PARAM_API_KEY, mApiKey)
                .addQueryParameter(MarvelService.PARAM_TIMESTAMP, MarvelApiUtils.getUnixTimeStamp())
                .addQueryParameter(MarvelService.PARAM_HASH, marvelHash);

        // 新的请求
        Request newRequest = oldRequest.newBuilder()
                .method(oldRequest.method(), oldRequest.body())
                .url(authorizedUrlBuilder.build())
                .build();

   return chain.proceed(newRequest);

      //实现缓存
        Response originalResponse = chain.proceed(chain.request());
        return originalResponse.newBuilder()
                .removeHeader("Pragma")//Pragma:no-cache。在HTTP/1.1协议中，它的含义和Cache-Control:no-cache相同。为了确保缓存生效
                .header("Cache-Control", String.format("max-age=%d", maxCacheAge))//添加缓存请求头
                .build();
    }
*/

      //下载返回的是response
        Response originalResponse = chain.proceed(chain.request());
        return originalResponse.newBuilder()
                .body(new DownloadProgressResponseBody(originalResponse.body(), listener))
                .build();
    }
}
