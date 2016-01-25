package opensource.zjt.rxnews.presenter;


import opensource.zjt.rxnews.base.RxBus;
import opensource.zjt.rxnews.event.NewsEvent;
import opensource.zjt.rxnews.model.INewsModel;
import opensource.zjt.rxnews.model.NewsModelImpl;
import opensource.zjt.rxnews.net.Constant;
import opensource.zjt.rxnews.view.NewsView;
import rx.functions.Action1;

/**
 * Created by JianTao on 16/1/21.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public class NewsPresenterImpl implements NewsPresenter {

    private static final String TAG = "NewsPresenterImpl";
    private NewsView newsView;
    private INewsModel newsModel;

    public NewsPresenterImpl(NewsView newsView) {
        this.newsView = newsView;
        this.newsModel = new NewsModelImpl();
        RxBus.getInstance().toObservable().subscribe(newsEventAction);
    }

    @Override
    public void loadNews(int type, int pageNum) {
        if (pageNum == 0) {
            newsView.showProgress();
        }
        newsModel.loadNews(type, pageNum);
    }

    private Action1<? super Object> newsEventAction = new Action1<Object>() {
        @Override
        public void call(Object o) {
            if (o instanceof NewsEvent) {
                if (((NewsEvent) o).getmEventResult().equals(Constant.Result.SUCCESSS)) {
                    if (newsView != null) {
                        newsView.hideProgress();
                        newsView.addNew(((NewsEvent) o).getNews().getNewslist());
                    }
                } else if (((NewsEvent) o).getmEventResult().equals(Constant.Result.FAIL)) {
                    if (newsView != null) {
                        newsView.hideProgress();
                        newsView.showLoadFail();
                    }
                }
            }
        }
    };
}
