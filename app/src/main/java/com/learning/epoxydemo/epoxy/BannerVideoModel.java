package com.learning.epoxydemo.epoxy;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.bumptech.glide.Glide;
import com.learning.serverdrivenuidemo.R;

import butterknife.BindView;

@EpoxyModelClass(layout = R.layout.layout_banner)
public abstract class BannerVideoModel extends EpoxyModelWithHolder<BannerVideoModel.Holder> {

    private static final String TAG = "VideoItemModel";

    @EpoxyAttribute
    public String imageUrl;

    @EpoxyAttribute
    public String title;

    @Override
    public void bind(@NonNull Holder holder) {
        super.bind(holder);
        Log.i(TAG, " bind method image url : " + imageUrl );
        Glide.with(holder.imageView.getContext()).load(imageUrl).into(holder.imageView);
        holder.titleView.setText(title);
    }

    static class Holder extends BaseEpoxyHolder {
      @BindView(R.id.banner_image)
        ImageView imageView;
      @BindView(R.id.banner_title)
        TextView titleView;
    }
}
