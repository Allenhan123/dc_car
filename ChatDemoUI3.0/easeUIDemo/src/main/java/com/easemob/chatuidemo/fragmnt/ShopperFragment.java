package com.easemob.chatuidemo.fragmnt;


import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMConversation;
import com.easemob.chatuidemo.R;
import com.easemob.chatuidemo.dcdomain.Shopper;
import com.easemob.chatuidemo.dcutils.GsonUtils;
import com.easemob.chatuidemo.ui.ChatActivity;
import com.easemob.chatuidemo.ui.LoginActivity;
import com.easemob.chatuidemo.ui.MainActivity;


import java.util.ArrayList;

/**
 * Created by Administrator on 2015/12/29.
 */
public class ShopperFragment extends DcBaseFragmnet {
    private GsonUtils gsonUtils;
    public ListView listView;
    public ArrayList<Shopper> listShop;
    private ExpandableListView expandableListView;
    private TextView tv_item;
    private TextView tv_itemname;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.shopper_layout, null);
        //  listView = (ListView) view.findViewById(R.id.lv_shoppermsg);
        expandableListView = (ExpandableListView) view.findViewById(R.id.lv_shoppermsg);
        return view;

    }


    public void initData() {
//        Shopper shopper1=new Shopper("shangjia1","cccc","15256013916","960611947");
//        Shopper shopper2=new Shopper("shangjia2","cccc","15256013916","960611948");
//        Shopper shopper3=new Shopper("shangjia3","cccc","15256013916","960611948");
//        Shopper shopper4=new Shopper("shangjia4","cccc","15256013916","960611947");
//        listShop.add(shopper1);
//        listShop.add(shopper2);
//        listShop.add(shopper3);
//        listShop.add(shopper4);
        listShop = new ArrayList<Shopper>();
        gsonUtils = new GsonUtils(mActivity);
        listShop = gsonUtils.getGsonData();

        expandableListView.setAdapter(new MyExpandableAdapter());


    }

    /*class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return listShop.size();
        }

        @Override
        public Object getItem(int position) {
            return listShop.get(position);
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
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tv_shopperName.setText(listShop.get(position).getShopName());
            holder.tv_shopperType.setText(listShop.get(position).getShopType());
            holder.ibt_shoppertel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String number = listShop.get(position).getTelPhone();
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    Toast.makeText(mActivity, "" + listShop.get(position).getTelPhone(), Toast.LENGTH_SHORT).show();
                }
            });
            holder.ibt_shopperQQ.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EMConversation conversation = EMChatManager.getInstance().getConversation(listShop.get(position).getShopQQ());
                    Intent intent = new Intent(mActivity,ChatActivity.class);
                    intent.putExtra("userId",listShop.get(position).getShopQQ());
                    startActivity(intent);
                }
            });

            return convertView;
        }

    }


    public static class ViewHolder {
        private TextView tv_shopperName;
        private TextView tv_shopperType;
        private ImageButton ibt_shopperQQ;
        private ImageButton ibt_shoppertel;

    }
*/
    class MyExpandableAdapter extends BaseExpandableListAdapter {

        @Override
        public int getGroupCount() {
            return listShop.size();
        }

        @Override
        public int getChildrenCount(int i) {
            return 0;
        }

        @Override
        public Object getGroup(int position) {
            return listShop.get(position);
        }

        @Override
        public Object getChild(int i, int i1) {
            return null;
        }

        @Override
        public long getGroupId(int position) {
            return position;
        }

        @Override
        public long getChildId(int i, int i1) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int position, boolean b, View convertView, ViewGroup viewGroup) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(mActivity, R.layout.content_item_layout, null);
                holder.tv_shopperName = (TextView) convertView.findViewById(R.id.tv_spname);
                holder.tv_shopperType = (TextView) convertView.findViewById(R.id.tv_sptype);
                holder.ibt_shopperQQ = (ImageButton) convertView.findViewById(R.id.ibt_spqq);
                holder.ibt_shoppertel = (ImageButton) convertView.findViewById(R.id.ibt_sptell);
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tv_shopperName.setText(listShop.get(position).getShopName());
            holder.tv_shopperType.setText(listShop.get(position).getShopType());
            holder.ibt_shoppertel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*String number = listShop.get(position).getTelPhone();
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    Toast.makeText(mActivity, "" + listShop.get(position).getTelPhone(), Toast.LENGTH_SHORT).show();*/
                }
            });
            holder.ibt_shopperQQ.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   /* EMConversation conversation = EMChatManager.getInstance().getConversation(listShop.get(position).getShopQQ());
                    Intent intent = new Intent(mActivity,ChatActivity.class);
                    intent.putExtra("userId",listShop.get(position).getShopQQ());
                    startActivity(intent);*/
                }
            });

            return convertView;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View convertView, ViewGroup viewGroup) {
            if (convertView == null) {
                convertView = View.inflate(mActivity, R.layout.shop_item_layout, null);
            }
            tv_itemname  = (TextView) convertView.findViewById(R.id.tv_itemname);
            tv_item  = (TextView) convertView.findViewById(R.id.tv_item);
            tv_itemname.setText("shiuqing");
            tv_item.setText("shilihehee");
            return convertView;

        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }
    }



        public  class ViewHolder {
        private TextView tv_shopperName;
        private TextView tv_shopperType;
        private ImageButton ibt_shopperQQ;
        private ImageButton ibt_shoppertel;

    }







}

