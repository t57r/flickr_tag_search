package com.tag.flickr.flickrtagsearch.di.module.db

import android.content.SharedPreferences
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TagHistoryStorageModule {

    @Singleton
    @Provides
    fun provideTagHistoryStorage(
            sharedPreferences: SharedPreferences,
            gson: Gson
    ) = object : TagHistoryStorage {

        override fun isHistoryEmpty() = getHistory().isEmpty()

        override fun addTags(tags: String) {
            val newHistory = mutableListOf<String>()
            newHistory.addAll(getHistory())
            newHistory.add(0, tags)
            storeJsonObject(newHistory, HISTORY_PREF)
        }

        override fun getHistory(): List<String> {
            return restoreJsonList(HISTORY_PREF, String::class.java) ?: emptyList()
        }

        private fun storeJsonObject(src: Any?, key: String) {
            val json = gson.toJson(src)
            sharedPreferences
                    .edit()
                    .putString(key, json)
                    .apply()
        }

        private fun <T> restoreJsonList(key: String, classOfT: Class<T>): List<T>? {
            val json = sharedPreferences.getString(key, "")
            return gson.fromJson<List<T>>(json, ListParameterizedType(classOfT))
        }
    }

    companion object {
        private const val HISTORY_PREF = "HISTORY_PREF"
    }

}