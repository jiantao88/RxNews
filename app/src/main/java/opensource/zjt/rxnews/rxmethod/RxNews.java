package opensource.zjt.rxnews.rxmethod;

import com.socks.library.KLog;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import opensource.zjt.rxnews.model.News;
import opensource.zjt.rxnews.net.NewsFactory;
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by JianTao on 16/1/10.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public class RxNews {


    public static Subscription updataNews(int num) {
        Subscription subscription = NewsFactory.getTechnologyApi().loadNews("09fc0a2397154952297ea4b7e6b2646a")
                .subscribeOn(Schedulers.newThread()).doOnNext(new Action1<News>() {
                    @Override
                    public void call(News news) {
                        KLog.a("news", news.toString());
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<News>() {
                    @Override
                    public void call(News news) {
                        KLog.a("news", news.toString());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        KLog.a("newsError", throwable.toString());
                    }
                });
        return subscription;

    }
}
