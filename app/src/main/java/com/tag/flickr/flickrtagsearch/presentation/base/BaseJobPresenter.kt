package com.tag.flickr.flickrtagsearch.presentation.base

import kotlinx.coroutines.experimental.Job

abstract class BaseJobPresenter<T>(baseView: T): BasePresenter<T>(baseView) {

    protected var job = Job()

    override fun onStop() {
        job.cancel()
        job = Job()
    }
}