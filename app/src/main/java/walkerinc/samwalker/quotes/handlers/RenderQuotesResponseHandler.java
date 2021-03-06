package walkerinc.samwalker.quotes.handlers;

import java.util.ArrayList;

import walkerinc.samwalker.quotes.activities.ActivityMain;
import walkerinc.samwalker.quotes.models.Quote;

/**
 * Created by samwalker on 7/12/14.
 */
public class RenderQuotesResponseHandler implements QuotesResponseHandler {

    ActivityMain activityMain;

    public RenderQuotesResponseHandler(ActivityMain activityMain) {
        this.activityMain = activityMain;
    }

    @Override
    public void onSuccess(ArrayList<Quote> quotes) {
        activityMain.renderQuotes(quotes);
    }
}
