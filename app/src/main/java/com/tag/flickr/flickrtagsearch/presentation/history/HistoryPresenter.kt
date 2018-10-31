package com.tag.flickr.flickrtagsearch.presentation.history

import com.tag.flickr.flickrtagsearch.di.module.db.TagHistoryStorage
import com.tag.flickr.flickrtagsearch.presentation.base.BasePresenter
import javax.inject.Inject

class HistoryPresenter @Inject constructor(
        view: HistoryContract.View,
        private val tagHistoryStorage: TagHistoryStorage
): BasePresenter<HistoryContract.View>(view), HistoryContract.Presenter {

    override fun getHistory() {
        val history = tagHistoryStorage.getHistory()
        view.setHistory(history)
    }

}