
package org.araceli.imagegallery.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item implements Parcelable {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("media")
    @Expose
    private Media media;
    @SerializedName("date_taken")
    @Expose
    private String dateTaken;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("published")
    @Expose
    private String published;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("author_id")
    @Expose
    private String authorId;
    @SerializedName("tags")
    @Expose
    private String tags;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    protected Item(Parcel in) {
        title = in.readString();
        link = in.readString();
        media = (Media) in.readValue(Media.class.getClassLoader());
        dateTaken = in.readString();
        description = in.readString();
        published = in.readString();
        author = in.readString();
        authorId = in.readString();
        tags = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(link);
        dest.writeValue(media);
        dest.writeString(dateTaken);
        dest.writeString(description);
        dest.writeString(published);
        dest.writeString(author);
        dest.writeString(authorId);
        dest.writeString(tags);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

}
