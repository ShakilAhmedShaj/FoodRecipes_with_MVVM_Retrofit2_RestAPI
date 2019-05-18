package com.t3ch.shaj.foodrecipes_mvvm.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.t3ch.shaj.foodrecipes_mvvm.models.Recipe;

import java.util.List;

/**
 * Created by Shakil Ahmed Shaj on 18-May-19.
 * shakilahmedshaj@gmail.com
 */
public class RecipeRepository {

    private static RecipeRepository instance;
    private MutableLiveData<List<Recipe>> mRecipes;

    public static RecipeRepository getInstance() {
        if (instance == null) {
            instance = new RecipeRepository();
        }
        return instance;
    }

    private RecipeRepository() {
        mRecipes = new MutableLiveData<>();
    }

    public LiveData<List<Recipe>> getRecipes() {
        return mRecipes;
    }


}
