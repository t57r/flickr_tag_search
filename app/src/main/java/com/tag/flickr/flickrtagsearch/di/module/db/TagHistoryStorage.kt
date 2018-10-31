package com.tag.flickr.flickrtagsearch.di.module.db

interface TagHistoryStorage {
    fun addTags(tags: String)
    fun getHistory(): List<String>
    fun isHistoryEmpty(): Boolean
}