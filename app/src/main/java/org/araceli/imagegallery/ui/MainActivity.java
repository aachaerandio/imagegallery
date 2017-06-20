package org.araceli.imagegallery.ui;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import org.araceli.imagegallery.LoadImageGallery;
import org.araceli.imagegallery.R;
import org.araceli.imagegallery.model.Item;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoadImageGallery.OnFinishedListener {

    private LoadImageGallery loadImageGallery;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private View progressSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activity_main_swipe_refresh_layout);
        recyclerView = (RecyclerView) findViewById(R.id.imageGallery);
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        progressSpinner = findViewById(R.id.progressSpinner);
        progressSpinner.setVisibility(View.VISIBLE);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadGallery();
            }
        });

        loadImageGallery = new LoadImageGallery();
        loadGallery();
    }

    private void loadGallery() {
        loadImageGallery.loadGallery(this);
    }

    @Override
    public void onFinished(List<Item> items) {
        swipeRefreshLayout.setRefreshing(false);
        progressSpinner.setVisibility(View.GONE);
        setItems(items);
    }

    @Override
    public void onError() {
        swipeRefreshLayout.setRefreshing(false);
        progressSpinner.setVisibility(View.GONE);
        Toast.makeText(MainActivity.this, "Error loading images", Toast.LENGTH_SHORT).show();
    }

    private void setItems(List<Item> items) {
        ImageItemAdapter adapter = new ImageItemAdapter(getApplicationContext(), items);
        recyclerView.setAdapter(adapter);
    }
}
