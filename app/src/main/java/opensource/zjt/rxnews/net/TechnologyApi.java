package opensource.zjt.rxnews.net;

import opensource.zjt.rxnews.model.News;
import retrofit.http.GET;
import retrofit.http.HEAD;
import retrofit.http.Part;
import retrofit.http.Path;
import rx.Observable;
import rx.observers.Observers;

/**
 * Created by JianTao on 16/1/10.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public interface TechnologyApi {

    @GET("{num}")
    Observable<News> loadNews(@Path("num") String num);

    @GET("{num}/{page}")
    Observable<News> loadMoreNews(@Path("num") String num, @Path("page") String page);
}
