package org.araceli.imagegallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.araceli.imagegallery.model.ImageFeed;
import org.araceli.imagegallery.service.FlickrApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public FlickrApiClient apiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiClient = new FlickrApiClient();
        apiClient.getService().getGallery().enqueue(new Callback<ImageFeed>() {
            @Override
            public void onResponse(Call<ImageFeed> call, Response<ImageFeed> response) {
                if(response.body() != null) {

                }
            }

            @Override
            public void onFailure(Call<ImageFeed> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error loading images", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
