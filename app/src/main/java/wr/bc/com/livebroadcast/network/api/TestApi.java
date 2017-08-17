package wr.bc.com.livebroadcast.network.api;


import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import wr.bc.com.livebroadcast.config.UrlConfig;
import wr.bc.com.livebroadcast.network.HttpClient;

/**
 * date: Created xiaoyuan on 16/11/05.
 */
public interface TestApi {

    @Headers(HttpClient.CACHE_CONTROL_AGE + HttpClient.CACHE_SHORT)
    @POST(UrlConfig.API_V1_0_TEST)
    Call<Object> test();

}
