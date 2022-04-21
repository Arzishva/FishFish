package data;


import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

import retrofit2.http.POST;


public interface APIService{

    String BASE_URL = "http://jft.web.id/fishapi/api/";
    @GET("ponds")
    Call<List<DataModelPond>>getPonds();

    @GET("feedtypes")
    Call<List<DataModelFeedType>>getFeeds();

    @FormUrlEncoded
    @POST("feedhistorys")
    Call<DataModelFeedHistory> postFeedHistorys(
            @Field("alias") String alias,
            @Field("name") String name,
            @Field("doseFeed") int doseFeed);

}
