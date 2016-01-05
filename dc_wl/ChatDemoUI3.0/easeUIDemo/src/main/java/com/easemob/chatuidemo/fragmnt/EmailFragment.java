package com.easemob.chatuidemo.fragmnt;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.easemob.chatuidemo.R;
import com.easemob.chatuidemo.dcdomain.EmailMessage;


/**
 * Created by Administrator on 2015/12/29.
 */
public class EmailFragment extends DcBaseFragmnet{
    private EmailMessage message;
    private Button btcommit;
    private EditText et_fixtel,et_fixadrss,et_fixname,et_selltel,et_selladress,et_sellname;

    @Override
    public View initView() {
        View view= View.inflate(mActivity, R.layout.email_layout, null);
        btcommit= (Button) view.findViewById(R.id.bt_commit);

        et_fixname= (EditText) view.findViewById(R.id.et_fixname);
        et_fixtel= (EditText) view.findViewById(R.id.et_fixtel);
        et_fixadrss= (EditText) view.findViewById(R.id.et_fixadrss);
        et_selltel= (EditText) view.findViewById(R.id.et_selltel);
        et_selladress= (EditText) view.findViewById(R.id.et_selladress);
        et_sellname= (EditText) view.findViewById(R.id.et_sellname);
        return view;
    }

    @Override
    public void initData() {//初始化数据


        btcommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commitData();
            }
        });

        super.initData();
    }



//提交按钮来提交数据
    public void commitData(){
        message=new EmailMessage();

        if(TextUtils.isEmpty(et_fixtel.getText())){
            Toast.makeText(mActivity, "修理厂电话不能为空", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(et_selltel.getText())){
                Toast.makeText(mActivity, "汽配店电话不能为空", Toast.LENGTH_LONG).show();
        }else{
            message.setFixName(et_fixname.getText().toString());
            message.setFixAdress(et_fixadrss.getText().toString());
            message.setFixTell(et_fixtel.getText().toString());
            message.setShopAdress(et_selladress.getText().toString());
            message.setShopName(et_sellname.getText().toString());
            message.setFixTell(et_selltel.getText().toString());
        }

    }
}
