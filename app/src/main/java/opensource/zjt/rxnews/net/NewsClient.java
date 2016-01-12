package opensource.zjt.rxnews.net;

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
    NewsClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Url.BASEURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        technologyApi = retrofit.create(TechnologyApi.class);
    }

    public TechnologyApi getTechnologyApi() {
        return technologyApi;
    }
}
