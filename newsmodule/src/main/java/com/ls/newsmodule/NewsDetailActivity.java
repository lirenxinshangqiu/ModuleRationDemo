package com.ls.newsmodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/news/newsDetailActivity")
public class NewsDetailActivity extends AppCompatActivity {
    @Autowired(name = "key1")
    public long value1;
    @Autowired(name = "key2")
    public String value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        ARouter.getInstance().inject(this);
        Toast.makeText(this, value1+" "+value2, Toast.LENGTH_SHORT).show();

    }
}
