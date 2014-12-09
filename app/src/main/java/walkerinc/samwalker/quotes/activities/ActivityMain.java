package walkerinc.samwalker.quotes.activities;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import walkerinc.samwalker.quotes.R;
import walkerinc.samwalker.quotes.adapters.QuotesListViewAdapter;
import walkerinc.samwalker.quotes.handlers.RefreshJsonQuotesResponseHandler;
import walkerinc.samwalker.quotes.handlers.RenderQuotesResponseHandler;
import walkerinc.samwalker.quotes.managers.QuoteManager;
import walkerinc.samwalker.quotes.models.Quote;


public class ActivityMain extends ActionBarActivity {

    SharedPreferences pref;
    SharedPreferences.Editor prefEditor;

    List<Quote> quotes;
    ListView lsQuotes;

    QuoteManager qm;

    final String TAG = "main";
    final String PREF_NAME = "pref_quotes";
    final String TIME_STAMP_QUOTES = "time_stamp_quotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initApp();
        getAndRenderQuotes();
        refreshQuotes();
    }


    private void initApp () {
        pref = getSharedPreferences(PREF_NAME, 0);
        prefEditor = pref.edit();
        quotes = new ArrayList<Quote>();
        qm = QuoteManager.getInstance();
        lsQuotes = (ListView) findViewById(R.id.lsQuotes);
    }


    private void getAndRenderQuotes(){
        quotes = Quote.listAll(Quote.class);
        if (isQuotesEmpty()) {
            setRefreshTimeStamp();
            qm.getQuotes(new RenderQuotesResponseHandler(this));
            Log.d(TAG, "no quotes in db");
        } else {
            renderQuotes(new ArrayList<Quote>(quotes));
            Log.d(TAG, "have quotes in db");
        }
    }

    private boolean isQuotesEmpty() {
        if (quotes == null) {
            return true;
        } else {
            if (quotes.size() == 0) {
                return true;
            }
        }
        return false;
    }

    private void refreshQuotes() {

        int oldTimeStamp = pref.getInt(TIME_STAMP_QUOTES, 0);
        int nowTimeStamp = QuoteManager.getTimeStamp();

        if (Quote.isQuotesNeedRefresh(oldTimeStamp, nowTimeStamp)) {
            Log.d(TAG, "needed refresh");
            setRefreshTimeStamp();
            qm.refreshQuotes(new RenderQuotesResponseHandler(this));
        } else {
            Log.d(TAG, "no need refresh");
        }
    }

    private void setRefreshTimeStamp() {
        prefEditor.putInt(TIME_STAMP_QUOTES, QuoteManager.getTimeStamp());
        prefEditor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void renderQuotes(ArrayList<Quote> quotes) {
        QuotesListViewAdapter quotesListViewAdapter = new QuotesListViewAdapter(this, quotes);
        lsQuotes.setAdapter(quotesListViewAdapter);
    }
}
