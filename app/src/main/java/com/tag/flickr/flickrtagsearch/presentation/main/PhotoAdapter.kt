package com.tag.flickr.flickrtagsearch.presentation.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.tag.flickr.flickrtagsearch.R
import com.tag.flickr.flickrtagsearch.di.module.rest.ImageDownloader
import com.tag.flickr.flickrtagsearch.extension.inflate
import kotlinx.android.synthetic.main.item_photo.view.*

class PhotoAdapter(
    private val imageDownloader: ImageDownloader
): RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    private val photoUrls = mutableListOf<String>()

    fun addPhotoUrls(photoUrls: List<String>) {
        this.photoUrls.apply {
            clear()
            addAll(photoUrls)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(parent.inflate(R.layout.item_photo), imageDownloader)

    override fun getItemCount()
            = photoUrls.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.bind(photoUrls[position])

    class ViewHolder(
        itemView: View,
        private val imageDownloader: ImageDownloader
    ): RecyclerView.ViewHolder(itemView) {
        fun bind(photoUrl: String) {
            imageDownloader.download(itemView.imageView, photoUrl)
        }
    }
}