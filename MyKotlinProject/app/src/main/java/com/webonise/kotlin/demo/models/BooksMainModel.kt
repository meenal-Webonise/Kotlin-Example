package com.webonise.kotlin.demo.models

import com.google.gson.annotations.SerializedName

/**
 * Class BooksMainModel created on 5/23/17.
 */
class BooksMainModel(start: Int = 0, num_found: Int = 0, numFound: Int = 0, @SerializedName("docs") var booksModelList: List<BooksListModel>? = null)