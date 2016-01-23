package opensource.zjt.rxnews.model;

import opensource.zjt.rxnews.base.AppService;
import opensource.zjt.rxnews.net.Constant;
import opensource.zjt.rxnews.rxmethod.RxNews;

/**
 * Created by JianTao on 16/1/21.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public class NewsModelImpl implements INewsModel{

    @Override
    public void loadNews(int type, int num) {
        RxNews.updataNews(getID(type), num);
    }
    private String getID(int type) {
        String id;
        switch (type) {
            case 0:
                id = Constant.NEWSTYPE_KEJI;
                break;
            case 1:
                id = Constant.NEWSTYPE_GUOJI;
                break;
            case 2:
                id = Constant.NEWSTYPE_SHEHUI;
                break;
            case 3:
                id = Constant.NEWSTYPE_TIYU;
                break;
            default:
                id = Constant.NEWSTYPE_KEJI;
                break;
        }
        return id;
    }

}
