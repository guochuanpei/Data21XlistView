package com.bawei.lvwenjing.data21xlistview.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.lvwenjing.data21xlistview.IAppCation;
import com.bawei.lvwenjing.data21xlistview.R;
import com.bawei.lvwenjing.data21xlistview.bean.Infor;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/4/21.
 */

public class ListViewAdapter extends BaseAdapter {
    List<Infor.ListBean> listbean;
    Context context;
    private FristHarder fristHarder;
    private SconderHarder sconderHarder;

    public ListViewAdapter(List<Infor.ListBean> listbean, Context context) {
        this.listbean = listbean;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listbean.size();
    }

    @Override
    public Object getItem(int position) {
        return listbean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (1 == listbean.get(position).getType()) {
            return 0;
        } else {
            return 1;
        }

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //获取你的布局类型
        int type = getItemViewType(position);
        if (convertView == null) {
            if (type == 0) {

                fristHarder = new FristHarder();
                convertView = View.inflate(context, R.layout.fristactivity, null);
                fristHarder.iv = (ImageView) convertView.findViewById(R.id.frist_imeger);
                fristHarder.tvtitle = (TextView) convertView.findViewById(R.id.frist_tvtitle);
                fristHarder.tvData = (TextView) convertView.findViewById(R.id.frist_tvdata);
                convertView.setTag(fristHarder);
            } else {
                sconderHarder = new SconderHarder();
                convertView = View.inflate(context, R.layout.seondactivity, null);
                sconderHarder.imagerl = (ImageView) convertView.findViewById(R.id.sercond_iamgerl);
                sconderHarder.imagerh = (ImageView) convertView.findViewById(R.id.sercond_iamgerh);
                sconderHarder.imagerr = (ImageView) convertView.findViewById(R.id.sercond_iamgerr);
                sconderHarder.tv = (TextView) convertView.findViewById(R.id.sercond_tvinfor);
                convertView.setTag(sconderHarder);
            }

        } else {
            if (type == 0) {
                fristHarder = (FristHarder) convertView.getTag();
            } else {
                sconderHarder = (SconderHarder) convertView.getTag();
            }
        }
        if (type == 0) {
            fristHarder.tvtitle.setText(listbean.get(position).getTitle());
            fristHarder.tvData.setText(listbean.get(position).getDate());
            ImageLoader.getInstance().displayImage(listbean.get(position).getPic(), fristHarder.iv, IAppCation.getOption());
        } else {
            String[] split = listbean.get(position).getPic().split("\\|");
            sconderHarder.tv.setText(listbean.get(position).getTitle());
            ImageLoader.getInstance().displayImage(split[0], sconderHarder.imagerl, IAppCation.getOption());
            ImageLoader.getInstance().displayImage(split[1], sconderHarder.imagerh, IAppCation.getOption());
            ImageLoader.getInstance().displayImage(split[2], sconderHarder.imagerr, IAppCation.getOption());

        }

        return convertView;
    }

    class FristHarder {
        TextView tvtitle;
        TextView tvData;
        ImageView iv;

    }

    class SconderHarder {
        ImageView imagerl;
        ImageView imagerh;
        ImageView imagerr;
        TextView tv;

    }

}
