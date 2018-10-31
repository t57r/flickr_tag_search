package com.tag.flickr.flickrtagsearch.extension

inline fun <E : Any, T : Collection<E>> T?.whenNotNullNorEmpty(func: (T) -> Unit): Any? {
    return if (this != null && this.isNotEmpty()) {
        func(this)
        Any()
    } else null
}