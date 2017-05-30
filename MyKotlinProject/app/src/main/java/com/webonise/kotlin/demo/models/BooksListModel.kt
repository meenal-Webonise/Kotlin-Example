package com.webonise.kotlin.demo.models

import com.google.gson.annotations.SerializedName

/**
 * Class BooksListModel created on 5/22/17.
 */

class BooksListModel {

    @com.google.gson.annotations.SerializedName("title_suggest")
    var titleSuggest: String? = null
    @com.google.gson.annotations.SerializedName("edition_key")

    var editionKey: List<String>? = null
    @com.google.gson.annotations.SerializedName("cover_i")

    var coverI: Int? = null
    @com.google.gson.annotations.SerializedName("isbn")

    var isbn: List<String>? = null
    @com.google.gson.annotations.SerializedName("has_fulltext")

    var hasFulltext: Boolean? = null
    @com.google.gson.annotations.SerializedName("text")

    var text: List<String>? = null
    @com.google.gson.annotations.SerializedName("author_name")

    var authorName: List<String>? = null
    @com.google.gson.annotations.SerializedName("seed")

    var seed: List<String>? = null
    @com.google.gson.annotations.SerializedName("oclc")

    var oclc: List<String>? = null
    @com.google.gson.annotations.SerializedName("author_key")

    var authorKey: List<String>? = null
    @com.google.gson.annotations.SerializedName("title")

    var title: String? = null
    @com.google.gson.annotations.SerializedName("publish_date")

    var publishDate: List<String>? = null
    @com.google.gson.annotations.SerializedName("type")

    var type: String? = null
    @com.google.gson.annotations.SerializedName("ebook_count_i")

    var ebookCountI: Int? = null
    @com.google.gson.annotations.SerializedName("edition_count")

    var editionCount: Int? = null
    @com.google.gson.annotations.SerializedName("key")

    var key: String? = null
    @com.google.gson.annotations.SerializedName("publisher")

    var publisher: List<String>? = null
    @com.google.gson.annotations.SerializedName("language")

    var language: List<String>? = null
    @com.google.gson.annotations.SerializedName("last_modified_i")

    var lastModifiedI: Int? = null
    @com.google.gson.annotations.SerializedName("cover_edition_key")

    var coverEditionKey: String? = null
    @com.google.gson.annotations.SerializedName("publish_year")

    var publishYear: List<Int>? = null
    @com.google.gson.annotations.SerializedName("first_publish_year")

    var firstPublishYear: Int? = null


}
