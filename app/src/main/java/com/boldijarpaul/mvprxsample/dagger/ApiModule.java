package com.boldijarpaul.mvprxsample.dagger;

import com.boldijarpaul.mvprxsample.BuildConfig;
import com.boldijarpaul.mvprxsample.service.JokeApiService;
import com.boldijarpaul.mvprxsample.service.JokeListApiService;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

@Module
public class ApiModule {

    private static final String API_APP_DATA_ENDPOINT = "http://api.icndb.com/jokes/";

    @Provides
    @Singleton
    Endpoint provideAppDataEndpoint() {
        return Endpoints.newFixedEndpoint(API_APP_DATA_ENDPOINT);
    }

    @Provides
    @Singleton
    Client provideClient(OkHttpClient client) {
        return new OkClient(client);
    }

    @Provides
    @Singleton
    Converter provideConverter(Gson gson) {
        return new GsonConverter(gson);
    }

    @Provides
    @Singleton
    RestAdapter provideAppDataRestAdapter(Endpoint endpoint,
                                          Client client,
                                          Converter converter) {
        return new RestAdapter.Builder()
                .setClient(client)
                .setEndpoint(endpoint)
                .setConverter(converter)
                .setLogLevel(
                        BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                .build();
    }

    @Provides
    @Singleton
    JokeApiService provideApiService(RestAdapter restAdapter) {
        return restAdapter.create(JokeApiService.class);
    }

    @Provides
    @Singleton
    JokeListApiService provideJokeListApiService(RestAdapter restAdapter) {
        return restAdapter.create(JokeListApiService.class);
    }


}
