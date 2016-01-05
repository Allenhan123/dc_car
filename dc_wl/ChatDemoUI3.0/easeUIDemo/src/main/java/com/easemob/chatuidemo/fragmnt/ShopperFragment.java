package com.easemob.chatuidemo.fragmnt;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMConversation;
import com.easemob.chatuidemo.Dc_constant;
import com.easemob.chatuidemo.R;
import com.easemob.chatuidemo.dcdomain.Shopper;
import com.easemob.chatuidemo.dcutils.GsonUtils;
import com.easemob.chatuidemo.ui.ChatActivity;
import com.easemob.chatuidemo.ui.LoginActivity;
import com.easemob.chatuidemo.ui.MainActivity;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;


import java.util.ArrayList;

/**
 * Created by Administrator on 2015/12/29.
 */
public class ShopperFragment extends DcBaseFragmnet {
    private GsonUtils gsonUtils;
    public ListView listView;
    public Shopper shop;
    private MyAdapter myAdapter;


    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.shopper_layout, null);
        listView = (ListView) view.findViewById(R.id.lv_shoppermsg);
        return view;
    }
    /**
     * 从服务器获取数据
     */
    private void getDataFromServer() {
        HttpUtils utils = new HttpUtils();

        // 使用xutils发送请求
        utils.send(HttpRequest.HttpMethod.GET, Dc_constant.SERVER_URL,
                new RequestCallBack<String>() {//重写回调方法


                    // 访问成功
                    @Override
                    public void onSuccess(ResponseInfo responseInfo) {
                        String result = (String) responseInfo.result;
                        System.out.println("返回结果:" + result);
                        parseData(result);//解析数据
                    }

                    // 访问失败
                    @Override
                    public void onFailure(HttpException error, String msg) {
                        Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT)
                                .show();
                        error.printStackTrace();
                    }

                });
    }
    //通过GSON解析数据
    protected void parseData(String result) {
        Gson gson = new Gson();
        shop= gson.fromJson(result, Shopper.class);
        System.out.println("解析结果:" + shop.data.get(0).store_name);
    }


    public void initData() {
        getDataFromServer();
        myAdapter = new MyAdapter(mActivity);
        listView.setAdapter(myAdapter);


        //listViewItem 的点击事件 点击后打开隐藏布局
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public boolean item = true;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myAdapter.changeLayoutVisable(view, position);
            }
        });

    }

    //自定义适配器充填ListView
    class MyAdapter extends BaseAdapter {
        private View mLastView;
        private Context mContext;
        private int mLastPosition;
        private int mLastVisibility;

        public MyAdapter(Context context) {
            this.mContext = context;
            mLastPosition = -1;

        }

        @Override
        public int getCount() {
            return shop.data.size();
        }

        @Override
        public Object getItem(int position) {
            return shop.data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(mActivity, R.layout.content_item_layout, null);
                holder.tv_shopperName = (TextView) convertView.findViewById(R.id.tv_spname);
                holder.tv_shopperType = (TextView) convertView.findViewById(R.id.tv_sptype);
                holder.ibt_shopperQQ = (ImageButton) convertView.findViewById(R.id.ibt_spqq);
                holder.ibt_shoppertel = (ImageButton) convertView.findViewById(R.id.ibt_sptell);
                holder.lin = (LinearLayout) convertView.findViewById(R.id.layout_lin);//隐藏的布局
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (mLastPosition == position) {
                holder.lin.setVisibility(mLastVisibility);
            } else {
                holder.lin.setVisibility(View.GONE);
            }

            holder.tv_shopperName.setText(shop.data.get(position).store_name);
            holder.tv_shopperType.setText(shop.data.get(position).store_phone);
            holder.ibt_shoppertel.setOnClickListener(new View.OnClickListener() {
                //拨打电话
                @Override
                public void onClick(View v) {
                    String number = shop.data.get(position).store_phone;
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    Toast.makeText(mActivity, "" + shop.data.get(position).store_phone, Toast.LENGTH_SHORT).show();
                }
            });
            holder.ibt_shopperQQ.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    /**
                     * 跳转到聊天界面
                     */
                    //获取到与聊天人的会话对象。参数username为聊天人的userid或者groupid，后文中的username皆是如此
                    EMConversation conversation = EMChatManager.getInstance().getConversation(shop.data.get(position).store_area);
                   Intent intent=new Intent(mActivity,ChatActivity.class);
                   intent.putExtra("userId", shop.data.get(position).store_name);
                   startActivity(intent);


                }
            });
            return convertView;
        }

        //改变布局的是否隐藏
        public void changeLayoutVisable(View view, int position) {
            if (mLastView != null && mLastPosition != position) {
                ViewHolder holder = (ViewHolder) mLastView.getTag();
                switch (holder.lin.getVisibility()) {
                    case View.VISIBLE:
                        holder.lin.setVisibility(View.GONE);
                        mLastVisibility = View.GONE;
                        break;
                    default:
                        break;
                }
            }
            mLastPosition = position;
            mLastView = view;
            ViewHolder holder = (ViewHolder) view.getTag();
            switch (holder.lin.getVisibility()) {
                case View.GONE:
                    holder.lin.setVisibility(View.VISIBLE);
                    mLastVisibility = View.VISIBLE;
                    break;
                case View.VISIBLE:
                    holder.lin.setVisibility(View.GONE);
                    mLastVisibility = View.GONE;
                    break;
            }
        }
    }

    //ViewHolder来保存控件
    public static class ViewHolder {
        private TextView tv_shopperName;
        private TextView tv_shopperType;
        private ImageButton ibt_shopperQQ;
        private ImageButton ibt_shoppertel;
        private LinearLayout lin;//隐藏的ListView item布局
        ;

    }
}

