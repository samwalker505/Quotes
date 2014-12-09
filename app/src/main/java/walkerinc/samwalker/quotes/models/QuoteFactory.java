package walkerinc.samwalker.quotes.models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by samwalker on 9/12/14.
 */
public class QuoteFactory {
    static final String FIELD_QUOTES_LENGTH = "sp";
    static final String FIELD_QUOTES = "quotes";

    public static ArrayList<Quote> getQuotesFromJsonObject(JSONObject quotesJson) {
        int totalNumOfQuotes = quotesJson.has(FIELD_QUOTES_LENGTH)?quotesJson.optInt(FIELD_QUOTES_LENGTH):0;
        JSONArray quotesJsonArray = quotesJson.has(FIELD_QUOTES)?quotesJson.optJSONArray(FIELD_QUOTES):null;
        ArrayList<Quote> quotes = new ArrayList<Quote>();

        for (int i = 0; i < totalNumOfQuotes; i++) {
            if (quotesJsonArray != null) {
                Quote quote = new Quote(quotesJsonArray.optJSONObject(i));
                quote.save();
                quotes.add(quote);
            }
        }
        return quotes;
    }
}
