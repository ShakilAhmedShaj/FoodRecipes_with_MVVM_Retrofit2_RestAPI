package com.t3ch.shaj.foodrecipes_mvvm.requests;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.t3ch.shaj.foodrecipes_mvvm.AppExecutors;
import com.t3ch.shaj.foodrecipes_mvvm.models.Recipe;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static com.t3ch.shaj.foodrecipes_mvvm.util.Constants.NETWORK_TIMEOUT;

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

    public void searchRecipesApi() {
        final Future handler = AppExecutors.get().networkIO().submit(new Runnable() {
            @Override
            public void run() {

                // retrieve data from rest api
//                mRecipes.setValue(dataFromRestApi);
            }
        });

        // Set a timeout for the data refresh
        AppExecutors.get().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                // let the user know it timed out
                handler.cancel(true);
            }
        }, NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }


}
