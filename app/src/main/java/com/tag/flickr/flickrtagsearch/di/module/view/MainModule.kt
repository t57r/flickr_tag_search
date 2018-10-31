package com.tag.flickr.flickrtagsearch.di.module.view

import com.tag.flickr.flickrtagsearch.di.scope.ActivityScope
import com.tag.flickr.flickrtagsearch.presentation.main.MainActivity
import com.tag.flickr.flickrtagsearch.presentation.main.MainContract
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides
    @ActivityScope
    fun provideMainModule(activity: MainActivity): MainContract.View {
        return activity
    }
}