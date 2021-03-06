package com.cuelinks.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Patterns;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String PUB_ID = "7964CL182";
    private String text = "Redirect this link via <a href='linksredirect.com'>linksredirect.com </a>\n \n https://www.faasos.com/ \n\n www.fassos.com \n\n " +
            "desidime.in \n\n www.zingoy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(text);
        textView.setMovementMethod(CustomLinkMovementMethod.getInstance(this));
    }
}
