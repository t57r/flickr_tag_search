package com.tag.flickr.flickrtagsearch.di

import com.tag.flickr.flickrtagsearch.App
import com.tag.flickr.flickrtagsearch.di.module.AppModule
import com.tag.flickr.flickrtagsearch.di.module.db.GsonModule
import com.tag.flickr.flickrtagsearch.di.module.db.SharedPreferencesModule
import com.tag.flickr.flickrtagsearch.di.module.db.TagHistoryStorageModule
import com.tag.flickr.flickrtagsearch.di.module.rest.ApiModule
import com.tag.flickr.flickrtagsearch.di.module.rest.ImageDownloaderModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    ApiModule::class,
    ImageDownloaderModule::class,
    SharedPreferencesModule::class,
    GsonModule::class,
    TagHistoryStorageModule::class,
    AndroidInjectionModule::class,
    ActivityBuilder::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)

}