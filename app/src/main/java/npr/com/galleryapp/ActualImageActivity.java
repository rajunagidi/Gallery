package npr.com.galleryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import npr.com.galleryapp.backend.BackendRequest;

/**
 * Created by ESHAN on 1/25/2018.
 */

public class ActualImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actual_image);

        ImageView imageView = findViewById(R.id.actual_icon);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(GalleryAdapter.IMAGE_URL)) {
            String url = intent.getStringExtra(GalleryAdapter.IMAGE_URL);
            new BackendRequest().downloadIcon(url, imageView);
        }
    }
}
