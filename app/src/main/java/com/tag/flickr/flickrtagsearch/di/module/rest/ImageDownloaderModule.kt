package com.tag.flickr.flickrtagsearch.di.module.rest

import android.widget.ImageView
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ImageDownloaderModule {

    @Singleton
    @Provides
    fun providePicasso() = Picasso.get()

    @Singleton
    @Provides
    fun provideImageDownloader(picasso: Picasso) = object : ImageDownloader {
        override fun download(imageView: ImageView, imageUrl: String) {
            picasso.load(imageUrl).into(imageView)
        }

    }
}