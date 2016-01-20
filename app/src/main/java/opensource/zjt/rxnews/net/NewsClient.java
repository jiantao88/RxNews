package opensource.zjt.rxnews.net;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import retrofit.GsonConverterFactory;
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
            Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASEURL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            rxNewsApi = retrofit.create(RxNewsApi.class);
        }
        return rxNewsApi;
    }
}
