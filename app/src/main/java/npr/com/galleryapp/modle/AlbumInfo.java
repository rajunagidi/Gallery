package npr.com.galleryapp.modle;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ESHAN on 1/25/2018.
 */

public class AlbumInfo {
    @SerializedName("id")
    String mId;
    @SerializedName("albumId")
    String mAlbumId;
    @SerializedName("title")
    String mTitle;
    @SerializedName("url")
    String mUrl;
    @SerializedName("thumbnailUrl")
    String mThumbnailUrl;

    public String getId() {
        return mId;
    }

    public String getAlbumId() {
        return mAlbumId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getThumbnailUrl() {
        return mThumbnailUrl;
    }

    @Override
    public String toString() {
        return "[ id: "+mId+" mAlbumId: "+mAlbumId+" mTitle: "+mTitle+" mUrl:"+mUrl+" mThumbnailUrl:"+mThumbnailUrl+" ]";
    }
}
