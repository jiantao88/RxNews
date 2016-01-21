package opensource.zjt.rxnews.net;

import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.io.IOException;

import opensource.zjt.rxnews.base.BaseApplication;
import opensource.zjt.rxnews.utils.AppUtils;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by JianTao on 16/1/10.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public class NewsClient {
    private static RxNewsApi rxNewsApi;

    NewsClient() {
    }

    public RxNewsApi getRxNewsApi() {
        if (rxNewsApi == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient httpClient = new OkHttpClient();
            httpClient.interceptors().add(logging);
            httpClient.interceptors().add(interceptor);
            Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASEURL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            rxNewsApi = retrofit.create(RxNewsApi.class);
        }
        return rxNewsApi;
    }
    private Interceptor interceptor = new Interceptor() {
        @Override
        public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!AppUtils.isNetworkReachable(BaseApplication.getmContext())){
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }
            com.squareup.okhttp.Response response = chain.proceed(request);
            if (AppUtils.isNetworkReachable(BaseApplication.getmContext())){
                int maxAge = 60 * 60;
                response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            }else {
                int maxStale = 60 * 60 * 24 * 7; //  设置超时为一周
                response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
            return response;
        }
    };
}
