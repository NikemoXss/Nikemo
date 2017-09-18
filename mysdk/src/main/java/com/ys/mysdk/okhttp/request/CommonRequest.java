package com.ys.mysdk.okhttp.request;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Request;

/**
 * Created by Administrator on 2017/9/15.
 * 接受请求参数   为我们生成request对象
 */

public class CommonRequest {

    /**
     * @param url
     * @param params
     * @return 返回一个创建好的post类型的request对象
     */
    public static Request createPostRequest(String url, RequestParams params, RequestParams headers) {
        FormBody.Builder mFormBodyBuilder = new FormBody.Builder();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                //将请求参数遍历添加到我们的请求构建中
                mFormBodyBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        //添加请求头
        Headers.Builder mHeaderBuild = new Headers.Builder();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.urlParams.entrySet()) {
                mHeaderBuild.add(entry.getKey(), entry.getValue());
            }
        }
        //通过请求构建类的build方法获取真正的请求体对象
        FormBody mformBody = mFormBodyBuilder.build();
        Headers mHeader = mHeaderBuild.build();
        return new Request.Builder().url(url).headers(mHeader).post(mformBody).build();
    }

    /**
     * @param url
     * @param params
     * @return 返回一个创建好的get类型的request对象
     */
    public static Request createGetRequest(String url, RequestParams params, RequestParams headers) {

        StringBuilder urlBuilder = new StringBuilder(url).append("?");
        if (params != null) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                //将请求参数遍历添加到我们的请求构建中
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        //添加请求头
        Headers.Builder mHeaderBuild = new Headers.Builder();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.urlParams.entrySet()) {
                mHeaderBuild.add(entry.getKey(), entry.getValue());
            }
        }
        Headers headers1 = mHeaderBuild.build();
        return new Request.Builder().url(urlBuilder.substring(0, urlBuilder.length() - 1)).headers(headers1).get().build();
    }
}
