//package wr.bc.com.livebroadcast.text;
//
//import okhttp3.FormBody;
//import retrofit2.Call;
//import retrofit2.http.Body;
//import retrofit2.http.GET;
//import retrofit2.http.POST;
//import retrofit2.http.Path;
//import retrofit2.http.Query;
//
///**
// * Created by Administrator on 2017/8/15.
// */
//public interface MyNews {
//   // http://v.juhe.cn/toutiao/index?type=top&key=562402375cb93590c7eec9ade024dffe
//    @GET("index")
//    Call<Object> getNew(@Query("type") String type,@Query("key") String key);
//    //http://v.juhe.cn/toutiao/index/1233213123
//    @GET("index/{id}")
//    Call<TopNews> getNew1(@Path("id") String id);
//
//    //------------------------------帅逼线----------------------------
//    @POST("index")
//    Call<TopNews> postNew(@Body FormBody formBody);
//}
