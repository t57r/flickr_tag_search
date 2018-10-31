package com.tag.flickr.flickrtagsearch.extension

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

fun Activity.hideKeyboard() {
    currentFocus?.let {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
    }
}

fun Activity.showToast(messageId: Int, toastLength: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, messageId, toastLength).show()
}

fun Activity.showToast(message: String, toastLength: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, toastLength).show()
}