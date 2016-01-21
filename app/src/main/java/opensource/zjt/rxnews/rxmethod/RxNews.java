package opensource.zjt.rxnews.rxmethod;

import com.socks.library.KLog;

import opensource.zjt.rxnews.base.RxBus;
import opensource.zjt.rxnews.event.NewsEvent;
import opensource.zjt.rxnews.bean.NewsModel;
import opensource.zjt.rxnews.net.Constant;
import opensource.zjt.rxnews.net.NewsFactory;
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

    public static Subscription updataNews(final int num) {
        Subscription subscription = NewsFactory.getRxNewsApi().loadNews(KEY, num + "")
                .subscribeOn(Schedulers.newThread()).doOnNext(new Action1<NewsModel>() {
                    @Override
                    public void call(NewsModel news) {
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<NewsModel>() {
                    @Override
                    public void call(NewsModel news) {
                        KLog.a("news", news.toString());
                        NewsEvent newsEvent = new NewsEvent(news, Constant.GetNewsWay.INIT, num+"");
                        if (news==null){
                            newsEvent.setmEventResult(Constant.Result.FAIL);
                        }
                        RxBus.getInstance().send(newsEvent);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        KLog.a("newsError", throwable.toString());
                        NewsEvent newsEvent= new NewsEvent(new NewsModel(), Constant.GetNewsWay.INIT,num+"");
                        newsEvent.setmEventResult(Constant.Result.FAIL);
                        RxBus.getInstance().send(newsEvent);
                    }
                });
        return subscription;

    }
}
