package com.bawei.lvwenjing.data21xlistview.Util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class Utils {
    public static String getInput(InputStream is){
        try {
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            byte []buff=new byte[1024];
            int len=0;
            while((len=is.read(buff))!=-1){
                bos.write(buff,0,len);
                bos.close();
            }
            return  bos.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
}
