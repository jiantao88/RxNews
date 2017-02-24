package opensource.zjt.rxnews.net;

/**
 * Created by JianTao on 16/1/10.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public class Constant {
    public static final String BASEURL = "https://api.tianapi.com";
    public static final int PAZE_SIZE = 10;
    public static final String NEWSDETAIL = "newsdetal";
    public static final String NEWSTYPE_KEJI = "keji";
    public static final String NEWSTYPE_TIYU = "tiyu";
    public static final String NEWSTYPE_HUABIAN = "huabian";
    public static final String NEWSTYPE_GUOJI = "world";
    public static final String NEWSTYPE_SHEHUI = "social";
    public static final String IMAGES_URL = "http://api.laifudao.com/open/tupian.json";

    public enum GetNewsWay {
        INIT, UPDATA, LOADMORE;
    }

    public enum Result {
        SUCCESSS, FAIL, NORMAL;
    }
}
