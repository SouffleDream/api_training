package fr.esiea.ex4A.client;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import java.util.List;

public interface ApiAgify {
    @GET("?")
    Call<List<User>> listRepos(@Path("user") String user);
}
