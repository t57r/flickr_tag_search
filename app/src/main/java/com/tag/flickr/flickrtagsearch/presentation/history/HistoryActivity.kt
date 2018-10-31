package com.tag.flickr.flickrtagsearch.presentation.history

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.tag.flickr.flickrtagsearch.R
import com.tag.flickr.flickrtagsearch.presentation.base.BasePresenter
import com.tag.flickr.flickrtagsearch.presentation.base.BasePresenterActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_history.*
import javax.inject.Inject

class HistoryActivity : BasePresenterActivity(), HistoryContract.View {

    @Inject
    lateinit var presenter: HistoryPresenter
    override val activityPresenter: BasePresenter<*>
        get() = presenter

    private val historyAdapter = HistoryAdapter(::onHistoryItemClicked)

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@HistoryActivity)
            adapter = historyAdapter
        }

        presenter.getHistory()
    }

    private fun onHistoryItemClicked(historyItem: String) {
        setResult(Activity.RESULT_OK, createResult(historyItem))
        finish()
    }

    override fun setHistory(tags: List<String>) {
        historyAdapter.addHistoryItems(tags)
    }

    companion object {
        private const val HISTORY_ITEM_EXTRA = "HISTORY_ITEM_EXTRA"
        private fun createResult(historyItem: String) = Intent().apply {
            putExtra(HISTORY_ITEM_EXTRA, historyItem)
        }
        fun parseResult(data: Intent?) = data?.extras?.getString(HISTORY_ITEM_EXTRA)
    }

}