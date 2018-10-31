package com.tag.flickr.flickrtagsearch.presentation.main

import com.tag.flickr.flickrtagsearch.data.SearchResponse
import com.tag.flickr.flickrtagsearch.data.isStatusOk
import com.tag.flickr.flickrtagsearch.data.toFlickrImageUrl
import com.tag.flickr.flickrtagsearch.di.module.db.TagHistoryStorage
import com.tag.flickr.flickrtagsearch.di.module.rest.SearchApi
import com.tag.flickr.flickrtagsearch.extension.runAsync
import com.tag.flickr.flickrtagsearch.extension.whenNotNullNorEmpty
import com.tag.flickr.flickrtagsearch.presentation.base.BaseJobPresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(
        view: MainContract.View,
        private val searchApi: SearchApi,
        private val tagHistoryStorage: TagHistoryStorage
): BaseJobPresenter<MainContract.View>(view), MainContract.Presenter {

    override fun searchPhotos(tags: String) {
        searchApi.searchPhotos(tags).runAsync(job,
                onSuccess = ::onSearchResponseReceived,
                onFailed = view::showErrorMessage)
    }

    private fun onSearchResponseReceived(searchResponse: SearchResponse) {
        if (searchResponse.isStatusOk()) {
            searchResponse.photos.photo.whenNotNullNorEmpty {
                val photoUrls = it.map { it.toFlickrImageUrl() }
                view.setPhotoUrls(photoUrls)
            }
        }
    }

    override fun transformToValidTags(searchInput: String) = if (searchInput.isBlank())
        null
    else
        searchInput.split(" ").joinToString(",")

    override fun addTagsToHistory(tags: String) {
        tagHistoryStorage.addTags(tags)
    }

    override fun isHistoryEmpty() = tagHistoryStorage.isHistoryEmpty()
}