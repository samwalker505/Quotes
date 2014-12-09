package walkerinc.samwalker.quotes.handlers;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import walkerinc.samwalker.quotes.models.Quote;

/**
 * Created by samwalker on 7/12/14.
 */
public class JsonQuotesResponseHandler extends JsonHttpResponseHandler {

    private int totalNumOfQuotes = 0;
    private JSONArray quotesJsonArray;
    QuotesResponseHandler quotesResponseHandler;

    final String FIELD_QUOTES_LENGTH = "sp";
    final String FIELD_QUOTES = "quotes";

    public JsonQuotesResponseHandler(){};

    public JsonQuotesResponseHandler(QuotesResponseHandler quotesResponseHandler) {
        this.quotesResponseHandler = quotesResponseHandler;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        super.onSuccess(statusCode, headers, response);
        System.out.print("enter");
        totalNumOfQuotes = response.has(FIELD_QUOTES_LENGTH)?response.optInt(FIELD_QUOTES_LENGTH):0;
        quotesJsonArray = response.has(FIELD_QUOTES)?response.optJSONArray(FIELD_QUOTES):null;
        ArrayList<Quote> quotes = new ArrayList<Quote>();

        for (int i = 0; i < totalNumOfQuotes; i++) {
            if (quotesJsonArray != null) {
                Quote quote = new Quote(quotesJsonArray.optJSONObject(i));
                quote.save();
                quotes.add(quote);
            }
        }

        this.quotesResponseHandler.onSuccess(quotes);
    }
}
