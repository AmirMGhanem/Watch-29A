package Util;

import TMDB_APi.MovieVideos;
import TMDB_APi.Videos;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;

public class retrofitter {
    public static String BASE_URL = "https://api.themoviedb.org";
    public static int PAGES = 1;
    public static String API_KEY = "d3f227b4434aac39631af26e1c7c65b9";
    public static String LANGUAGE = "en-US";
    public static String CATEGORY = "popular";
    //----------------------------------------
    public static int ID;
    public static String appendToResponse = "videos";

    static ApiInterface myApi;
    public static List<String> moviesidsStatic;
    public static String youtubeKey, imagepath;

    public static String Header, Overview;


    public retrofitter() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(ApiInterface.class);

    }

    public static void FindMovieByCategory(String category) {
        if (!category.equals(""))
            CATEGORY = category;
        Call<MovieResults> call = myApi.listOfMovies(CATEGORY, API_KEY, LANGUAGE, PAGES);
        call.enqueue(new Callback<MovieResults>() {
            @Override
            public void onResponse(Call<MovieResults> call, Response<MovieResults> response) {
                MovieResults results = response.body();
                assert results != null;

                List<MovieResults.Result> listOfMovies = results.getResults();
                MovieResults.Result firstMovie = listOfMovies.get(0);
                System.out.println();
                System.out.println("First movie of the popular category page " + PAGES + " is found. the id is " + firstMovie.getId() +
                        " and it's title is " + firstMovie.getTitle());
                System.out.println("Let's find the trailer video key for streaming it.");
                setID(firstMovie.getId());

                List<String> moviesids = new ArrayList<>();
                for (MovieResults.Result r : listOfMovies) {
                    moviesids.add(Integer.toString(r.getId()));
                }
                    setMoviesids(moviesids);

            }

            @Override
            public void onFailure(Call<MovieResults> call, Throwable throwable) {
                System.out.println("Failed");
            }
        });
    }


    public static void FindMovieByID(int id) {
        setID(id);
        //Calling the videos Path for getting the key.
        Call<MovieVideos> callMovie = myApi.listOfVideos(ID, API_KEY, LANGUAGE, appendToResponse);
        callMovie.enqueue(new Callback<MovieVideos>() {
            @Override
            public void onResponse(Call<MovieVideos> call, Response<MovieVideos> response) {
                MovieVideos listOfVideos = response.body();
                setHeader(listOfVideos.getTitle());
                setOverview(listOfVideos.getOverview());
                setImagepath(listOfVideos.getPosterPath());
                assert listOfVideos != null;
                Videos video = listOfVideos.getVideos();
                //System.out.println("Movie ID -> " + ID + " is found, the video key is ->" + video.getResults().get(0).getKey());
                setYoutubeKey(video.getResults().get(0).getKey());
                System.out.println("Youtube KEY - " + getYoutubeKey());

            }

            @Override
            public void onFailure(Call<MovieVideos> call, Throwable throwable) {
                System.out.println("Failure!!!!!!");

            }
        });
    }


    public static String getImagepath() {
        return imagepath;
    }

    public static void setImagepath(String imagepath) {
        retrofitter.imagepath = imagepath;
    }

    public static String getHeader() {
        return Header;
    }

    public static void setHeader(String header) {
        Header = header;
    }

    public static String getOverview() {
        return Overview;
    }

    public static void setOverview(String overview) {
        Overview = overview;
    }

    public static String getYoutubeKey() {
        return youtubeKey;
    }

    public static void setYoutubeKey(String key) {
        retrofitter.youtubeKey = key;
    }

    public static List<String> getMoviesids() {
        return moviesidsStatic;
    }



    public static void setMoviesids(List<String> moviesids) {
        retrofitter.moviesidsStatic = moviesids;
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
