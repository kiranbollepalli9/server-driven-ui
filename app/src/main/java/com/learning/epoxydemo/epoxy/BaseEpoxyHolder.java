package com.learning.epoxydemo.epoxy;

import android.view.View;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;

import com.airbnb.epoxy.EpoxyHolder;

import butterknife.ButterKnife;

public abstract class BaseEpoxyHolder  extends EpoxyHolder {
    @CallSuper
    @Override
    protected void bindView(@NonNull View itemView) {
        ButterKnife.bind(this, itemView);

    }
}
