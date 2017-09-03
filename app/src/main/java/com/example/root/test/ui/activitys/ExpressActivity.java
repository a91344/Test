package com.example.root.test.ui.activitys;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.root.test.BaseView;
import com.example.root.test.R;
import com.example.root.test.bean.ExpressInfo;
import com.example.root.test.constant.Constants;
import com.example.root.test.contract.ExpressContract;
import com.example.root.test.presenter.ExpressPresenter;
import com.example.root.test.ui.adapter.ExpressAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17-9-3.
 */

public class ExpressActivity extends AppCompatActivity implements ExpressContract.View {
    private EditText mExpEtSearch;
    private Button mExpBtSearch;
    private Spinner mExpSpType;
    private ListView mExpLvData;
    private LinearLayout mEmptyLl;
    private TextView mEmptyTvContent;
    private ExpressContract.Presenter expressPresenter;
    private List<ExpressInfo.DataBean> datas;
    private ExpressAdapter expressAdapter;
    private String type;
    private ProgressDialog progressDialog;

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
        mExpSpType = (Spinner) findViewById(R.id.exp_sp_type);
        mExpLvData = (ListView) findViewById(R.id.exp_lv_data);

        mEmptyLl = (LinearLayout) findViewById(R.id.empty_ll);
        mEmptyTvContent = (TextView) findViewById(R.id.empty_tv_content);
    }

    private void initData() {
        ExpressPresenter expressPresenter = new ExpressPresenter(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("加载中...");

        datas = new ArrayList<>();
        expressAdapter = new ExpressAdapter(this, datas);
        mExpLvData.setAdapter(expressAdapter);
        mExpLvData.setEmptyView(mEmptyLl);
        mExpSpType.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Constants.EXPRESS_NAME_TYPES));
        setEmptyContentStatus(0);
    }

    private void initEvent() {
        mExpSpType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                type = Constants.EXPRESS_TYPES[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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
        switch (type) {
            case 0:
                mEmptyTvContent.setText("暂无数据");
                break;
            case 1:
                mEmptyTvContent.setText("输入订单有误,或者无效。");
                break;
        }
        expressAdapter.notifyDataSetChanged();
    }

    @Override
    public void hideProgressDialog() {
        progressDialog.dismiss();
        progressDialog.hide();
    }

    @Override
    public void showProgressDialog() {
        progressDialog.show();
    }
}
