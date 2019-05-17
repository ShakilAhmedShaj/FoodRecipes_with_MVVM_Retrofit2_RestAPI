package com.t3ch.shaj.foodrecipes_mvvm.requests;

import com.t3ch.shaj.foodrecipes_mvvm.requests.responses.RecipeResponse;
import com.t3ch.shaj.foodrecipes_mvvm.requests.responses.RecipeSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Shakil Ahmed Shaj on 17-May-19.
 * shakilahmedshaj@gmail.com
 */
public interface RecipeApi {

    // SEARCH
    @GET("api/search")
    Call<RecipeSearchResponse> searchRecipe(
            @Query("key") String key,
            @Query("q") String query,
            @Query("page") String page
    );

    // GET SPECIFIC RECIPE
    @GET("api/get")
    Call<RecipeResponse> getRecipe(
            @Query("key") String key,
            @Query("rId") String recipe_id
    );

}
