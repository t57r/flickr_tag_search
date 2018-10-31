package com.tag.flickr.flickrtagsearch

import android.app.Activity
import android.app.Application
import android.content.Context
import com.tag.flickr.flickrtagsearch.di.AppComponent
import com.tag.flickr.flickrtagsearch.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    lateinit var appComponent: AppComponent

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build()
        appComponent.inject(this)

    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector

    companion object {
        fun get(context: Context): App = context.applicationContext as App
    }

}