package walkerinc.samwalker.quotes.handlers;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import walkerinc.samwalker.quotes.models.Quote;

/**
 * Created by samwalker on 9/12/14.
 */
public class RefreshJsonQuotesResponseHandler extends GetJsonQuotesResponseHandler {

    public RefreshJsonQuotesResponseHandler (QuotesResponseHandler quotesResponseHandler){
        super(quotesResponseHandler);
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        Quote.deleteAll(Quote.class);
        super.onSuccess(statusCode, headers, response);
    }
}
