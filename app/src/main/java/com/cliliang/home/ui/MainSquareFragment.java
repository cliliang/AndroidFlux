package com.cliliang.home.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cliliang.R;
import com.cliliang.app.module.ModuleID;
import com.cliliang.app.router.MainRouter;
import com.cliliang.app.ui.BaseFragment;
import com.cliliang.user.router.UserUI;

/**
 * desc:
 * Created by:chenliliang
 * Created on:2017/7/3.
 */

public class MainSquareFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_square_fragment_layout, container, false);
        setupView(view);
        return view;
    }

    @Override
    public void setupView(View view) {
        super.setupView(view);
        view.findViewById(R.id.main_square_to_login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainRouter.getInstance(getActivity()).showActivity(ModuleID.USER_MODULE_ID, UserUI.LoginActivity);
            }
        });
    }
}
