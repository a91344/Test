package com.example.root.test.presenter;

import android.app.ProgressDialog;
import android.os.Handler;
import android.util.Log;

import com.example.root.test.bean.ExpressInfo;
import com.example.root.test.contract.ExpressContract;
import com.example.root.test.netWork.HttpRequests;

import rx.Subscriber;

/**
 * Created by root on 17-9-3.
 */

public class ExpressPresenter implements ExpressContract.Presenter {
    private ExpressContract.View expressView;

    public ExpressPresenter(ExpressContract.View expressView) {
        this.expressView = expressView;
        expressView.setPresenter(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void requesetData(String type, String postId) {
        HttpRequests.SingletonHolder.getInstanceExpress().requestExpressInfo(new Subscriber<ExpressInfo>() {
            @Override
            public void onStart() {
                super.onStart();
                expressView.showProgressDialog();
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(final Throwable e) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        expressView.hideProgressDialog();
                        Log.i("AX1", "onNext: " + e.toString());
                    }
                }, 800);
            }

            @Override
            public void onNext(final ExpressInfo expressInfo) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        expressView.hideProgressDialog();
                        Log.i("AX1", "onNext: " + expressInfo.toString());
                        if (expressInfo.getMessage().equals("快递公司参数异常：单号不存在或者已经过期")) {
                            expressView.setEmptyContentStatus(1);
                        }
                        expressView.showExpress(expressInfo.getData());
                    }
                }, 800);

            }
        }, type, postId);
    }
}
