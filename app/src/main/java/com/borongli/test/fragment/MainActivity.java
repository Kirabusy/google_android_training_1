package com.borongli.test.fragment;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends FragmentActivity
        implements HeadlinesFragment.OnHeadlinesSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_articles);

        //test
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(String.valueOf(getTaskId()));

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) return;
            HeadlinesFragment firstFragment = new HeadlinesFragment();
            firstFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
        }
    }
    // implements HeadlinesFragment.OnHeadlinesSelectedListener
    @Override
    public void onArticleSelected(int position) {
        // check if articleFragment is exist or not
        // if yes, it's two-pane layout
        ArticleFragment articleFragment = (ArticleFragment)
                getSupportFragmentManager().findFragmentById(R.id.article);
        if (articleFragment != null) {
            // TODO: 2018/1/17 implement two-pane layout
        } else {
            articleFragment = new ArticleFragment();

        }

    }
}
