package org.araceli.imagegallery.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.araceli.imagegallery.R;
import org.araceli.imagegallery.model.Item;

import java.util.List;

/**
 * Adapter for images in grid layout gallery
 */
public class ImageItemAdapter extends RecyclerView.Adapter<ImageItemAdapter.ViewHolder>{
    private final List<Item> images;
    private final Context context;

    public ImageItemAdapter(Context context, List<Item> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_gallery_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(context)
                .load(images.get(position).getMedia().getM().replace("_m.", "_z."))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final ImageView image;
        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            image = view.findViewById(R.id.image);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if(position != RecyclerView.NO_POSITION) {
                Item imageItem = images.get(position);
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_DETAIL, imageItem);
                view.getContext().startActivity(intent);
            }
        }
    }
}
