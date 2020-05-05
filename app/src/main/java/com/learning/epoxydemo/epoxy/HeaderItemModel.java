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

@EpoxyModelClass(layout = R.layout.layout_header)
public abstract class HeaderItemModel extends EpoxyModelWithHolder<HeaderItemModel.Holder> {

    private static final String TAG = "HeaderItemModel";

    @EpoxyAttribute
    public String title;

    @Override
    public void bind(@NonNull Holder holder) {
        super.bind(holder);
        holder.titleView.setText(title);
    }

    static class Holder extends BaseEpoxyHolder {
      @BindView(R.id.header_title)
        TextView titleView;
    }
}
