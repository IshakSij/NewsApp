package at.ac.fhcampuswien;

public class NewsApi {

    private static final String apiKey = "4d43c7f5019b4865b5e5117f1b59943e";
    private static final String url = "https://newsapi.org/v2";

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
}
