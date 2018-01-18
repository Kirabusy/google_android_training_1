package com.borongli.test.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleFragment extends Fragment {

    final static String ARG_POSITION = "article_position";
    int mCurrentPosition = -1;

    public ArticleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // when in two-pane layout, need to restore previous article selection
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        return inflater.inflate(R.layout.article_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        updateAriticelView(getArguments().getInt(ARG_POSITION, -1));
    }

    public void updateAriticelView(int position) {
        if (position == -1) return;
        TextView textView = (TextView) getActivity().findViewById(R.id.artical_text);
        textView.setText(StaticContext.Articles[position]);
        mCurrentPosition = position;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }



}
