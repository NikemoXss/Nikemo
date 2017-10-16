package com.ys.nikemo.okhttp;

import android.content.Context;

import com.ys.mysdk.okhttp.CommonOkhttpClient;
import com.ys.mysdk.okhttp.listener.DisposeDataHandle;
import com.ys.mysdk.okhttp.listener.DisposeDataListener;
import com.ys.mysdk.okhttp.request.CommonRequest;
import com.ys.mysdk.okhttp.request.RequestParams;
import com.ys.mysdk.okhttp.response.CommonJsonCallback;

/**
 * Created by Administrator on 2017/9/15.
 */

public class RequestCenter {
    public  static void login(Context context,String url,String username,String pwd,DisposeDataListener listener){
        RequestParams requestParams=new RequestParams();
        requestParams.put("username",username);
        requestParams.put("pwd",pwd);
        CommonOkhttpClient.sendRequest(context,CommonRequest.createPostRequest(url,requestParams,null),
                new CommonJsonCallback(new DisposeDataHandle(listener)));
    }


    public  static void login1(Context c, String url, String username, String pwd, DisposeDataListener listener){
//        RequestParams requestParams=new RequestParams();
//        requestParams.put("username",username);
//        requestParams.put("pwd",pwd);

        CommonOkhttpClient.sendRequest(c,CommonRequest.createGetRequest(url,null,null),
                new CommonJsonCallback(new DisposeDataHandle(listener)));
    }
}
