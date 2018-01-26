package npr.com.galleryapp.modle;

/**
 * Created by ESHAN on 1/25/2018.
 */

public class AlbumInfo {
    String mId;
    String mAlbumId;
    String mTitle;
    String mUrl;
    String mThumbnailUrl;

    AlbumInfo(String id, String albumId, String title, String url, String thumbNail) {
        mId = id;
        mAlbumId = albumId;
        mTitle = title;
        mUrl = url;
        mThumbnailUrl = thumbNail;
    }

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
}
