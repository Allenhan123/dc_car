package com.easemob.chatuidemo.dcActivity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.easemob.chatuidemo.R;
import com.easemob.chatuidemo.fragmnt.EmailFragment;
import com.easemob.chatuidemo.fragmnt.ShopperFragment;

/**
 * Created by Administrator on 2015/12/31.
 */
public class DcMainActivity extends Activity {
    private Button bt_shop;
    private Button bt_email;
    private static final String FRAGMENT_SHOPPER_MENU = "fragment_shopper_menu";
    private static final String FRAGMENT_EMAIL_MENU = "fragment_email_menu";
    private long exitTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dc_main_layout);
        bt_shop = (Button) findViewById(R.id.bt_search);
        bt_email = (Button) findViewById(R.id.bt_noitify);
        initShooperFragment();

        bt_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initShooperFragment();
            }
        });
        bt_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initEmailFragment();
            }
        });

    }

    public void initShooperFragment() {


        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fl_content, new ShopperFragment(), FRAGMENT_SHOPPER_MENU);
        ft.commit();
    }

    public void initEmailFragment() {
        android.app.FragmentManager fm = getFragmentManager();
        android.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fl_content, new EmailFragment(), FRAGMENT_EMAIL_MENU);
        ft.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN)
        {

            if((System.currentTimeMillis()-exitTime) > 2000)  //System.currentTimeMillis()无论何时调用，肯定大于2000
            {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            }
            else
            {
                finish();
                System.exit(0);
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

