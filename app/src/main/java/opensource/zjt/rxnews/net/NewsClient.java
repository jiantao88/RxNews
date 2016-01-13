package opensource.zjt.rxnews.net;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.BaseUrl;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by JianTao on 16/1/10.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public class NewsClient {
    TechnologyApi technologyApi;
    private OkHttpClient httpClient = new OkHttpClient();

    NewsClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Url.BASEURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        technologyApi = retrofit.create(TechnologyApi.class);
    }

    public boolean initNewhttpClient(OkHttpClient client) {
        return client.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("key", "09fc0a2397154952297ea4b7e6b2646a")
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });
    }

    public TechnologyApi getTechnologyApi() {
        return technologyApi;
    }
}
