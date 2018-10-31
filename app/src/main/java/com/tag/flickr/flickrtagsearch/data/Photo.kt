package com.tag.flickr.flickrtagsearch.data

import com.google.gson.annotations.SerializedName

data class Photo(
   @SerializedName("id") val id: String,
   @SerializedName("secret") val secret: String,
   @SerializedName("server") val server: String,
   @SerializedName("farm") val farm: String
)

fun Photo.toFlickrImageUrl() = "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"