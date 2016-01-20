package opensource.zjt.rxnews.net;

import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import retrofit.Response;

/**
 * Created by JianTao on 16/1/19.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public class NewsResponse<T> {
    private Response<T> mResponse;
    private final T mResult;
    private ResponseBody mErrorBody;

    public NewsResponse(Response<T> mResponse) {
        this.mResponse = mResponse;
        if (mResponse != null) {
            mResult = mResponse.body();
            mErrorBody = mResponse.errorBody();
        }else {
            mResult = null;
            mErrorBody = null;
        }
    }

    public T getmResult() {
        return mResult;
    }
    public String getErrorMessage() {
        if (mErrorBody != null) {
            try {
                return mErrorBody.string();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public boolean isSuccess() {
        return mResult != null;
    }

}
