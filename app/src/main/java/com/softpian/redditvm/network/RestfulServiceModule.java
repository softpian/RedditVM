package com.softpian.redditvm.network;

import com.softpian.redditvm.util.Constant;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public abstract class RestfulServiceModule {

    @Provides
    @Singleton
    static OkHttpClient provideOkHttpClient() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
    }

    @Provides
    @Singleton
    static Retrofit provideRetrofit(OkHttpClient client) {

        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    static RedditApi provideRedditApi(Retrofit retrofit) {

        return retrofit.create(RedditApi.class);
    }
}
