package com.example.ryzen1400.abd.utils.mNetWork.mUpLoad;

/**
 * Created by Longgest Chan on 2017/1/12.
 */

public interface ProgressRequestListener {
    void onRequestProgress(long bytesWritten, long contentLength, boolean done);
}
