package com.tag.flickr.flickrtagsearch.presentation.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View

import com.tag.flickr.flickrtagsearch.R
import com.tag.flickr.flickrtagsearch.di.module.rest.ImageDownloader
import com.tag.flickr.flickrtagsearch.extension.hideKeyboard
import com.tag.flickr.flickrtagsearch.extension.showToast
import com.tag.flickr.flickrtagsearch.presentation.base.BasePresenter
import com.tag.flickr.flickrtagsearch.presentation.base.BasePresenterActivity
import com.tag.flickr.flickrtagsearch.presentation.history.HistoryActivity

import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BasePresenterActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainPresenter
    override val activityPresenter: BasePresenter<*>
        get() = presenter

    @Inject
    lateinit var imageDownloader: ImageDownloader

    private lateinit var photoAdapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        photoAdapter = PhotoAdapter(imageDownloader)
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, RECYCLER_SPANS)
            adapter = photoAdapter
        }

        historyImageView.setOnClickListener(::onHistoryClicked)
        searchButton.setOnClickListener(::onSearchButtonClicked)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == HISTORY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val historyItem = HistoryActivity.parseResult(data)
            historyItem?.let {
                searchEditText.setText(it)
                presenter.searchPhotos(it)
            }
        }
    }

    private fun onHistoryClicked(view: View) {
        if (presenter.isHistoryEmpty()) {
            showToast("There're no history items")
            return
        }

        val intent = Intent(this, HistoryActivity::class.java)
        startActivityForResult(intent, HISTORY_REQUEST_CODE)
    }

    private fun onSearchButtonClicked(view: View) {
        val searchInput = searchEditText.text.toString()
        val tags = presenter.transformToValidTags(searchInput)
        tags?.let {
            hideKeyboard()
            presenter.addTagsToHistory(it)
            presenter.searchPhotos(it)
        } ?: run {
            showToast(R.string.please_input_tags)
        }
    }

    override fun setPhotoUrls(photoUrls: List<String>) {
        photoAdapter.addPhotoUrls(photoUrls)
    }

    override fun showErrorMessage(errorMessage: String?) {
        showToast("Failed $errorMessage")
    }

    companion object {
        private const val HISTORY_REQUEST_CODE = 1001
        private const val RECYCLER_SPANS = 2
    }
}
