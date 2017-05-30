package com.webonise.kotlin.demo.view

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Toast
import com.webonise.kotlin.demo.R
import com.webonise.kotlin.demo.adapter.BooksListSearchAdapter
import com.webonise.kotlin.demo.interfaces.BooksListSearchActivityView
import com.webonise.kotlin.demo.models.BooksListModel
import com.webonise.kotlin.demo.presenter.BooksListSearchActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*

class BooksListSearchActivity : Activity(), View.OnClickListener, AdapterView.OnItemClickListener, BooksListSearchActivityView {


    internal var mBooksListAdapter: BooksListSearchAdapter? = null
    internal var mSharedPreferences: SharedPreferences? = null
    internal var mMainActivityPresenter: BooksListSearchActivityPresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        main_button.setOnClickListener(this)
        main_listview.onItemClickListener = this
        mMainActivityPresenter = BooksListSearchActivityPresenter(this)
        displayWelcome()

        mBooksListAdapter = BooksListSearchAdapter(this, layoutInflater)
        main_listview.adapter = mBooksListAdapter

    }

    private fun displayWelcome() {

        mSharedPreferences = getSharedPreferences(PREFS, Context.MODE_PRIVATE)

        val name = mSharedPreferences!!.getString(PREF_NAME, "")

        if (name!!.length > 0) {
            Toast.makeText(this, "Welcome Back, $name!", Toast.LENGTH_SHORT).show()
        } else {
            showAlertBox()
        }
    }

    private fun showAlertBox() {
        val alert = AlertDialog.Builder(this)
        alert.setCancelable(false)
        alert.setTitle("Hello!")
        alert.setMessage("What is your name?")

        val input = EditText(this)

        alert.setView(input)
        alert.setPositiveButton("OK")
        {
            dialog, whichButton ->

            val inputName = input.text.toString()
            val e = mSharedPreferences!!.edit()
            e.putString(PREF_NAME, inputName)
            e.commit()

            Toast.makeText(applicationContext, "Welcome, $inputName", Toast.LENGTH_SHORT).show()
        }

        alert.setNegativeButton("Cancel")
        {
            dialog, whichButton ->
        }

        alert.show()
    }

    override fun onClick(v: View?) {
        queryBooks(main_edittext.text.toString())
    }

    private fun queryBooks(searchString: String) {

        mMainActivityPresenter!!.getBooksList(searchString)

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val coverId = mBooksListAdapter!!.getItem(position)!!.coverI

        val detailIntent = Intent(this, BookDetailActivity::class.java)

        detailIntent.putExtra("coverID", coverId)

        startActivity(detailIntent)
    }

    companion object {
        private val PREFS = "prefs"
        private val PREF_NAME = "name"
    }

    override fun updateUi(booksList: MutableList<BooksListModel>?) {
        mBooksListAdapter!!.updateData(booksList!!)
    }

    override fun updateError() {
    }

}
