package walkerinc.samwalker.quotes.manager;

import com.loopj.android.http.AsyncHttpClient;

import java.util.ArrayList;

import walkerinc.samwalker.quotes.handlers.JsonQuotesResponseHandler;
import walkerinc.samwalker.quotes.handlers.QuotesResponseHandler;
import walkerinc.samwalker.quotes.model.Quote;

/**
 * Created by samwalker on 7/12/14.
 */
public class QuoteManager {

    private AsyncHttpClient client = new AsyncHttpClient();
    private int totalNumOfQuotes = 0;
    private String apiBaseUrl = "http://oneline-ckstudio2.rhcloud.com/";
    private String quoteUrl = apiBaseUrl+"quote";
    private static QuoteManager ourInstance = new QuoteManager();

    public static QuoteManager getInstance() {
        return ourInstance;
    }

    private QuoteManager() {
    }

    public void getQuotes(QuotesResponseHandler quotesResponseHandler) {
        client.get(quoteUrl, new JsonQuotesResponseHandler(quotesResponseHandler));
    }

}
