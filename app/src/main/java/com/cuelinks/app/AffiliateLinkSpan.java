package com.cuelinks.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Browser;
import android.text.Html;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * This code will perfectly work if user is using html data. FIXME But what if normal text??
 * @author tasneem
 */
public final class AffiliateLinkSpan extends URLSpan {
    private static final String TAG = AffiliateLinkSpan.class.getSimpleName();
    private static final String PUB_ID = "7964CL182"; // User will pass the pubid

    public AffiliateLinkSpan(String url) {
        super(url);
    }

    @Override
    public void onClick(View widget) {
        try {
            Log.d(TAG,getURL());
            Uri uri = Uri.parse(Util.extractLinks(getURL(), PUB_ID));
            Log.d(TAG,uri.toString());
            Context context = widget.getContext();
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            if (context != null && intent != null) {
                intent.putExtra(Browser.EXTRA_APPLICATION_ID, context.getPackageName());
                context.startActivity(intent);
                // FIXME What if user whats to as their deepliking ?
            }
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Parse the html code into normal code and then convert the normal links to affiliate links.<br/>
     * This will extract link from <a href /> tag.
     * @param html
     * @return
     */
    public static CharSequence parseSafeHtml(CharSequence html, TextView view) {
        return replaceURLSpans(Html.fromHtml(html.toString()), view);
    }

    /**
     * Pass encoded html data
     * @param text
     * @return
     */
    public static CharSequence replaceURLSpans(CharSequence text, TextView view) {
        view.setAutoLinkMask(0);
        view.setMovementMethod(LinkMovementMethod.getInstance());
        if (text instanceof Spannable) {
            final Spannable s = (Spannable)text;
            final URLSpan[] spans = s.getSpans(0, s.length(), URLSpan.class);
            if (spans != null && spans.length > 0) {
                for (int i = spans.length - 1; i >= 0; i--) {
                    final URLSpan span = spans[i];
                    final int start = s.getSpanStart(span);
                    final int end = s.getSpanEnd(span);
                    final int flags = s.getSpanFlags(span);
                    s.removeSpan(span);
                    s.setSpan(new AffiliateLinkSpan(span.getURL()), start, end, flags);
                }
            }
        }
        return text;
    }
}