package com.tag.flickr.flickrtagsearch.data

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("photos") val photos: PhotosPage,
    @SerializedName("stat") val stat: String
)

fun SearchResponse.isStatusOk() = stat == "ok"