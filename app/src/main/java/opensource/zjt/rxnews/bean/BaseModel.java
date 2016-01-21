package opensource.zjt.rxnews.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JianTao on 16/1/10.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public  class BaseModel implements Parcelable {
    protected BaseModel(Parcel in) {
    }

    public BaseModel() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
