package com.bawei.lvwenjing.data21xlistview.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.lvwenjing.data21xlistview.IAppCation;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by lenovo-pc on 2017/4/21.
 */

public class viewPagerAdapter extends PagerAdapter {
    String[] imagerpath;
    Context context;

    public viewPagerAdapter(String[] imagerpath, Context context) {
        this.imagerpath = imagerpath;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imagerpath.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        ImageLoader.getInstance().displayImage(imagerpath[position], imageView, IAppCation.getOption());
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
