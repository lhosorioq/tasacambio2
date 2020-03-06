package com.example.cambiomodena.retrofit;

import com.example.cambiomodena.model.RespMonedas;
import com.example.cambiomodena.model.ResultConversion;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ConversorService {

    // @GET("full/EUR/json?key=2905|RZzqTPdDtLjmT^zzSPRFDQ~oqsxiWUXA")
    @GET("full/{moneda}/json?key=2905|RZzqTPdDtLjmT^zzSPRFDQ~oqsxiWUXA")
    Call<RespMonedas> full(@Path("moneda") String moneda);

    // @GET("full/EUR/json?key=2905|RZzqTPdDtLjmT^zzSPRFDQ~oqsxiWUXA")
    @GET("quotes/{from}/{to}/json?quantity=1&key=2905|RZzqTPdDtLjmT^zzSPRFDQ~oqsxiWUXA")
    Call<ResultConversion> quotes(@Path("from") String from,
                                  @Path("to") String to);
    //,
    //                                  @Path("quantity") String quantity
}
