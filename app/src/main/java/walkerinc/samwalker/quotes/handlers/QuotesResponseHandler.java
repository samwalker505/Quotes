package walkerinc.samwalker.quotes.handlers;

import java.util.ArrayList;

import walkerinc.samwalker.quotes.model.Quote;

/**
 * Created by samwalker on 7/12/14.
 */
public interface QuotesResponseHandler {
    void onSuccess(ArrayList<Quote> quotes);
}
