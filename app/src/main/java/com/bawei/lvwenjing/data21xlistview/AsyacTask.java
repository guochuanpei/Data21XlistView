package com.bawei.lvwenjing.data21xlistview;

import android.os.AsyncTask;
import android.os.Handler;

import com.bawei.lvwenjing.data21xlistview.Util.Utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lenovo-pc on 2017/4/21.
 */
//网络请求过时了,小傻妮
public class AsyacTask extends AsyncTask<Object, Void, String> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Object... params) {
        try {
            String url = (String) params[0];
            HttpClient client = new DefaultHttpClient();
            HttpGet get = new HttpGet(url);
            HttpResponse execute = client.execute(get);
            if (execute.getStatusLine().getStatusCode() == 200) {
                InputStream inputStream = execute.getEntity().getContent();
                String input = Utils.getInput(inputStream);
                return input;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
