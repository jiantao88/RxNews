package opensource.zjt.rxnews.presenter;

import android.content.Context;

import opensource.zjt.rxnews.view.NewsDetailView;

/**
 * Created by JianTao on 16/1/21.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public class NewsDetailPresenterImpl implements NewsDetailPresenter {
    private Context context;
    private NewsDetailView newsDetailView;

    public NewsDetailPresenterImpl(Context context, NewsDetailView newsDetailView) {
        this.context = context;
        this.newsDetailView = newsDetailView;
    }

    @Override
    public void loadNewsDetail(String url) {
        newsDetailView.showProgress();
        newsDetailView.showNewsDetailContent(url);
    }
}
