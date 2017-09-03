package com.example.root.test.ui.activitys;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.root.test.R;
import com.example.root.test.bean.ExpressInfo;
import com.example.root.test.constant.Constants;
import com.example.root.test.contract.ExpressContract;
import com.example.root.test.presenter.ExpressPresenter;
import com.example.root.test.ui.adapter.ExpressAdapter;
import com.qmuiteam.qmui.widget.QMUIEmptyView;
import com.qmuiteam.qmui.widget.QMUILoadingView;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButtonDrawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17-9-3.
 */

public class ExpressActivity extends AppCompatActivity implements ExpressContract.View {
    private EditText mExpEtSearch;
    private Button mExpBtSearch;
    private TextView mExpTvType;
    private ListView mExpLvData;
    private QMUIEmptyView mExpEv;
    private ExpressContract.Presenter expressPresenter;
    private List<ExpressInfo.DataBean> datas;
    private ExpressAdapter expressAdapter;
    private String type;
    private QMUITipDialog qmuiTipDialog;
    private QMUIDialog qmuiDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_express);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        mExpEtSearch = (EditText) findViewById(R.id.exp_et_search);
        mExpBtSearch = (Button) findViewById(R.id.exp_bt_search);
        mExpTvType = (TextView) findViewById(R.id.exp_tv_type);
        mExpLvData = (ListView) findViewById(R.id.exp_lv_data);

        mExpEv = (QMUIEmptyView) findViewById(R.id.exp_ev);
    }

    private void initData() {
        ExpressPresenter expressPresenter = new ExpressPresenter(this);

        QMUITipDialog.Builder builder = new QMUITipDialog.Builder(this);
        builder.setTipWord("正在加载");
        builder.setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING);
        qmuiTipDialog = builder.create();

        QMUIDialog.CheckableDialogBuilder checkableDialogBuilder = new QMUIDialog.CheckableDialogBuilder(this);
        checkableDialogBuilder.addItems(Constants.EXPRESS_NAME_TYPES, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                type = Constants.EXPRESS_TYPES[i];
                mExpTvType.setText(Constants.EXPRESS_NAME_TYPES[i]);
                qmuiDialog.dismiss();
                qmuiDialog.hide();
            }
        });
        qmuiDialog = checkableDialogBuilder.create();
        setEmptyContentStatus(0);
        datas = new ArrayList<>();
        expressAdapter = new ExpressAdapter(this, datas);
        mExpLvData.setAdapter(expressAdapter);
        mExpLvData.setEmptyView(mExpEv);
    }

    private void initEvent() {
        mExpTvType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qmuiDialog.show();
            }
        });
        mExpBtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressPresenter.requesetData(type, mExpEtSearch.getText().toString().trim());
            }
        });
    }

    @Override
    public void setPresenter(ExpressContract.Presenter presenter) {
        this.expressPresenter = presenter;
    }

    @Override
    public void showExpress(List<ExpressInfo.DataBean> data) {
        this.datas.clear();
        this.datas.removeAll(this.datas);
        this.datas.addAll(data);
        expressAdapter.notifyDataSetChanged();
    }

    @Override
    public void setEmptyContentStatus(int type) {
        mExpEv.show();
        switch (type) {
            case 0:
                mExpEv.setDetailText("什么都没有");
                break;
            case 1:
                mExpEv.setDetailText("输入订单有误,或者无效.");
                break;
        }
    }

    @Override
    public void hideProgressDialog() {
        qmuiTipDialog.dismiss();
        qmuiTipDialog.hide();
    }

    @Override
    public void showProgressDialog() {
        mExpEv.hide();
        qmuiTipDialog.show();
    }
}
