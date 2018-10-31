package com.tag.flickr.flickrtagsearch.di.module.rest

import android.widget.ImageView

interface ImageDownloader {
    fun download(imageView: ImageView, imageUrl: String)
}