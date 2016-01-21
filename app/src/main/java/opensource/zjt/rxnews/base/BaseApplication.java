package opensource.zjt.rxnews.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by JianTao on 16/1/21.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public class BaseApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        AppService.getInstance().initService();
    }

    public static Context getmContext() {
        return mContext;
    }
}
