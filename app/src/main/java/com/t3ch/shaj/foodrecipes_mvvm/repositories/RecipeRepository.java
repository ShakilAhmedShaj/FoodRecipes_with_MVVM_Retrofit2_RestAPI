package com.t3ch.shaj.foodrecipes_mvvm.repositories;

import android.arch.lifecycle.LiveData;

import com.t3ch.shaj.foodrecipes_mvvm.models.Recipe;
import com.t3ch.shaj.foodrecipes_mvvm.requests.RecipeApiClient;

import java.util.List;

/**
 * Created by Shakil Ahmed Shaj on 18-May-19.
 * shakilahmedshaj@gmail.com
 */
public class RecipeRepository {

    private static RecipeRepository instance;
    private RecipeApiClient mRecipeApiClient;

    public static RecipeRepository getInstance() {
        if (instance == null) {
            instance = new RecipeRepository();
        }
        return instance;
    }

    private RecipeRepository() {
        mRecipeApiClient = RecipeApiClient.getInstance();
    }

    public LiveData<List<Recipe>> getRecipes() {
        return mRecipeApiClient.getRecipes();
    }

    public void searchRecipesApi(String query, int pageNumber) {
        if (pageNumber == 0) {
            pageNumber = 1;
        }
        mRecipeApiClient.searchRecipesApi(query, pageNumber);
    }
}

