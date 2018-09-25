package com.ls.mainmodule.activity;

import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ls.mainmodule.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.newsBtn).setOnClickListener(this);
        findViewById(R.id.weatherBtn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int vId = v.getId();
//        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeScaleUpAnimation(v, v.getWidth() / 2, v.getHeight() / 2, 0, 0);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this,v,"234");
        if (vId == R.id.newsBtn) {
            ARouter.getInstance().build("/news/newsDetailActivity")
                    .withOptionsCompat(optionsCompat)
                    .withLong("key1", 1000L)
                    .withString("key2", "news")
                    .navigation(MainActivity.this, new NavCallback() {
                        @Override
                        public void onArrival(Postcard postcard) {
                            Log.d(TAG, postcard.toString());
                        }

                        @Override
                        public void onLost(Postcard postcard) {
                            super.onLost(postcard);
                        }

                        @Override
                        public void onFound(Postcard postcard) {
                            super.onFound(postcard);
                        }
                    });
        } else if (vId == R.id.weatherBtn) {
            ARouter.getInstance().build("/weather/weatherListActivity")
                    .withOptionsCompat(optionsCompat)
                    .withLong("key1", 1000L)
                    .withString("key2", "天气")
                    .navigation(MainActivity.this, new NavCallback() {
                        @Override
                        public void onArrival(Postcard postcard) {
                            Log.d(TAG, postcard.toString());
                        }
                    });
        }
    }
}
