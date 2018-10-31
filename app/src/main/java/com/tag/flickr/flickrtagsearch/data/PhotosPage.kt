package com.tag.flickr.flickrtagsearch.data

import com.google.gson.annotations.SerializedName

data class PhotosPage(
    @SerializedName("page") val page: Int,
    @SerializedName("pages") val pages: String,
    @SerializedName("perpage") val perpage: Int,
    @SerializedName("total") val total: String,
    @SerializedName("photo") val photo: List<Photo>
)