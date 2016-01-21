package opensource.zjt.rxnews.event;

import opensource.zjt.rxnews.bean.NewsModel;
import opensource.zjt.rxnews.net.Constant;

/**
 * Created by JianTao on 16/1/20.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public class NewsEvent extends Event {
    private NewsModel news;
    private Constant.GetNewsWay getNewsWay;
    private String newsType;

    public NewsEvent(NewsModel news, Constant.GetNewsWay getNewsWay, String newsType) {
        this.news = news;
        this.getNewsWay = getNewsWay;
        this.newsType = newsType;
    }

    public NewsModel getNews() {
        return news;
    }

    public Constant.GetNewsWay getGetNewsWay() {
        return getNewsWay;
    }

    public String getNewsType() {
        return newsType;
    }
}
