package com.tag.flickr.flickrtagsearch.di.module.db

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class ListParameterizedType<T>(wrapper: Class<T>) : ParameterizedType {
    private val wrapped: Class<*> = wrapper

    override fun getActualTypeArguments(): Array<Type> = arrayOf(wrapped)

    override fun getRawType(): Type = List::class.java

    override fun getOwnerType() = null
}