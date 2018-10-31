package com.tag.flickr.flickrtagsearch.presentation.base

abstract class BasePresenter<T>(baseView: T) {

    val view: T = baseView

    open fun onStop() {
    }

}