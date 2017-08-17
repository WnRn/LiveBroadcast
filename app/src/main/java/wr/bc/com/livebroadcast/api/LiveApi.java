package wr.bc.com.livebroadcast.api;

import okhttp3.FormBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import wr.bc.com.livebroadcast.bean.LiveBean;

/**
 * Created by Administrator on 2017/8/17.
 */
public interface LiveApi {
    @POST("live/find.json")
    Call<LiveBean> getLive(@Body FormBody formBody);
}
