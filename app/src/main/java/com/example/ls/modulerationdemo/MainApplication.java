package com.example.ls.modulerationdemo;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ls.commonmodule.BaseApplication;
import com.ls.commonmodule.BuildConfig;

public class MainApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
