package org.araceli.imagegallery.service;

import org.araceli.imagegallery.model.ImageFeed;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class FlickrApiClient {
    public static final String BASE_URL = "https://api.flickr.com/services/feeds/";

    public GalleryService getService() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GalleryService.class);
    }

    public interface GalleryService {
        @GET("photos_public.gne?format=json&nojsoncallback=?")
        Call<ImageFeed> getGallery();
    }
}
