package com.tag.flickr.flickrtagsearch.extension

import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

fun <R: Any, T : Deferred<R>> T.runAsync(
        job: Job,
        onSuccess: (result: R) -> Unit,
        onFailed: (errorMsg: String?) -> Unit) {
    launch(UI, parent = job) {
        try {
            val result = this@runAsync.await()
            onSuccess(result)
        } catch (e: Exception) {
            onFailed(e.message)
        }
    }
}