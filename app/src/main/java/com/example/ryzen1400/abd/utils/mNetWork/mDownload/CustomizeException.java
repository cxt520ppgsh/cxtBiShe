package com.example.ryzen1400.abd.utils.mNetWork.mDownload;

/**
 * Created by JokAr on 16/7/5.
 */
//超时的异常抛出
public class CustomizeException extends RuntimeException {

    public CustomizeException(String message, Throwable cause) {
        super(message, cause);
    }
}
