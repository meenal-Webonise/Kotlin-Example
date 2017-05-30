package com.webonise.kotlin.demo.presenter

import android.util.Log
import com.webonise.kotlin.demo.interfaces.BooksListSearchActivityView
import com.webonise.kotlin.demo.models.BooksListModel
import com.webonise.kotlin.demo.models.BooksMainModel
import com.webonise.kotlin.demo.webservice.APIInterface
import com.webonise.kotlin.demo.webservice.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BooksListSearchActivityPresenter {

    internal var booksListSearchActivityView: BooksListSearchActivityView? = null

    internal var booksList: List<BooksListModel>? = null

    constructor(booksListSearchActivityView: BooksListSearchActivityView) {
        this.booksListSearchActivityView = booksListSearchActivityView
    }


    fun getBooksList(searchString: String) {
        booksList = ArrayList<BooksListModel>()

        val apiClient: ApiClient = ApiClient()
        val apiInterface: APIInterface = apiClient.getClient().create(APIInterface::class.java)

        val booksListCall = apiInterface.getBooksList(searchString)

        booksListCall.enqueue(object : Callback<BooksMainModel> {
            override fun onResponse(call: Call<BooksMainModel>, response: Response<BooksMainModel>) {
                booksList = response.body()!!.booksModelList
                if (booksList!!.size > 0)
                    booksListSearchActivityView!!.updateUi(booksList)
            }

            override fun onFailure(call: Call<BooksMainModel>, t: Throwable) {
                Log.d("TAG", "Error::" + t.message)
                booksListSearchActivityView!!.updateError()
            }
        });
    }

}