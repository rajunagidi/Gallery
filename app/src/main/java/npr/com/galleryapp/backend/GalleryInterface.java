package npr.com.galleryapp.backend;

import java.util.List;
import npr.com.galleryapp.modle.AlbumInfo;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ESHAN on 1/25/2018.
 */

public interface GalleryInterface {

    @GET("/photos")
    Call<List<AlbumInfo>> getAlbums();
}
