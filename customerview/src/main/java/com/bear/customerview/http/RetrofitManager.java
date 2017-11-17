package com.bear.customerview.http;


import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by yixiaofei on 2017/2/24 0024.
 */

public class RetrofitManager {
    //请求域名
    private static final String BASE_URL = "http://yizhiliao.org/api/";

    private static Retrofit mRetrofit;

    /**
     * 获取RetrofitServiceManager
     * @return
     */
    public synchronized static Retrofit getRetrofit(){
        if(mRetrofit==null){
            // 创建Retrofit
            mRetrofit = new Retrofit.Builder()
//                    .client(OkHttpManager.getOkHttpClient())
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
//            Logger.d("request url is "+mRetrofit.);
        }
        return mRetrofit;
    }

    /**
     * 获取对应的Service
     * @param service Service 的 class
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service){
        return mRetrofit.create(service);
    }
}
