package com.t3ch.shaj.foodrecipes_mvvm.requests;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.t3ch.shaj.foodrecipes_mvvm.models.Recipe;

import java.util.List;

/**
 * Created by Shakil Ahmed Shaj on 18-May-19.
 * shakilahmedshaj@gmail.com
 */
public class RecipeApiClient {

    private static RecipeApiClient instance;
    private MutableLiveData<List<Recipe>> mRecipes;

    public static RecipeApiClient getInstance() {
        if (instance == null) {
            instance = new RecipeApiClient();
        }
        return instance;
    }

    private RecipeApiClient() {
        mRecipes = new MutableLiveData<>();
    }

    public LiveData<List<Recipe>> getRecipes() {
        return mRecipes;
    }


}
