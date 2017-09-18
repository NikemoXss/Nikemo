package com.ys.nikemo.okhttp;

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
    public  static void login(String url,String username,String pwd,DisposeDataListener listener){
        RequestParams requestParams=new RequestParams();
        requestParams.put("username",username);
        requestParams.put("pwd",pwd);
        CommonOkhttpClient.sendRequest(CommonRequest.createPostRequest(url,requestParams,null),
                new CommonJsonCallback(new DisposeDataHandle(listener)));
    }
}
