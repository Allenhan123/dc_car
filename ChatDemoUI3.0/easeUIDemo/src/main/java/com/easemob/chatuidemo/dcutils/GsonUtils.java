package com.easemob.chatuidemo.dcutils;

import android.app.Activity;

import com.easemob.chatuidemo.R;
import com.easemob.chatuidemo.dcdomain.Shopper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/12/29.
 */
public class GsonUtils {
    private Activity mActivity;
    ArrayList<Shopper> shoppers;


    public GsonUtils(Activity mActivity) {
        this.mActivity = mActivity;
    }
    public ArrayList<Shopper> getGsonData(){
        Gson gson=new Gson();

        Reader r = new InputStreamReader(mActivity.getResources().openRawResource(R.raw.shopper));
        Type type=new TypeToken<ArrayList<Shopper>>(){}.getType();
        ArrayList<Shopper> list= gson.fromJson(r, type);

        return list;
    }

}
