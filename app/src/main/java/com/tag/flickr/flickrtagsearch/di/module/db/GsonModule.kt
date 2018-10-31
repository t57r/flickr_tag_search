package com.tag.flickr.flickrtagsearch.di.module.db

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class GsonModule {

    @Singleton
    @Provides
    fun provideGson() = Gson()

}