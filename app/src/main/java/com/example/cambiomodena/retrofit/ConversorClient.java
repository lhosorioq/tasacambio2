package com.example.cambiomodena.retrofit;


import com.example.cambiomodena.common.Constantes;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConversorClient {
    private static ConversorClient instance = null;
    private ConversorService conversorService;
    private Retrofit retrofit;

    public ConversorClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.API_CAMBIO_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        conversorService = retrofit.create(ConversorService.class);
    }

    public static ConversorClient getInstance() {
        if (instance == null) {
            instance = new ConversorClient();
        }
        return instance;
    }

    public ConversorService getConversorService() {
        return conversorService;
    }
}
