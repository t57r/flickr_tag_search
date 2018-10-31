package com.tag.flickr.flickrtagsearch.presentation.history

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.tag.flickr.flickrtagsearch.R
import com.tag.flickr.flickrtagsearch.extension.inflate
import kotlinx.android.synthetic.main.item_history.view.*

typealias OnHistoryItemClickedListener = (historyItem: String) -> Unit

class HistoryAdapter(
        private val onHistoryItemClickedListener: OnHistoryItemClickedListener
): RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    private val historyItems = mutableListOf<String>()

    fun addHistoryItems(historyItems: List<String>) {
        this.historyItems.apply {
            clear()
            addAll(historyItems)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(parent.inflate(R.layout.item_history), onHistoryItemClickedListener)

    override fun getItemCount()
            = historyItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.bind(historyItems[position])

    class ViewHolder(
        itemView: View,
        private val onHistoryItemClickedListener: OnHistoryItemClickedListener
    ): RecyclerView.ViewHolder(itemView) {
        private lateinit var historyItem: String

        init {
            itemView.setOnClickListener {
                onHistoryItemClickedListener(historyItem)
            }
        }

        fun bind(historyItem: String) {
            this.historyItem = historyItem
            itemView.titleTextView.text = historyItem
        }
    }
}