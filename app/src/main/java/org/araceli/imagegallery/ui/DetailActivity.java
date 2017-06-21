package org.araceli.imagegallery.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.araceli.imagegallery.R;
import org.araceli.imagegallery.model.Item;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_DETAIL = "image_id";
    private ImageView imageView;
    private TextView title, dateTaken, description, published, author, tags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.detail_actionbar_title);

        Item imageItem = getIntent().getParcelableExtra(EXTRA_DETAIL);

        imageView = (ImageView) findViewById(R.id.image);
        title = (TextView) findViewById(R.id.title);
        dateTaken = (TextView) findViewById(R.id.dateTaken);
        published = (TextView) findViewById(R.id.published);
        author = (TextView) findViewById(R.id.author);
        tags = (TextView) findViewById(R.id.tags);

        Picasso.with(this)
                .load(imageItem.getMedia().getM().replace("_m.", "_b."))
                .error(R.mipmap.ic_launcher)
                .into(imageView);

        title.setText(imageItem.getTitle());
        dateTaken.setText(Utils.formatTakenDate(imageItem.getDateTaken()));
        published.setText(Utils.formatPublishedDate(imageItem.getPublished()));
        author.setText(imageItem.getAuthor());
        tags.setText(imageItem.getTags());
    }
}
