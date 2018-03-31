package com.example.ryzen1400.abd.utils.mNetWork.mHttpResult;

public class DefaultHttpResult<T> {
    private int err_code;
    private T result;
    public int getErr_code() {
        return err_code;
    }

    public void setErr_code(int err_code) {
        this.err_code = err_code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "DefaultHttpResult{" +
                "err_code=" + err_code +
                ", result=" + result +
                '}';
    }
}