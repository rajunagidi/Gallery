package npr.com.galleryapp.backend;

import java.util.List;
import npr.com.galleryapp.modle.AlbumInfo;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by ESHAN on 1/25/2018.
 */

public interface GalleryInterface {

    @GET("/photos")
    Call<List<AlbumInfo>> getAlbums();

    @GET()
    Call<ResponseBody> downloadThumbnail(@Url String fileUrl);
}
