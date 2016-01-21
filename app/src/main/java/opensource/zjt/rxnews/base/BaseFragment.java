package opensource.zjt.rxnews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by JianTao on 16/1/21.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public class BaseFragment extends Fragment {
    private int mTaskId;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTaskId = getActivity().getTaskId();
    }

    protected int getmTaskId() {
        return mTaskId;
    }
}
