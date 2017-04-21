package com.bawei.lvwenjing.data21xlistview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.bawei.lvwenjing.data21xlistview.Adapter.ListViewAdapter;
import com.bawei.lvwenjing.data21xlistview.Adapter.viewPagerAdapter;
import com.bawei.lvwenjing.data21xlistview.bean.Infor;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class MainActivity extends Activity {
    private String[] imagerpath;
    private ListViewAdapter listViewAdaptera;
    private ViewPager mV_pager;
    private ListView mLv;
    private String url = "http://qhb.2dyt.com/Bwei/news?type=2&postkey=1503d&page=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mV_pager = (ViewPager) findViewById(R.id.v_pager);
        mLv = (ListView) findViewById(R.id.lv);
        AsyacTask asyacTask = new AsyacTask();
        try {
            String s = asyacTask.execute(url).get();
            Gson gson = new Gson();
            Infor infor = gson.fromJson(s, Infor.class);
            Log.i("TAG", "请求的数据" + infor);
            imagerpath = new String[]{infor.getListViewPager().get(0), infor.getListViewPager().get(1), infor.getListViewPager().get(2)};
            listViewAdaptera = new ListViewAdapter(infor.getList(), MainActivity.this);
            mLv.setAdapter(listViewAdaptera);
            viewPagerAdapter viewPagerAdapter = new viewPagerAdapter(imagerpath, MainActivity.this);
            mV_pager.setAdapter(viewPagerAdapter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }


}
