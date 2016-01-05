package com.easemob.chatuidemo.dcActivity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.easemob.chatuidemo.R;

/**
 * Created by Administrator on 2016/1/4.
 * 自定义组合控件   三个客服电话
 */
public class Tel_view extends RelativeLayout {

    //用代码new走此方法

    public Tel_view(Context context) {
        super(context);
        initView();
    }
    //有属性走此方法

    public Tel_view(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }
    //有style样式走此方法
    public Tel_view(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }
    private void initView(){
        View.inflate(getContext(), R.layout.tel_view_layout,this);
    }
}
