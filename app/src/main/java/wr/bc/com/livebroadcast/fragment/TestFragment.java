package wr.bc.com.livebroadcast.fragment;

import android.os.Bundle;
import android.view.View;

import retrofit2.Call;
import wr.bc.com.livebroadcast.R;
import wr.bc.com.livebroadcast.fragment.base.BaseNetFragment;
import wr.bc.com.livebroadcast.network.RetrofitManager;
import wr.bc.com.livebroadcast.network.api.TestApi;

/**
 * Created by xiaoyuan on 16/11/6.
 */

public class TestFragment extends BaseNetFragment<Object>  {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        goneLoading();
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

    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_test;
    }
}
