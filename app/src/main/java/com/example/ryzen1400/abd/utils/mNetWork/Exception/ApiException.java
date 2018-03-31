package com.example.ryzen1400.abd.utils.mNetWork.Exception;

/**
 * Created by liukun on 16/3/10.
 */
public class ApiException extends RuntimeException {

    public static final int SUCCEED = 10000;
    public static final int PARAMTERS_INVAILD=10002;
    public static final int RIGISTER_FAILD = 10003;
    public static final int PNONE_NULL = 10004;
    public static final int PASSWORD_FAILD=10006;
    public static final int PHONE_UNRIGIST=10007;
    public static final int PHONE_REIGISTED=10008;
    public static final int REDO_IN_THIEE_MINUTE=10009;
    public static final int PASSWORD_ERROR=10010;
    public static final int USER_NULL=10013;
    public static final int PHONE_UNRAW=10017;
    public static final int WORD_NOT_INFRONT_5TO16_LENGTH=10018;
    public static final int TOKEN_ERROR = 10019;
    public static final int SYSTEM_ERROR=10025;
    public static final int UP_PICTURE_FAILD=10029;
    public static final int SHOLD_RELOGIN=10032;
    public static final int VCODE_FAILD=10035;
    public static final int VCODE_SERVICE_ERROR=10036;
    public static final int USER_BESTOPED=10040;
    public static final int GET_VCODE_FIRST=10041;
    public static final int CHILD_PASSWORD_SETTING_FAILD=10042;
    public static final int SET_CHILD_PASSWORD_FIRST=10045;
    public static final int BATTLE_ID_NULL=10046;


    public ApiException(int resultCode) {
        this(getApiExceptionMessage(resultCode));
    }

    public ApiException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，在显示给用户
     * @param code
     * @return
     */
    private static String getApiExceptionMessage(int code){
        String message =  "请检查网络连接";
        switch (code) {
            case TOKEN_ERROR:
                message = "token错误";
                break;
            case PNONE_NULL:
                message = "手机为空";
                break;
            case PARAMTERS_INVAILD:
                message = "参数无效";
                break;
            case PASSWORD_ERROR:
                message = "原密码错误";
                break;
            case    RIGISTER_FAILD :
                message="注册失败";
                break;
            case PASSWORD_FAILD:
                message="密码错误";
                break;
            case GET_VCODE_FIRST:
                message="请先获取验证码";
                break;
            case  PHONE_UNRIGIST:
                message= "该手机未被注册";
                break;
            case     PHONE_REIGISTED:
                message="该手机已被注册";
                break;
            case   REDO_IN_THIEE_MINUTE:
                message="3分钟后重试";
                break;
            case   USER_NULL:
                message="没有该用户";
                break;
            case  PHONE_UNRAW:
                message="手机号不合法";
                break;
            case  WORD_NOT_INFRONT_5TO16_LENGTH:
                message="密码必需为字母开头的5-16位字母数字下划线!";
                break;

            case     SYSTEM_ERROR:
                message="系统错误";
                break;
            case  UP_PICTURE_FAILD:
                message="图片上传失败";
                break;
            case  SHOLD_RELOGIN:
               message="需要重新登陆";
               break;
            case  VCODE_FAILD:
                message="验证码请求发送失败";
                break;
            case CHILD_PASSWORD_SETTING_FAILD:
                message="儿童锁密码设置失败";
                break;
            case   VCODE_SERVICE_ERROR:
                message="验证码服务器响应错误";
                break;
            case  USER_BESTOPED:
                message="该账户被停用";
                break;
            case  BATTLE_ID_NULL:
                message="battle_id为空";
                break;
            case  SET_CHILD_PASSWORD_FIRST:
                message="请先设置儿童锁密码";
                break;
            default:
                message = "请检查网络连接";

        }
        return message;
    }
}

