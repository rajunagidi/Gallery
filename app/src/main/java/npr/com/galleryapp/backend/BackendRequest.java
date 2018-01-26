package npr.com.galleryapp.backend;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import java.util.List;

import npr.com.galleryapp.modle.AlbumInfo;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ESHAN on 1/25/2018.
 */

public class BackendRequest {

    private static final String TAG = "BackendRequest";

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

    public void downloadIcon(String url, ImageView imageView){
        GalleryInterface galleryInterface = new GalleryClient().getClient().create(GalleryInterface.class);
        Call<ResponseBody> call = galleryInterface.downloadThumbnail(url);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG, "onResponse() called with: call = [" + call + "], response = [" +
                        response + "]");

                Bitmap icon =BitmapFactory.decodeStream(response.body().byteStream());
                if(icon != null){
                    imageView.setImageBitmap(icon);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure() called with: call = [" + call + "], t = [" + t + "]");
            }
        });

    }

    public interface AlbumListener {
        void onResponse(List<AlbumInfo> albums);
    }
//
//    public interface IconDownloadListener{
//        void onDownload(ImageView imageView, Bitmap icon);
//    }
}
