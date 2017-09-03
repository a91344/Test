package com.example.root.test.contract;

import com.example.root.test.BasePresenter;
import com.example.root.test.BaseView;
import com.example.root.test.bean.ExpressInfo;

import java.util.List;

/**
 * Created by root on 17-9-3.
 */

public interface ExpressContract {
    interface View extends BaseView<Presenter> {
        void showExpress(List<ExpressInfo.DataBean> data);
        void setEmptyContentStatus(int type);
        void hideProgressDialog();
        void showProgressDialog();
    }

    interface Presenter extends BasePresenter {
        void requesetData(String type,String postId);
    }
}
