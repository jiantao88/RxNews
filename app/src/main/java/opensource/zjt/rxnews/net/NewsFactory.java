package opensource.zjt.rxnews.net;

/**
 * Created by JianTao on 16/1/10.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public class NewsFactory {
    private static RxNewsApi rxNewsApi;

    public NewsFactory() {

    }

    public static RxNewsApi getRxNewsApi() {
        synchronized (NewsFactory.class) {
            if (rxNewsApi == null) {
                NewsClient newsClient = new NewsClient();
                rxNewsApi = newsClient.getRxNewsApi();
            }
            return rxNewsApi;
        }
    }
}
