package com.bear.customerview.http;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
//import okhttp3.Interceptor;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;

/**
 * Created by yixiaofei on 2017/2/24 0024.
 */

public class OkHttpManager {

//    private static OkHttpClient mOkHttpClient;

    /**
     * 获取OkHttpClient对象
     *
     * @return
     */
//    public static OkHttpClient getOkHttpClient() {
//        if (null == mOkHttpClient) {
//            /*****调试****/
//            mOkHttpClient = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).addNetworkInterceptor(new StethoInterceptor()).addInterceptor(new RequestInterceptor()).build();
//            /****正式**/
////            mOkHttpClient = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).addInterceptor(new RequestInterceptor()).readTimeout(30, TimeUnit.SECONDS).build();
//        }
//        return mOkHttpClient;
//    }
//    private static class RequestInterceptor implements Interceptor {
//        @Override
//        public Response intercept(Interceptor.Chain chain) throws IOException {
//            Request request = chain.request()
//                    .newBuilder()
//                    .addHeader("Content-Type", "text/html; charset=UTF-8")
////                    .addHeader("Accept-Encoding", "*")
//                    .addHeader("Content-Length","0")
//                    .addHeader("Connection", "keep-alive")
//                    .addHeader("Accept","application/json")
//                    .addHeader("Access-Control-Allow-Origin", "*")
//                    .addHeader("Access-Control-Allow-Headers", "X-Requested-With")
//                    .addHeader("Vary", "Accept-Encoding")
////                    .addHeader("Cookie", "add cookies here")
//                    .build();
//            return chain.proceed(request);
//        }
//    }
}
