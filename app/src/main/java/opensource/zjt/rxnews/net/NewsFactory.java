package opensource.zjt.rxnews.net;

/**
 * Created by JianTao on 16/1/10.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public class NewsFactory {
    private static TechnologyApi technologyApi;

    public NewsFactory() {

    }

    public static TechnologyApi getTechnologyApi() {
        synchronized (NewsFactory.class) {
            if (technologyApi == null) {
                NewsClient newsClient = new NewsClient();
                technologyApi = newsClient.getTechnologyApi();
            }
            return technologyApi;
        }
    }
}
