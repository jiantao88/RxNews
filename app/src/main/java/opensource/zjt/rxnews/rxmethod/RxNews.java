package opensource.zjt.rxnews.rxmethod;

import com.socks.library.KLog;

import opensource.zjt.rxnews.base.AppService;
import opensource.zjt.rxnews.base.RxBus;
import opensource.zjt.rxnews.event.NewsEvent;
import opensource.zjt.rxnews.bean.NewsModel;
import opensource.zjt.rxnews.net.Constant;
import opensource.zjt.rxnews.net.NewsFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by JianTao on 16/1/10.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public class RxNews {
    public static final String KEY = "09fc0a2397154952297ea4b7e6b2646a";

    public static Subscription initNews(final String newsType) {
        Subscription subscription = Observable.create(new Observable.OnSubscribe<NewsModel>() {
            @Override
            public void call(Subscriber<? super NewsModel> subscriber) {
//                NewsModel newsModel = getCacheNew(newsType);
//                subscriber.onNext(newsModel);
//                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).subscribe(new Action1<NewsModel>() {
            @Override
            public void call(NewsModel news) {
                KLog.a("news", news.toString());
                NewsEvent newsEvent = new NewsEvent(news, Constant.GetNewsWay.INIT, newsType);
                if (news == null) {
                    newsEvent.setmEventResult(Constant.Result.FAIL);
                } else {
                    newsEvent.setmEventResult(Constant.Result.SUCCESSS);
                }
                RxBus.getInstance().send(newsEvent);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                KLog.a("newsError", throwable.toString());
                NewsEvent newsEvent = new NewsEvent(new NewsModel(), Constant.GetNewsWay.INIT, newsType);
                newsEvent.setmEventResult(Constant.Result.FAIL);
                RxBus.getInstance().send(newsEvent);
            }
        });
        return subscription;
    }

    public static Subscription updataNews(final String type, final int page) {
        Subscription subscription = NewsFactory.getRxNewsApi().loadNews(type, KEY, 10 + "", page + "")
                .subscribeOn(Schedulers.newThread()).doOnNext(new Action1<NewsModel>() {
                    @Override
                    public void call(NewsModel news) {

                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<NewsModel>() {
                    @Override
                    public void call(NewsModel news) {
                        KLog.a("news", news.toString());
                        NewsEvent newsEvent = new NewsEvent(news, Constant.GetNewsWay.UPDATA, type);
                        if (news == null) {
                            newsEvent.setmEventResult(Constant.Result.FAIL);
                        } else {
                            newsEvent.setmEventResult(Constant.Result.SUCCESSS);
                        }
                        RxBus.getInstance().send(newsEvent);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        KLog.a("newsError", throwable.toString());
                        NewsEvent newsEvent = new NewsEvent(new NewsModel(), Constant.GetNewsWay.UPDATA, type);
                        newsEvent.setmEventResult(Constant.Result.FAIL);
                        RxBus.getInstance().send(newsEvent);
                    }
                });
        return subscription;

    }

    public static void cacheNews(NewsModel newsModel, String type) {

    }

//    private static NewsModel getCacheNew(String type) {
//    }
}
