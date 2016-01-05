package com.easemob.chatuidemo.dcdomain;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrator on 2015/12/29.
 */
public class Shopper {
    private int code;
    private String message;
    public ArrayList<ShopperData> data;

   public static class ShopperData{
       public String sid;
       public String store_name;
       public String store_type;
       public String store_phone;
       public String store_area;
       public String store_text;

       @Override
       public String toString() {
           return "ShopperData{" +
                   "sid='" + sid + '\'' +
                   ", store_name='" + store_name + '\'' +
                   ", store_type='" + store_type + '\'' +
                   ", store_phone='" + store_phone + '\'' +
                   ", store_area='" + store_area + '\'' +
                   ", store_text='" + store_text + '\'' +
                   '}';
       }
   }

    @Override
    public String toString() {
        return "Shopper{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
