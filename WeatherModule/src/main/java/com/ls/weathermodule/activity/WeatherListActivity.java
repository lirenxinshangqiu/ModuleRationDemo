package com.ls.weathermodule.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ls.weathermodule.R;

@Route(path = "/weather/weatherListActivity")
public class WeatherListActivity extends AppCompatActivity {
    @Autowired(name = "key1")
    public long value1;
    @Autowired(name = "key2")
    public String value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);
        ARouter.getInstance().inject(this);
        Toast.makeText(this, value1+" "+value2, Toast.LENGTH_SHORT).show();
    }
}
