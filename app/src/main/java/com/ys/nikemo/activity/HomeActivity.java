package com.ys.nikemo.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ys.mysdk.okhttp.listener.DisposeDataListener;
import com.ys.nikemo.R;
import com.ys.nikemo.base.BaseActivity;
import com.ys.nikemo.fragment.MainFragment;
import com.ys.nikemo.fragment.MessageFragment;
import com.ys.nikemo.fragment.MineFragment;
import com.ys.nikemo.okhttp.RequestCenter;

/**
 * Created by Administrator on 2017/9/13.
 */

public class HomeActivity extends BaseActivity implements View.OnClickListener {
    RelativeLayout homecontent;
    TextView mine, message, main;
    FragmentManager fm;
    MainFragment mainFragment;
    MessageFragment messagefragment;
    MineFragment minefragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        mainFragment = new MainFragment();
        fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.homecontent, mainFragment);
        ft.commit();
    }

    private void initView() {
        homecontent = (RelativeLayout) findViewById(R.id.homecontent);
        mine = (TextView) findViewById(R.id.tv_mine);
        mine.setOnClickListener(this);
        main = (TextView) findViewById(R.id.tv_main);
        main.setOnClickListener(this);
        message = (TextView) findViewById(R.id.tv_message);
        message.setOnClickListener(this);
        main.setSelected(true);
        //okhttp封装的调用
        RequestCenter.login("http://www.baidu.com", "111", "222", new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {

            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
    }


    private void hideFragment(Fragment f, FragmentTransaction ft) {
        if (f != null) {
            ft.hide(f);
        }
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction ft = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.tv_mine:
                mine.setSelected(true);
                main.setSelected(false);
                message.setSelected(false);
                hideFragment(messagefragment, ft);
                hideFragment(mainFragment, ft);
                if (minefragment == null) {
                    minefragment = new MineFragment();
                    ft.add(R.id.homecontent, minefragment);
                } else {
                    ft.show(minefragment);
                }
                break;
            case R.id.tv_message:
                message.setSelected(true);
                main.setSelected(false);
                mine.setSelected(false);
                hideFragment(minefragment, ft);
                hideFragment(mainFragment, ft);
                if (messagefragment == null) {
                    messagefragment = new MessageFragment();
                    ft.add(R.id.homecontent, messagefragment);
                } else {
                    ft.show(messagefragment);
                }
                break;
            case R.id.tv_main:
                main.setSelected(true);
                message.setSelected(false);
                mine.setSelected(false);
                hideFragment(minefragment, ft);
                hideFragment(messagefragment, ft);
                if (mainFragment == null) {
                    mainFragment = new MainFragment();
                    ft.add(R.id.homecontent, mainFragment);
                } else {
                    ft.show(mainFragment);
                }
                break;
        }
        ft.commit();
    }


}
