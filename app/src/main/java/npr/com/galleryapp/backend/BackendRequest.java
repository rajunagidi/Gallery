package npr.com.galleryapp.backend;

import java.util.List;

import npr.com.galleryapp.modle.AlbumInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ESHAN on 1/25/2018.
 */

public class BackendRequest {


    public void requestGalleryInfo(final AlbumListener listener){

       GalleryInterface galleryInterface = new GalleryClient().getClient().create(GalleryInterface.class);
       Call<List<AlbumInfo>> call = galleryInterface.getAlbums();
       call.enqueue(new Callback<List<AlbumInfo>>() {
           @Override
           public void onResponse(Call<List<AlbumInfo>> call, Response<List<AlbumInfo>> response) {
               listener.onResponse(response.body());
           }

           @Override
           public void onFailure(Call<List<AlbumInfo>> call, Throwable t) {

           }
       });
    }

    public interface AlbumListener {
        void onResponse(List<AlbumInfo> albums);
    }
}
