package com.softpian.redditvm.base;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.create();
    }

    public static ApplicationComponent getApplicationComponent(Context context) {

        return ((MyApplication) context.getApplicationContext()).mApplicationComponent;
    }
}
