package com.example.admin.appcar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMConversation;

public class DCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dc);
    }

    public void check(View view){
        String user="123123";
        EMConversation conversation = EMChatManager.getInstance().getConversation(user);

//        Intent intent=new Intent(DCActivity.this, ChatActivity.class);
//        intent.putExtra("userId",user);
//        startActivity(intent);
//        Toast.makeText(DCActivity.this, user, Toast.LENGTH_LONG).show();
    }
}
