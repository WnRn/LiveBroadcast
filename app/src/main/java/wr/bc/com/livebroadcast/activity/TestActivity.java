package wr.bc.com.livebroadcast.activity;

import android.os.Bundle;
import retrofit2.Call;
import wr.bc.com.livebroadcast.R;
import wr.bc.com.livebroadcast.activity.base.BaseNetActivity;
import wr.bc.com.livebroadcast.network.RetrofitManager;
import wr.bc.com.livebroadcast.network.api.TestApi;
import wr.bc.com.livebroadcast.utils.LogUtils;


/**
 * 测试activity
 * Created by xiaoyuan on 16/11/6.
 */

public class TestActivity extends BaseNetActivity<Object> {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goneLoading();
//        setContentView(R.layout.activity_main);
//        TestModel.test();
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void loadData() {
        TestApi testApi = RetrofitManager.getTestRetrofit().create(TestApi.class);
        Call<Object> testCall = testApi.test();
        testCall.enqueue(this);
    }

    @Override
    protected void processData(Object o) {
        LogUtils.w(o.toString());
    }

    @Override
    protected void initTitleBar(HeaderBuilder builder) {

    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_test;
    }

    @Override
    public void onRefresh() {

    }
}
