package com.t3ch.shaj.foodrecipes_mvvm.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.t3ch.shaj.foodrecipes_mvvm.models.Recipe;

import java.util.List;

/**
 * Created by Shakil Ahmed Shaj on 18-May-19.
 * shakilahmedshaj@gmail.com
 */
public class RecipeListViewModel extends ViewModel {

    private MutableLiveData<List<Recipe>> mRecipes = new MutableLiveData<>();

    public RecipeListViewModel() {

    }

    public LiveData<List<Recipe>> getRecipes() {
        return mRecipes;
    }

}

