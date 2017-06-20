package org.araceli.imagegallery;

import android.support.annotation.NonNull;

import org.araceli.imagegallery.model.ImageFeed;
import org.araceli.imagegallery.model.Item;
import org.araceli.imagegallery.service.FlickrApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadImageGallery {

    private FlickrApiClient apiClient;

    public void loadGallery(final OnFinishedListener listener) {
        apiClient = new FlickrApiClient();
        apiClient.getService().getGallery().enqueue(new Callback<ImageFeed>() {
            @Override
            public void onResponse(@NonNull Call<ImageFeed> call, @NonNull Response<ImageFeed> response) {
                if(response.body() != null) {
                    listener.onFinished(response.body().getItems());
                }
                else {
                    listener.onError();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ImageFeed> call, @NonNull Throwable t) {
                listener.onError();
            }
        });
    }

    public interface OnFinishedListener {
        void onFinished(List<Item> items);
        void onError();
    }
}
