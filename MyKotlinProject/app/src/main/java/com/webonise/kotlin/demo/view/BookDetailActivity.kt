package com.webonise.kotlin.demo.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.webonise.kotlin.demo.R
import kotlinx.android.synthetic.main.activity_detail.*


class BookDetailActivity : AppCompatActivity() {

    internal var mImageUrl = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val coverId = this.intent.getIntExtra("coverID", 0)

        if (coverId != 0) {
            mImageUrl = IMAGE_BASE_URL + coverId + IMAGE_SIZE

            Picasso.with(this).load(mImageUrl).placeholder(R.drawable.img_books_loading).into(img_cover)
        }
    }

    companion object {
        private val IMAGE_BASE_URL = "http://covers.openlibrary.org/b/id/"
        private val IMAGE_SIZE = "-L.jpg"
    }
}
