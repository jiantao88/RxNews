package opensource.zjt.rxnews.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by JianTao on 16/1/21.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public class BaseActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        AppService.getInstance().addCompositeSub(getTaskId());
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppService.getInstance().removeCompositeSub(getTaskId());
    }
}
