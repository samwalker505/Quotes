package walkerinc.samwalker.quotes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;

import walkerinc.samwalker.quotes.R;
import walkerinc.samwalker.quotes.models.Quote;

/**
 * Created by samwalker on 7/12/14.
 */
public class QuotesListViewAdapter extends BaseAdapter {

    Context context;
    ArrayList<Quote> quotes;
    DisplayImageOptions displayImageOptions;
    ImageLoaderConfiguration imageLoaderConfiguration;
    ImageLoader imageLoader;

    public QuotesListViewAdapter(Context context, ArrayList<Quote> quotes) {
        this.context = context;
        this.quotes = quotes;

        configImageLoader();

    }

    @Override
    public int getCount() {
        return quotes.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.ls_quotes, null);
        TextView txtQuote = (TextView)row.findViewById(R.id.txtQuote);
        TextView txtAuthor = (TextView)row.findViewById(R.id.txtAuthor);
        ImageView imgQuote = (ImageView)row.findViewById(R.id.imgQuote);

        Quote quote = quotes.get(i);

        txtQuote.setText(quote.getQuote());
        txtAuthor.setText(quote.getAuthor());
        imageLoader.displayImage(quote.getImageUrl(),imgQuote, displayImageOptions);

        return row;
    }

    private void configImageLoader() {
        imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(context).build();
        ImageLoader.getInstance().init(imageLoaderConfiguration);
        imageLoader = ImageLoader.getInstance();
        displayImageOptions = new DisplayImageOptions.Builder()
                                  .cacheInMemory(true)
                                  .build();
    }
}
