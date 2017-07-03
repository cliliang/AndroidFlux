package com.cliliang.home.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.cliliang.R;
import com.cliliang.app.ui.BaseStatusBarActivity;
import com.cliliang.common.views.BottomNavigation;

public class MainActivity extends BaseStatusBarActivity {

    private MainSquareFragment fragmentSquare;
    private MainPaierFragment fragmentPaier;
    private MainFindFragment fragmentFind;
    private MainMyFragment fragmentMy;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        setupViews();
        setChoiceItem(0);
    }

    @Override
    protected void setupViews() {
        super.setupViews();
        BottomNavigation navigation = (BottomNavigation) findViewById(R.id.main_activity_bottom_navigation_view);
        navigation.setOnBottomTabCheckedListener(new BottomNavigation.OnBottomTabCheckedListener() {
            @Override
            public void onBottomTabChecked(int position) {
                setChoiceItem(position);
            }
        });
    }

    private void setChoiceItem(int index){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);
        switch (index){
            case 0:
                if (fragmentSquare == null){
                    fragmentSquare = new MainSquareFragment();
                    fragmentTransaction.add(R.id.main_activity_fragment_holder, fragmentSquare);
                }else {
                    fragmentTransaction.show(fragmentSquare);
                }
                break;
            case 1:
                if (fragmentPaier == null){
                    fragmentPaier = new MainPaierFragment();
                    fragmentTransaction.add(R.id.main_activity_fragment_holder, fragmentPaier);
                }else {
                    fragmentTransaction.show(fragmentPaier);
                }
                break;
            case 2:
                if (fragmentFind == null){
                    fragmentFind = new MainFindFragment();
                    fragmentTransaction.add(R.id.main_activity_fragment_holder, fragmentFind);
                }else {
                    fragmentTransaction.show(fragmentFind);
                }
                break;
            case 3:
                if (fragmentMy == null){
                    fragmentMy = new MainMyFragment();
                    fragmentTransaction.add(R.id.main_activity_fragment_holder, fragmentMy);
                }else {
                    fragmentTransaction.show(fragmentMy);
                }
                break;
        }
        fragmentTransaction.commit();
    }

    private void hideFragment(FragmentTransaction ft){
        if (fragmentSquare != null){
            ft.hide(fragmentSquare);
        }

        if (fragmentFind != null){
            ft.hide(fragmentFind);
        }

        if (fragmentPaier != null){
            ft.hide(fragmentPaier);
        }

        if (fragmentMy != null){
            ft.hide(fragmentMy);
        }
    }
}
