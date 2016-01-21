package opensource.zjt.rxnews.view;

import java.util.List;

import opensource.zjt.rxnews.bean.NewsModel;

/**
 * Created by JianTao on 16/1/21.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public interface NewsView {
    void addNew(List<NewsModel.NewslistEntity> list);

    void showProgress();

    void hideProgress();

    void showLoadFail();
}
