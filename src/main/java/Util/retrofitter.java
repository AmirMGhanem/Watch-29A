package Util;


import TMDB_APi.MovieVideos;
import TMDB_APi.Videos;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;
public class retrofitter {
    public static String BASE_URL = "https://api.themoviedb.org";
    public static int PAGES = 1;
    public static String API_KEY = "d3f227b4434aac39631af26e1c7c65b9";
    public static String LANGUAGE = "en-US";
    public static String CATEGORY = "popular";
    //----------------------------------------
    public static int ID = 666;
    public static String appendToResponse="videos";

    public retrofitter() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface myApi = retrofit.create(ApiInterface.class);
        setPAGES(8);
        Call<MovieResults> call = myApi.listOfMovies(CATEGORY,API_KEY,LANGUAGE,PAGES);
        call.enqueue(new Callback<MovieResults>() {
            @Override
            public void onResponse(Call<MovieResults> call, Response<MovieResults> response) {
                MovieResults results = response.body();
             List<MovieResults.Result> listOfMovies = results.getResults();
                MovieResults.Result firstMovie = listOfMovies.get(0);
                System.out.println();
                System.out.println("First movie of the popular category page 1 is found. the id is "+ firstMovie.getId() +
                        " and it's title is " + firstMovie.getTitle());
                System.out.println("Let's find the trailer video key for streaming it.");
                setID(firstMovie.getId());

                //Calling the videos Path for getting the key.
                Call<MovieVideos> callMovie = myApi.listOfVideos(ID,API_KEY,LANGUAGE,appendToResponse);
                callMovie.enqueue(new Callback<MovieVideos>() {
                    @Override
                    public void onResponse(Call<MovieVideos> call, Response<MovieVideos> response) {
                        MovieVideos listOfVideos = response.body();
                        Videos video = listOfVideos.getVideos();
                        System.out.println("Movie ID -> " + ID + " is found, the video key is - \n");
                        System.out.println(video.getResults().get(0).getKey());
                    }

                    @Override
                    public void onFailure(Call<MovieVideos> call, Throwable throwable) {

                    }
                });


            }

            @Override
            public void onFailure(Call<MovieResults> call, Throwable throwable) {
                System.out.println("Failed");
            }
        });


    }

    public static int getPAGES() {
        return PAGES;
    }

    public static void setPAGES(int PAGES) {
        retrofitter.PAGES = PAGES;
    }

    public static String getApiKey() {
        return API_KEY;
    }

    public static void setApiKey(String apiKey) {
        API_KEY = apiKey;
    }

    public static String getLANGUAGE() {
        return LANGUAGE;
    }

    public static void setLANGUAGE(String LANGUAGE) {
        retrofitter.LANGUAGE = LANGUAGE;
    }

    public static String getCATEGORY() {
        return CATEGORY;
    }

    public static void setCATEGORY(String CATEGORY) {
        retrofitter.CATEGORY = CATEGORY;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        retrofitter.ID = ID;
    }

    public static String getAppendToResponse() {
        return appendToResponse;
    }

    public static void setAppendToResponse(String appendToResponse) {
        retrofitter.appendToResponse = appendToResponse;
    }
}
