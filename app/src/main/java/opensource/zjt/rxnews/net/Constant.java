package opensource.zjt.rxnews.net;

/**
 * Created by JianTao on 16/1/10.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public class Constant {
    public static final String BASEURL = "http://api.huceo.com";
    public static final int PAZE_SIZE = 10;
    public enum GetNewsWay {
        INIT, UPDATA, LOADMORE;
    }

    public enum Result {
        SUCCESSS, FAIL, NORMAL;
    }
}
