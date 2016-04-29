package com.cuelinks.app;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by tasneem on 4/28/16.
 */
public class LinkTextView extends TextView {
    public LinkTextView(Context context) {
        super(context);
    }

    public LinkTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LinkTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LinkTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }





}
