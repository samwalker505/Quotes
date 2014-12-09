package walkerinc.samwalker.quotes.handlers;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import walkerinc.samwalker.quotes.models.Quote;
import walkerinc.samwalker.quotes.models.QuoteFactory;

/**
 * Created by samwalker on 7/12/14.
 */
public class GetJsonQuotesResponseHandler extends JsonHttpResponseHandler {

    QuotesResponseHandler quotesResponseHandler;

    public GetJsonQuotesResponseHandler(){};

    public GetJsonQuotesResponseHandler(QuotesResponseHandler quotesResponseHandler) {
        this.quotesResponseHandler = quotesResponseHandler;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        super.onSuccess(statusCode, headers, response);
        System.out.print("enter");
        ArrayList<Quote> quotes = QuoteFactory.getQuotesFromJsonObject(response);
        this.quotesResponseHandler.onSuccess(quotes);
    }
}
