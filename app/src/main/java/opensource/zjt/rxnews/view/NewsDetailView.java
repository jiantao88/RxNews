package opensource.zjt.rxnews.view;

/**
 * Created by JianTao on 16/1/21.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public interface NewsDetailView {
    void showNewsDetailContent(String detailurl);

    void showProgress();

    void hideProgress();
}
