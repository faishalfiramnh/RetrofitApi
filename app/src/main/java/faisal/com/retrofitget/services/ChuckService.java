package faisal.com.retrofitget.services;

import faisal.com.retrofitget.models.FaisalModel;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Man. United on 22/11/2017.
 */

public interface ChuckService {
    @GET("jokes/random")
    Call<FaisalModel> getQuote();
}

