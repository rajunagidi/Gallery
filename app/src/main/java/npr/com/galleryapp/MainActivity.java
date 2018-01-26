package npr.com.galleryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import npr.com.galleryapp.backend.BackendRequest;
import npr.com.galleryapp.modle.AlbumInfo;

public class MainActivity extends AppCompatActivity implements GalleryAdapter.OnItemSelectListener {
    private static final String TAG = "MainActivity";
    RecyclerView mRecyclerView;
    GalleryAdapter mGalleryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.gallery_icons);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(layoutManager);
        mGalleryAdapter = new GalleryAdapter(this);
        mRecyclerView.setAdapter(mGalleryAdapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
        //request for gallery info
        new BackendRequest().requestGalleryInfo((List<AlbumInfo> albums)-> {
                for(AlbumInfo info: albums){
                    Log.d(TAG, "onResponse: "+info);
                }
                mGalleryAdapter.setData(albums);
        });
    }

    @Override
    public void itemSelected(String url) {
        Intent intent  = new Intent(this, ActualImageActivity.class );
        intent.putExtra(GalleryAdapter.IMAGE_URL, url);
        startActivity(intent);
    }
}
