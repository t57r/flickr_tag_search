package com.tag.flickr.flickrtagsearch.di.module.rest

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.tag.flickr.flickrtagsearch.BuildConfig
import com.tag.flickr.flickrtagsearch.Config
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit {
        val okHttpBuilder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            okHttpBuilder.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }

        return Retrofit.Builder()
                .baseUrl(Config.FLICKR_API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(okHttpBuilder.build())
                .build()
    }

    @Singleton
    @Provides
    fun provideSearchApi(retrofit: Retrofit): SearchApi =
            retrofit.create(SearchApi::class.java)

}