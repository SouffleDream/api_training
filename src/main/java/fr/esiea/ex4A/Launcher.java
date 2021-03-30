package fr.esiea.ex4A;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import retrofit2.Retrofit;
import fr.esiea.ex4A.client.ApiAgify;
import retrofit2.converter.gson.GsonConverterFactory;

@SpringBootApplication
public class Launcher {

    @Bean
    ApiAgify ApiAgify() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://agify.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        return retrofit.create(ApiAgify.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }
}
