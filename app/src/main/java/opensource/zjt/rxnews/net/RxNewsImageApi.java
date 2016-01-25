package opensource.zjt.rxnews.net;

import opensource.zjt.rxnews.bean.ImageModel;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by JianTao on 16/1/25.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public interface RxNewsImageApi {
    @GET("/meinv/other")
    Call<ImageModel> loadImage(
            @Query("key") String key,
            @Query("num") int num,
            @Query("page") int page);
}
