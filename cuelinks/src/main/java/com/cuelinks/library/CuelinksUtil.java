package com.cuelinks.library;

import android.util.Patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by tasneem on 11/4/16.
 */
public class CuelinksUtil {
    public static String extractLinks(String text, String PUBID) {
        if (BuildConfig.DEBUG) {
            List<String> links = new ArrayList<>();
            Matcher m = Patterns.WEB_URL.matcher(text);
            while (m.find()) {
                String url = m.group();
                links.add(url);
                text = text.replace(url, "https://linksredirect.com/?pub_id=" + PUBID + "&url=" + url);
            }
        }
        return text;
    }
}
