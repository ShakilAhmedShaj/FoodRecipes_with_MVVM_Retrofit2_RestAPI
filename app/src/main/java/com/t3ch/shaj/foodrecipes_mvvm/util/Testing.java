package com.t3ch.shaj.foodrecipes_mvvm.util;

import android.util.Log;

import com.t3ch.shaj.foodrecipes_mvvm.models.Recipe;

import java.util.List;

/**
 * Created by Shakil Ahmed Shaj on 19-May-19.
 * shakilahmedshaj@gmail.com
 */
public class Testing {

    public static void printRecipes(String tag, List<Recipe> list) {
        for (Recipe recipe : list) {
            Log.d(tag, "printRecipes: " + recipe.getRecipe_id() + ", " + recipe.getTitle());
        }
    }
}