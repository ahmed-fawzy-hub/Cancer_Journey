package com.esraa.CancerJourney;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
