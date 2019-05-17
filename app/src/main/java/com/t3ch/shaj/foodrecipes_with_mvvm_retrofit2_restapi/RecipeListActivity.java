package com.t3ch.shaj.foodrecipes_with_mvvm_retrofit2_restapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RecipeListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        //test progressbar

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mProgressBar.getVisibility() == View.VISIBLE){
                    showProgressBar(false);
                }
                else{
                    showProgressBar(true);
                }
            }
        });






    }
}
