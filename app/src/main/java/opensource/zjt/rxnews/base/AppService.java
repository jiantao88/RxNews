package opensource.zjt.rxnews.base;

import com.google.gson.Gson;
import com.rxnews.greendao.DBHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import opensource.zjt.rxnews.net.NewsFactory;
import opensource.zjt.rxnews.net.RxNewsApi;
import opensource.zjt.rxnews.rxmethod.RxNews;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by JianTao on 16/1/20.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public class AppService {
    private static AppService instance = new AppService();
    private static RxNewsApi rxNewsApi;
    private static ExecutorService sSingleThreadExecutor;
    private static DBHelper dbHelper;
    private static Gson sGson;

    private Map<Integer, CompositeSubscription> compositeSubscriptionMap;

    public AppService() {
    }

    public void initService() {
        compositeSubscriptionMap = new HashMap<>();
        sGson=new Gson();
        sSingleThreadExecutor = Executors.newSingleThreadExecutor();
        sSingleThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                rxNewsApi = NewsFactory.getRxNewsApi();
                dbHelper = DBHelper.getInstance(BaseApplication.getmContext());
            }
        });
    }

    public static Gson getsGson() {
        return sGson;
    }

    public void addCompositeSub(int taskId) {
        CompositeSubscription compositeSubscription;
        if (compositeSubscriptionMap.get(taskId) == null) {
            compositeSubscription = new CompositeSubscription();
            compositeSubscriptionMap.put(taskId, compositeSubscription);
        }
    }

    public static DBHelper getDbHelper() {
        return dbHelper;
    }

    public void removeCompositeSub(int taskId) {
        CompositeSubscription compositeSubscription;
        if (compositeSubscriptionMap != null && compositeSubscriptionMap.get(taskId) != null) {
            compositeSubscription = compositeSubscriptionMap.get(taskId);
            compositeSubscription.unsubscribe();
            compositeSubscriptionMap.remove(taskId);
        }
    }

    public CompositeSubscription getCompositeSubscription(int taskId) {
        CompositeSubscription compositeSubscription;
        if (compositeSubscriptionMap.get(taskId) == null) {
            compositeSubscription = new CompositeSubscription();
            compositeSubscriptionMap.put(taskId, compositeSubscription);
        } else {
            compositeSubscription = compositeSubscriptionMap.get(taskId);
        }
        return compositeSubscription;
    }

    public void initNews(int taskId, String type) {
        getCompositeSubscription(taskId).add(RxNews.initNews(type));
    }

    public void updataNews(int taskId, String type) {
        getCompositeSubscription(taskId).add(RxNews.updataNews(type, 1));
    }

    public Map<Integer, CompositeSubscription> getCompositeSubscriptionMap() {
        return compositeSubscriptionMap;
    }

    public static AppService getInstance() {
        return instance;
    }

    public static RxNewsApi getRxNewsApi() {
        return rxNewsApi;
    }

    public static ExecutorService getsSingleThreadExecutor() {
        return sSingleThreadExecutor;
    }

}
