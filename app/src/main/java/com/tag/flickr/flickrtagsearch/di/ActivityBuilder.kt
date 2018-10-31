package com.tag.flickr.flickrtagsearch.di

import com.tag.flickr.flickrtagsearch.di.module.view.HistoryModule
import com.tag.flickr.flickrtagsearch.di.module.view.MainModule
import com.tag.flickr.flickrtagsearch.di.scope.ActivityScope
import com.tag.flickr.flickrtagsearch.presentation.history.HistoryActivity
import com.tag.flickr.flickrtagsearch.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [HistoryModule::class])
    abstract fun bindHistoryActivity(): HistoryActivity
}