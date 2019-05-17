package com.t3ch.shaj.foodrecipes_with_mvvm_retrofit2_restapi;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

/**
 * Created by Shakil Ahmed Shaj on 17-May-19.
 * shakilahmedshaj@gmail.com
 */
public abstract class BaseActivity extends AppCompatActivity {

    public ProgressBar mProgressBar;

    @Override
    public void setContentView(int layoutResID) {

        ConstraintLayout constraintLayout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        FrameLayout frameLayout = constraintLayout.findViewById(R.id.activity_content);
        mProgressBar = constraintLayout.findViewById(R.id.progress_bar);

        getLayoutInflater().inflate(layoutResID, frameLayout, true);

        super.setContentView(layoutResID);
    }

    public void showProgressBar(boolean visible) {

        mProgressBar.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
    }
}
