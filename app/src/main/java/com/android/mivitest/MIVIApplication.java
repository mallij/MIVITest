package com.android.mivitest;

import android.app.Application;

import com.android.mivitest.model.CollectionData;

public class MIVIApplication extends Application {
    CollectionData collectionData;
    public static MIVIApplication application;
    public static MIVIApplication getAppInstance()
    {
        if(application == null)
            application = new MIVIApplication();

        return application;
    }

    public CollectionData getCollectionData() {
        return collectionData;
    }

    public void setCollectionData(CollectionData collectionData) {
        this.collectionData = collectionData;
    }
}
