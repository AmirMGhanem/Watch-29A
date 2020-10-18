

package Util;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieResults {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "MovieResults{" +
                "page=" + page +
                ", totalResults=" + totalResults +
                ", totalPages=" + totalPages +
                ", results=" + results +
                '}';
    }

    public static class Result {

        @SerializedName("popularity")
        @Expose
        private Double popularity;
        @SerializedName("vote_count")
        @Expose
        private Integer voteCount;
        @SerializedName("video")
        @Expose
        private Boolean video;
        @SerializedName("poster_path")
        @Expose
        private String posterPath;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("adult")
        @Expose
        private Boolean adult;
        @SerializedName("backdrop_path")
        @Expose
        private String backdropPath;
        @SerializedName("original_language")
        @Expose
        private String originalLanguage;
        @SerializedName("original_title")
        @Expose
        private String originalTitle;
        @SerializedName("genre_ids")
        @Expose
        private List<Integer> genreIds = null;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("vote_average")
        @Expose
        private Double voteAverage;
        @SerializedName("overview")
        @Expose
        private String overview;
        @SerializedName("release_date")
        @Expose
        private String releaseDate;

        public Double getPopularity() {
            return popularity;
        }

        public void setPopularity(Double popularity) {
            this.popularity = popularity;
        }

        public Integer getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(Integer voteCount) {
            this.voteCount = voteCount;
        }

        public Boolean getVideo() {
            return video;
        }

        public void setVideo(Boolean video) {
            this.video = video;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Boolean getAdult() {
            return adult;
        }

        public void setAdult(Boolean adult) {
            this.adult = adult;
        }

        public String getBackdropPath() {
            return backdropPath;
        }

        public void setBackdropPath(String backdropPath) {
            this.backdropPath = backdropPath;
        }

        public String getOriginalLanguage() {
            return originalLanguage;
        }

        public void setOriginalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
        }

        public String getOriginalTitle() {
            return originalTitle;
        }

        public void setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
        }

        public List<Integer> getGenreIds() {
            return genreIds;
        }

        public void setGenreIds(List<Integer> genreIds) {
            this.genreIds = genreIds;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Double getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(Double voteAverage) {
            this.voteAverage = voteAverage;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "popularity=" + popularity +
                    ", voteCount=" + voteCount +
                    ", video=" + video +
                    ", posterPath='" + posterPath + '\'' +
                    ", id=" + id +
                    ", adult=" + adult +
                    ", backdropPath='" + backdropPath + '\'' +
                    ", originalLanguage='" + originalLanguage + '\'' +
                    ", originalTitle='" + originalTitle + '\'' +
                    ", genreIds=" + genreIds +
                    ", title='" + title + '\'' +
                    ", voteAverage=" + voteAverage +
                    ", overview='" + overview + '\'' +
                    ", releaseDate='" + releaseDate + '\'' +
                    '}';
        }
    }
}




