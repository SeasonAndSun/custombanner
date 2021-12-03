package com.liecen.custombanner.banner.indicator;

import android.view.View;

import androidx.annotation.NonNull;

import com.liecen.custombanner.banner.config.IndicatorConfig;
import com.liecen.custombanner.banner.listener.OnPageChangeListener;

public interface Indicator extends OnPageChangeListener {
    @NonNull
    View getIndicatorView();

    IndicatorConfig getIndicatorConfig();

    void onPageChanged(int count, int currentPosition);

}
