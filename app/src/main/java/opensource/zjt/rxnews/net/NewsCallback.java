package opensource.zjt.rxnews.net;


import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by JianTao on 16/1/19.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public abstract class NewsCallback<T> implements Callback<T> {

    @Override
    public void onResponse(Response<T> response, Retrofit retrofit) {
        onCallback(new NewsResponse<T>(response));
    }

    @Override
    public void onFailure(Throwable t) {
        NewsResponse<T> response = new NewsResponse<>(null);
        onCallback(response);
    }

    public abstract void onCallback(NewsResponse<T> response);
}
