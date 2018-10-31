package com.tag.flickr.flickrtagsearch.di.module.rest

import com.tag.flickr.flickrtagsearch.Config
import com.tag.flickr.flickrtagsearch.data.SearchResponse
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("services/rest/?method=flickr.photos.search")
    fun searchPhotos(
            @Query("tags") tags: String,
            @Query("api_key") apiKey: String = Config.FLICKR_API_KEY,
            @Query("format") format: String = "json",
            @Query("nojsoncallback") nojsoncallback: Int = 1
    ): Deferred<SearchResponse>
}