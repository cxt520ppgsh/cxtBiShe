package com.example.ryzen1400.abd.utils.mNetWork.mDownload;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * Created by Longgest Chan on 2017/1/12.
 */

/**
 * 类似装饰器，我们对原始的ResponseBody 进行了一层包装。并在其读取数据的时候设置了回调，
 * 回调的接口由构造函数传入，此外构造函数还传入了原始的ResponseBody，当系统内部调用了ResponseBody 的source方法的时候，
 * 返回的便是我们包装后的Source。然后我们还重写了几个方法调用原始的ResponseBody对应的函数返回结果。
 */
    public class DownloadProgressResponseBody extends ResponseBody {

        private ResponseBody responseBody;
        private DownloadProgressListener progressListener;
        private BufferedSource bufferedSource;

        public DownloadProgressResponseBody(ResponseBody responseBody,
                                            DownloadProgressListener progressListener) {
            this.responseBody = responseBody;
            this.progressListener = progressListener;
        }

        @Override
        public MediaType contentType() {
            return responseBody.contentType();
        }

        @Override
        public long contentLength() {
            return responseBody.contentLength();
        }


        //当系统内部调用了ResponseBody 的source方法的时候，返回的便是我们包装后的Source
        @Override
        public BufferedSource source() {
            if (bufferedSource == null) {
                bufferedSource = Okio.buffer(source(responseBody.source()));
            }
            return bufferedSource;
        }

    //当系统内部调用了ResponseBody 的source方法的时候，返回的便是我们包装后的Source
        private Source source(Source source) {
            return new ForwardingSource(source) {
                long totalBytesRead = 0L;
                @Override
                public long read(Buffer sink, long byteCount) throws IOException {
                    long bytesRead = super.read(sink, byteCount);
              //增加当前读取的字节数，如果读取完成了bytesRead会返回-1
                    totalBytesRead += bytesRead != -1 ? bytesRead : 0;
                    if (null != progressListener) {
                       //如果文件大小未知 contentLength 会始终返回-1
                        progressListener.update(totalBytesRead, responseBody.contentLength(), bytesRead == -1);
                    }
                    return bytesRead;
                }
            };

        }
    }

