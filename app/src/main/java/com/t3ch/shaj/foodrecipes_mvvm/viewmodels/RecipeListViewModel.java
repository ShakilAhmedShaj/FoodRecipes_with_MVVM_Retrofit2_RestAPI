package com.t3ch.shaj.foodrecipes_mvvm.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.t3ch.shaj.foodrecipes_mvvm.models.Recipe;
import com.t3ch.shaj.foodrecipes_mvvm.repositories.RecipeRepository;

import java.util.List;

/**
 * Created by Shakil Ahmed Shaj on 18-May-19.
 * shakilahmedshaj@gmail.com
 */
public class RecipeListViewModel extends ViewModel {

    private RecipeRepository mRecipeRepository;


    public RecipeListViewModel() {

        mRecipeRepository = RecipeRepository.getInstance();


    }

    public LiveData<List<Recipe>> getRecipes() {
        return mRecipeRepository.getRecipes();
    }

}

