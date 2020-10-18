package Util;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class retrofitter {
    public static String BASE_URL = "https://api.themoviedb.org";
    public static int PAGES = 8;
    public static String API_KEY = "d3f227b4434aac39631af26e1c7c65b9";
    public static String LANGUAGE = "en-US";
    public static String CATEGORY = "popular";

    public retrofitter() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface myApi = retrofit.create(ApiInterface.class);
        Call<MovieResults> call = myApi.listOfMovies(CATEGORY,API_KEY,LANGUAGE,0);
        call.enqueue(new Callback<MovieResults>() {
            @Override
            public void onResponse(Call<MovieResults> call, Response<MovieResults> response) {
                MovieResults results = response.body();
             List<MovieResults.Result> listOfMovies = results.getResults();
                MovieResults.Result firstMovie = listOfMovies.get(0);
                System.out.println(listOfMovies.size());
                System.out.println(firstMovie.getOriginalTitle());

            }

            @Override
            public void onFailure(Call<MovieResults> call, Throwable throwable) {
                System.out.println("Failed");
            }
        });
    }
}
