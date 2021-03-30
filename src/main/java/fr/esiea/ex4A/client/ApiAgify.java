package fr.esiea.ex4A.client;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiAgify {
    @GET("?")
    Call<ResponseBody> getUser(@Query("name") String username, @Query("country_id") String country_id);
}
