package com.tag.flickr.flickrtagsearch.presentation.base

import android.support.v7.app.AppCompatActivity

abstract class BasePresenterActivity : AppCompatActivity() {

    protected abstract val activityPresenter: BasePresenter<*>

    override fun onStop() {
        super.onStop()
        activityPresenter.onStop()
    }

}