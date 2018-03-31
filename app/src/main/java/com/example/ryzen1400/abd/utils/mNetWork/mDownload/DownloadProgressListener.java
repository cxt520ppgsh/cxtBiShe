package com.example.ryzen1400.abd.utils.mNetWork.mDownload;

/**
 * Created by Longgest Chan on 2017/1/12.
 */

public interface DownloadProgressListener {
    void update(long bytesRead, long contentLength, boolean done);
}
