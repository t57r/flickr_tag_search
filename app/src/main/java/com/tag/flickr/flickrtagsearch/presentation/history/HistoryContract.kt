package com.tag.flickr.flickrtagsearch.presentation.history

interface HistoryContract {

    interface View {
        fun setHistory(tags: List<String>)
    }

    interface Presenter {
        fun getHistory()
    }

}