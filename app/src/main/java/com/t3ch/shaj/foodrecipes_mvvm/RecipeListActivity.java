package com.t3ch.shaj.foodrecipes_mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.t3ch.shaj.foodrecipes_mvvm.models.Recipe;
import com.t3ch.shaj.foodrecipes_mvvm.requests.RecipeApi;
import com.t3ch.shaj.foodrecipes_mvvm.requests.ServiceGenerator;
import com.t3ch.shaj.foodrecipes_mvvm.requests.responses.RecipeResponse;
import com.t3ch.shaj.foodrecipes_mvvm.requests.responses.RecipeSearchResponse;
import com.t3ch.shaj.foodrecipes_mvvm.util.Constants;
import com.t3ch.shaj.foodrecipes_mvvm.util.Testing;
import com.t3ch.shaj.foodrecipes_mvvm.viewmodels.RecipeListViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeListActivity extends BaseActivity {

    private static final String TAG = "RecipeListActivity";

    private RecipeListViewModel mRecipeListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        mRecipeListViewModel = ViewModelProviders.of(this).get(RecipeListViewModel.class);

        subscribeObservers();

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testRetrofitRequest();
            }
        });
    }

    private void subscribeObservers() {

        mRecipeListViewModel.getRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(@Nullable List<Recipe> recipes) {
                if (recipes != null) {
                    Testing.printRecipes("network test", recipes);
                }
            }
        });
    }

    private void testRetrofitRequest() {
        mRecipeListViewModel.searchRecipesApi("chicken", 1);
    }

}