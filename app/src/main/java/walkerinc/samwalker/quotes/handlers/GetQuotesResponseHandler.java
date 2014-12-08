package walkerinc.samwalker.quotes.handlers;

import java.util.ArrayList;

import walkerinc.samwalker.quotes.ActivityMain;
import walkerinc.samwalker.quotes.model.Quote;

/**
 * Created by samwalker on 7/12/14.
 */
public class GetQuotesResponseHandler implements QuotesResponseHandler {

    ActivityMain activityMain;

    public GetQuotesResponseHandler(ActivityMain activityMain) {
        this.activityMain = activityMain;
    }

    @Override
    public void onSuccess(ArrayList<Quote> quotes) {
        activityMain.renderQuotes(quotes);
    }
}
