package com.tag.flickr.flickrtagsearch.di.module

import android.content.Context
import com.tag.flickr.flickrtagsearch.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideApplication(app: App): Context = app
}