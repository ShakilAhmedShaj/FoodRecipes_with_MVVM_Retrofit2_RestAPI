package com.t3ch.shaj.foodrecipes_mvvm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.t3ch.shaj.foodrecipes_mvvm.models.Recipe;
import com.t3ch.shaj.foodrecipes_mvvm.requests.RecipeApi;
import com.t3ch.shaj.foodrecipes_mvvm.requests.ServiceGenerator;
import com.t3ch.shaj.foodrecipes_mvvm.requests.responses.RecipeResponse;
import com.t3ch.shaj.foodrecipes_mvvm.requests.responses.RecipeSearchResponse;
import com.t3ch.shaj.foodrecipes_mvvm.util.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeListActivity extends BaseActivity {

    private static final String TAG = "RecipeListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testRetrofitRequest();
            }
        });
    }

    private void testRetrofitRequest() {

        RecipeApi recipeApi = ServiceGenerator.getRecipeApi();


//----------------------------------------------------------------------------------------------//
        // Do search using Retrofit

//        Call<RecipeSearchResponse> responseCall = recipeApi
//                .searchRecipe(
//                        Constants.API_KEY,
//                        "chicken",
//                        "1"
//                );
//
//        responseCall.enqueue(new Callback<RecipeSearchResponse>() {
//            @Override
//            public void onResponse(Call<RecipeSearchResponse> call, Response<RecipeSearchResponse> response) {
//
//
//                Log.d(TAG, "onResponse: Server Response: " + response.toString());
//
//                if (response.code() == 200) {
//                    Log.d(TAG, "onResponse: " + response.body().toString());
//
//                    List<Recipe> recipes = new ArrayList<>(response.body().getRecipes());
//
//                    for (Recipe recipe : recipes) {
//                        Log.d(TAG, "onResponse: " + recipe.toString());
//                    }
//
//                } else {
//
//                    try {
//                        Log.d(TAG, "onResponse: " + response.errorBody().string());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<RecipeSearchResponse> call, Throwable t) {
//
//            }
//        });

//----------------------------------------------------------------------------------------------//


        // do get using retrofit
        Call<RecipeResponse> responseCall = recipeApi
                .getRecipe(
                        Constants.API_KEY,
                        "35382"
                );

        responseCall.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                Log.d(TAG, "onResponse: Server Response: " + response.toString());
                if (response.code() == 200) {
                    Recipe recipe = response.body().getRecipe();
                    Log.d(TAG, "onResponse: " + recipe.toString());
                } else {
                    try {
                        Log.d(TAG, "onResponse: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                Log.d(TAG, "onResponse: ERROR: " + t.getMessage());
            }
        });


    }

}