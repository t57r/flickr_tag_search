package com.tag.flickr.flickrtagsearch.presentation.main

interface MainContract {

    interface View {
        fun setPhotoUrls(photoUrls: List<String>)
        fun showErrorMessage(errorMessage: String?)
    }

    interface Presenter {
        fun transformToValidTags(searchInput: String): String?
        fun searchPhotos(tags: String)
        fun addTagsToHistory(tags: String)
        fun isHistoryEmpty(): Boolean
    }
}