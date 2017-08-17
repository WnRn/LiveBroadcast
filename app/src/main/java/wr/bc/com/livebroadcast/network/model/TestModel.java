package wr.bc.com.livebroadcast.network.model;


import org.apache.http.HttpException;

import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Response;
import wr.bc.com.livebroadcast.network.BaseCallback;
import wr.bc.com.livebroadcast.network.RetrofitManager;
import wr.bc.com.livebroadcast.network.api.TestApi;
import wr.bc.com.livebroadcast.utils.LogUtils;
import wr.bc.com.livebroadcast.utils.ToastUtils;

/**
 * date: Created hongchen on 16/11/05.
 */
public class TestModel {

    private static TestApi testApi = RetrofitManager.getTestRetrofit().create(TestApi.class);

    public static void test() {
        Call<Object> testCall = testApi.test();
        testCall.enqueue(new BaseCallback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                LogUtils.e("call ---> " + call.toString());
                Object result = response.body();
                LogUtils.e("response ---> " + result.toString());
            }

            @Override
            public void onFailure(Call<Object> call, Throwable throwable) {
                throwable.printStackTrace();
                if (throwable instanceof HttpException || throwable instanceof UnknownHostException) {
                    ToastUtils.showShort("请检查您的网络连接");
                }
            }
        });
    }
}
