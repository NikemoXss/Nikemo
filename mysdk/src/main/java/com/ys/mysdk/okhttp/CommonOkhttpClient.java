package com.ys.mysdk.okhttp;

import android.content.Context;

import com.ys.mysdk.okhttp.https.HttpsUtils;
import com.ys.mysdk.okhttp.response.CommonJsonCallback;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2017/9/15.
 *
 * @function 请求的发送 请求参数的配置  https的支持
 */

public class CommonOkhttpClient {

    private static final int TIME_OUT = 30;//超时参数
    private static OkHttpClient mOkhttpClient;
//    public static Context context = null;

    static {
//        OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient().newBuilder();
//        okhttpClientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
//        okhttpClientBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
//        okhttpClientBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
//
//        okhttpClientBuilder.followRedirects(true);
//        //http支持
//        okhttpClientBuilder.hostnameVerifier(new HostnameVerifier() {
//            @Override
//            public boolean verify(String s, SSLSession sslSession) {
//                return true;
//            }
//        });
//        InputStream is = null;
//        try {
//             is = context.getAssets().open("taxca.p7b");
//        } catch (
//                Exception e
//                ) {
//
//        }
//        InputStream [] streams=new InputStream[]{is};
//        InputStream bksFile=null;
//        okhttpClientBuilder.sslSocketFactory(HttpsUtils.getSslSocketFactory(streams,bksFile,""), HttpsUtils.initTrustManager());
//
//        //生成mOkhttpClient对象
//        mOkhttpClient = okhttpClientBuilder.build();

    }

    /**
     * 发送具体的http/https请求
     *
     * @param request
     * @param commcallback
     * @return call
     */
    public static Call sendRequest(Context context,Request request, CommonJsonCallback commcallback) {

        OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient().newBuilder();
        okhttpClientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okhttpClientBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        okhttpClientBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);

        okhttpClientBuilder.followRedirects(true);
        //http支持
        okhttpClientBuilder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        });

        //AssetManager.open(String filename)，返回的是一个InputSteam类型的字节流，这里的filename必须是文件比如（aa.txt；img/semll.jpg），而不能是文件夹。
        InputStream is = null;
        try {
           is= context.getAssets().open("taxca.p7b");
        } catch (Exception e) {
            e.printStackTrace();
        }
        InputStream [] streams=new InputStream[]{is};
        InputStream bksFile=null;
        okhttpClientBuilder.sslSocketFactory(HttpsUtils.getSslSocketFactory(streams,bksFile,""), HttpsUtils.initTrustManager());

        //生成mOkhttpClient对象
        mOkhttpClient = okhttpClientBuilder.build();

        Call call = mOkhttpClient.newCall(request);
        call.enqueue(commcallback);
        return call;
    }

}
