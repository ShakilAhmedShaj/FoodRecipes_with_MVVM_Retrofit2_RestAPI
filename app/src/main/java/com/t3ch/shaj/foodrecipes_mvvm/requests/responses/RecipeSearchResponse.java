package com.t3ch.shaj.foodrecipes_mvvm.requests.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.t3ch.shaj.foodrecipes_mvvm.models.Recipe;

import java.util.List;

/**
 * Created by Shakil Ahmed Shaj on 17-May-19.
 * shakilahmedshaj@gmail.com
 */
public class RecipeSearchResponse {

    @SerializedName("count")
    @Expose
    private int count;

    @SerializedName("recipes")
    @Expose
    private List<Recipe> recipes;

    public int getCount() {
        return count;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public String toString() {
        return "RecipeSearchResponse{" +
                "count=" + count +
                ", recipes=" + recipes +
                '}';
    }

}
