package walkerinc.samwalker.quotes.models;

import com.orm.SugarRecord;

import org.json.JSONObject;

/**
 * Created by samwalker on 7/12/14.
 */
public class Quote extends SugarRecord<Quote>{
    private int webId;
    private String quote;
    private String author;
    private String imageUrl;

    final String FIELD_ID = "id";
    final String FIELD_AUTHOR = "author";
    final String FIELD_QUOTE = "quote";
    final String FIELD_IMAGE_URL = "image";

    public Quote() {}


    public Quote(JSONObject quoteJson) {
        webId = quoteJson.has(FIELD_ID)?quoteJson.optInt(FIELD_ID):-1;
        author = quoteJson.has(FIELD_AUTHOR)?quoteJson.optString(FIELD_AUTHOR):null;
        quote = quoteJson.has(FIELD_QUOTE)?quoteJson.optString(FIELD_QUOTE):null;
        imageUrl = quoteJson.has(FIELD_IMAGE_URL)?quoteJson.optString(FIELD_IMAGE_URL):null;
    }

    private void setId(int id) {
        this.webId = id;
    }

    private void setQuote (String quote){
        this.quote = quote;
    }

    private void setAuthor(String author){
        this.author = author;
    }

    private void setImageUrl (String imageUrl){
        this.imageUrl = imageUrl;
    }

    public int getWebId() {
        return this.webId;
    }

    public String getQuote(){
        return this.quote;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }
}
