package com.cliliang.app.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Window;

import com.cliliang.app.AppContext;
import com.cliliang.app.flux.AppActionsCreator;
import com.cliliang.app.flux.Dispatcher;


public class BaseActivity extends AppCompatActivity {

    protected AppActionsCreator appActionsCreator;
    protected AppContext appContext;
    public Dispatcher dispatcher;
    protected ProgressDialog mProgressDialog;

    public ProgressDialog showProgress(String title, String message) {
        return showProgress(title, message, -1);
    }

    public ProgressDialog showProgress(String title, String message, int theme) {
        if (mProgressDialog == null) {
            if (theme > 0)
                mProgressDialog = new ProgressDialog(this, theme);
            else
                mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            mProgressDialog.setCanceledOnTouchOutside(false);// 不能取消
            mProgressDialog.setIndeterminate(true);// 设置进度条是否不明确
        }

        if (!TextUtils.isEmpty(title))
            mProgressDialog.setTitle(title);
        mProgressDialog.setMessage(message);
        mProgressDialog.show();
        return mProgressDialog;
    }

    public void hideProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        appContext = (AppContext) getApplicationContext();
    }

    protected void initDependencies(){
        dispatcher = Dispatcher.getInstance();
        appActionsCreator = AppActionsCreator.getInstance();
    }

    protected void setupViews(){

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public int getStatusBarHeight(){
        int result = 0;
        int resId = getResources().getIdentifier("status_bar_height","dimen","android");
        if(resId>0){
            result = getResources().getDimensionPixelSize(resId);
        }
        return result;
    }
}
