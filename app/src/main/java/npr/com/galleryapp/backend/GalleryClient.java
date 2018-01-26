package npr.com.galleryapp.backend;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ESHAN on 1/25/2018.
 */

public class GalleryClient {
    Retrofit getClient(){
        return  new Retrofit.Builder().baseUrl(Util.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }
}
