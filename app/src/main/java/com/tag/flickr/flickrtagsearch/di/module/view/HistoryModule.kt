package com.tag.flickr.flickrtagsearch.di.module.view

import com.tag.flickr.flickrtagsearch.di.scope.ActivityScope
import com.tag.flickr.flickrtagsearch.presentation.history.HistoryActivity
import com.tag.flickr.flickrtagsearch.presentation.history.HistoryContract
import dagger.Module
import dagger.Provides

@Module
class HistoryModule {
    @Provides
    @ActivityScope
    fun provideHistoryModule(activity: HistoryActivity): HistoryContract.View {
        return activity
    }
}