package com.cliliang.home.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cliliang.R;
import com.cliliang.app.ui.BaseFragment;

/**
 * desc:
 * Created by:chenliliang
 * Created on:2017/7/3.
 */

public class MainFindFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_find_fragment_layout, container, false);
    }
}
