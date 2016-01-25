package opensource.zjt.rxnews.net;

import opensource.zjt.rxnews.bean.NewsModel;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by JianTao on 16/1/10.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public interface RxNewsApi {

    @GET("/{type}/other")
    Observable<NewsModel> loadNews(@Path("type")String type,
                                   @Query("key") String key,
                                   @Query("num") String num,
                                   @Query("page")String page);
}
