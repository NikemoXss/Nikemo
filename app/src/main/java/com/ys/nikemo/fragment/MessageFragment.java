package com.ys.nikemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ys.nikemo.R;
import com.ys.nikemo.base.BaseFragment;

/**
 * Created by Administrator on 2017/9/13.
 */

public class MessageFragment extends BaseFragment {
    View inflate;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate=inflater.inflate(R.layout.fragment_message,container,false);
        return inflate;
    }
}
