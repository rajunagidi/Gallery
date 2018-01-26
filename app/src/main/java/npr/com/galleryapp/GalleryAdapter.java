package npr.com.galleryapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import npr.com.galleryapp.modle.AlbumInfo;

/**
 * Created by ESHAN on 1/25/2018.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    List<AlbumInfo> mIconUrls = new ArrayList<>();
    public static final String  IMAGE_URL = "IMAGE_URL";
    OnItemSelectListener mListener;

    GalleryAdapter(OnItemSelectListener listener){
        mListener = listener;
    }

    public void setData(List<AlbumInfo> iconInfo){
        mIconUrls = iconInfo;
        notifyDataSetChanged();
    }

    @Override
    public GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item,
                parent, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GalleryViewHolder holder, final int position) {
        //async task to fetch icon.

        holder.mIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mListener.itemSelected(mIconUrls.get(position).getUrl());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mIconUrls.size();
    }

    class GalleryViewHolder extends RecyclerView.ViewHolder {

        ImageView mIcon;

        public GalleryViewHolder(View itemView) {
            super(itemView);
            mIcon = itemView.findViewById(R.id.item_icon);
        }
    }

    interface OnItemSelectListener {
        void itemSelected(String url);
    }
}
