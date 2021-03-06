package com.example.ryzen1400.abd.utils.mNetWork.mUpLoad;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Longgest Chan on 2017/1/12.
 */

public class Request implements Parcelable {

    private int progress;
    private long currentFileSize;
    private long totalFileSize;

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public long getCurrentFileSize() {
        return currentFileSize;
    }

    public void setCurrentFileSize(long currentFileSize) {
        this.currentFileSize = currentFileSize;
    }

    public long getTotalFileSize() {
        return totalFileSize;
    }

    public void setTotalFileSize(long totalFileSize) {
        this.totalFileSize = totalFileSize;
    }


    //默认返回0
    @Override
    public int describeContents() {
        return 0;
    }




    public Request() {
    }

    //这里是读的顺序，要和下面写的顺序一致
    protected Request(Parcel in) {
        this.progress = in.readInt();
        this.currentFileSize = in.readLong();
        this.totalFileSize = in.readLong();
    }

    //这里是写的顺序，要和上面读的顺序一致
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.progress);
        dest.writeLong(this.currentFileSize);
        dest.writeLong(this.totalFileSize);
    }

    /**
     * 供外部类反序列化本类数组使用
     */
    public static final Creator<Request> CREATOR = new Creator<Request>() {
        @Override
        public Request createFromParcel(Parcel source) {
            return new Request(source);
        }

        @Override
        public Request[] newArray(int size) {
            return new Request[size];
        }
    };
}