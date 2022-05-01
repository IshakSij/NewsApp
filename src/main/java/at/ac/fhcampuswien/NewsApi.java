package at.ac.fhcampuswien;

import com.google.gson.Gson;
import jdk.jfr.Category;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import at.ac.fhcampuswien.response.NewsResponse;
import org.intellij.lang.annotations.Language;

import java.sql.SQLOutput;

public class NewsApi {

    private static final String apiKey = "4d43c7f5019b4865b5e5117f1b59943e";
    private static final String url = "https://newsapi.org/v2";

    private static NewsApi instance;
    private static OkHttpClient client;

    // enums will be used in AppController
    public enum Language {ar, de, en, es, fr, he, it, nl, no, pt, ru, se, ud, zh}
    public enum Category {business, entertainment, general, health, science, sports, technology}
    public enum Country {ae, ar, at, au, be, bg, br, ca, ch, cn, co, cu, cz, de, eg, fr, gb, gr,
        hk, hu, id, ie, il, in, it, jp, kr, lt, lv, ma, mx, my, ng, nl, no, nz, ph, pl, pt, ro, rs, ru,
        sa, se, sg, si, sk, th, tr, tw, ua, us, ve, za }
    public enum SortBy {relevancy, popularity, publishedAt}


    // for the simplicity, so the same instance gets used
    private NewsApi() {
        client = new OkHttpClient();
    }

    /*
    private static String endpoint;
    private static String q = "https://newsapi.org/v2/everything?q=bitcoin&apiKey=4d43c7f5019b4865b5e5117f1b59943e";
    private static String category = "https://newsapi.org/v2/everything?category=business&apiKey=4d43c7f5019b4865b5e5117f1b59943e";
    private static String country = "https://newsapi.org/v2/everything?country=at&apiKey=4d43c7f5019b4865b5e5117f1b59943e";
    private static String language = "https://newsapi.org/v2/everything?language=en&apiKey=4d43c7f5019b4865b5e5117f1b59943e";
    private static String sortBy = "https://newsapi.org/v2/everything?sortby=relevancy&apiKey=4d43c7f5019b4865b5e5117f1b59943e";

    // setters for the value of each

    // NewsApiClient newsApiClient = new NewsApiClient("4d43c7f5019b4865b5e5117f1b59943e");


    public static void setEndpoint(String endpoint) {
        NewsApi.endpoint = endpoint;
    }

    public static void setQ(String q) {
        NewsApi.q = q;
    }

    public static void setCategory(String category) {
        NewsApi.category = category;
    }

    public static void setCountry(String country) {
        NewsApi.country = country;
    }

    public static void setLanguage(String language) {
        NewsApi.language = language;
    }

    public static void setSortBy(String sortBy) {
        NewsApi.sortBy = sortBy;
    }

     */

    public static NewsApi getInstance(){
        if (instance == null){
            instance = new NewsApi();
        }
        return instance;
    }

    private NewsResponse request(HttpUrl.Builder urlBuilder) {
        urlBuilder.addQueryParameter("apiKey", apiKey);

        Request request = new Request.Builder().url(urlBuilder.build()).build();

        try (Response response = client.newCall(request).execute()) {
            Gson gson = new Gson();
            String responseString = response.body().string();
            NewsResponse newsResponse = gson.fromJson(responseString, NewsResponse.class);
            return newsResponse;
        } catch (Exception e) {
            System.out.println("Something went wrong!");
            return null;
        }
    }

    public NewsResponse getTopHeadlines(String country, Category category, Country choice){
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
        urlBuilder.addEncodedPathSegment("top-headlines");

        urlBuilder.addQueryParameter("category", category.toString());
        urlBuilder.addQueryParameter("country", choice.toString());
        return request(urlBuilder);
    }

    public NewsResponse getAllNews (String query, Language language, SortBy sortBy){
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
        urlBuilder.addPathSegment("everything");

        urlBuilder.addQueryParameter("q", query);
        urlBuilder.addQueryParameter("language", language.toString());
        urlBuilder.addQueryParameter("SortBy", sortBy.toString());

        return request(urlBuilder);
    }

}
