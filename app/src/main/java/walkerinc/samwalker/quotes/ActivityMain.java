package walkerinc.samwalker.quotes;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import walkerinc.samwalker.quotes.adapter.QuotesListViewAdapter;
import walkerinc.samwalker.quotes.handlers.GetQuotesResponseHandler;
import walkerinc.samwalker.quotes.manager.QuoteManager;
import walkerinc.samwalker.quotes.model.Quote;


public class ActivityMain extends ActionBarActivity {

    ListView lsQuotes;

    QuoteManager qm;

    final String TAG = "main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initApp();
        qm.getQuotes(new GetQuotesResponseHandler(this));
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

    private void initApp () {
        qm = QuoteManager.getInstance();
        lsQuotes = (ListView) findViewById(R.id.lsQuotes);
    }

    public void renderQuotes(ArrayList<Quote> quotes) {
        QuotesListViewAdapter quotesListViewAdapter = new QuotesListViewAdapter(this, quotes);
        lsQuotes.setAdapter(quotesListViewAdapter);
    }
}
