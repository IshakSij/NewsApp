package at.ac.fhcampuswien.controllers;

import at.ac.fhcampuswien.NewsApi;
import at.ac.fhcampuswien.models.NewsResponse;
import at.ac.fhcampuswien.models.Article;

import java.util.ArrayList;
import java.util.List;

public class AppController {

    private List<Article> articles;
    private  NewsResponse newsResponse;

    public AppController() {
        articles = new ArrayList<Article>();
        newsResponse = new NewsResponse();
    }

    public void setArticles(List<Article> articles){
        this.articles = articles;
    }

    public List<Article> getArticles(){
        return articles;
    }

    /**
     * gets the size of article list
     * if the list is null it should return 0
     * @return size of article list
     */
    public int getArticleCount(){
        return NewsApi.getInstance().getTotalNews().getTotalResults();
    }

    /**
     * at the moment only returns the article list
     * not implemented yet
     * @return article list
     */

    // GetTopHeadlines Methode aus NewsApi wird gerufen wo die URL gebaut wird.
    // Es wird überprüft ob es zu einer Antwort von NewsResponse kommt, wenn
    // nicht wird eine leere Liste zurückgeliefert, wenn schon werden die Artikel zurpckgegeben.
    public List<Article> getTopHeadlinesAustria() {
        NewsResponse newsResponse = NewsApi.getInstance().getTopHeadlines("AT", NewsApi.Category.general, NewsApi.Country.at);

        if (newsResponse == null) {
            return new ArrayList<>();
        }else  {
            return newsResponse.getArticles();
        }
    }

    /**
     * returns all articles that do contain "bitcoin"
     * in their title
     * @return filtered list
     */
    public List<Article> getAllNewsBitcoin() {
        NewsResponse newsResponse = NewsApi.getInstance().getAllNews("bitcoin", NewsApi.Language.de, NewsApi.SortBy.relevancy);

        if (newsResponse == null) {
            return new ArrayList<>();
        }else {
            return newsResponse.getArticles();
        }
    }
}
