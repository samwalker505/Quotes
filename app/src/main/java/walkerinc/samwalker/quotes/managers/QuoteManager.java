package walkerinc.samwalker.quotes.managers;

import android.content.SharedPreferences;

import com.loopj.android.http.AsyncHttpClient;

import walkerinc.samwalker.quotes.handlers.GetJsonQuotesResponseHandler;
import walkerinc.samwalker.quotes.handlers.QuotesResponseHandler;
import walkerinc.samwalker.quotes.handlers.RefreshJsonQuotesResponseHandler;

/**
 * Created by samwalker on 7/12/14.
 */
public class QuoteManager {

    private SharedPreferences pref;
    private AsyncHttpClient client = new AsyncHttpClient();
    private int totalNumOfQuotes = 0;
    private String apiBaseUrl = "http://oneline-ckstudio2.rhcloud.com/";

    private static QuoteManager ourInstance = new QuoteManager();

    public static QuoteManager getInstance() {
        return ourInstance;
    }

    private QuoteManager() {
    }

    public void getQuotes(QuotesResponseHandler quotesResponseHandler) {
        String quoteUrl = apiBaseUrl+"quote";
        client.get(quoteUrl, new GetJsonQuotesResponseHandler(quotesResponseHandler));
    }

    public void refreshQuotes(QuotesResponseHandler quotesResponseHandler) {
        String quoteUrl = apiBaseUrl+"quote";
        client.get(quoteUrl, new RefreshJsonQuotesResponseHandler(quotesResponseHandler));
    }

    public static int getTimeStamp() {
        return (int)(System.currentTimeMillis()/1000);
    }

}
