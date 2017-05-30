package com.webonise.kotlin.demo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.webonise.kotlin.demo.R
import com.webonise.kotlin.demo.models.BooksListModel

/**
 * Class JSONAdapter created on 5/22/17.
 */
public class BooksListSearchAdapter : BaseAdapter {


    private val IMAGE_URL_BASE = "http://covers.openlibrary.org/b/id/"

    internal var mContext: Context? = null
    internal var mInflater: LayoutInflater? = null
    internal var mJsonArray: List<BooksListModel>? = null

    constructor(mContext: Context?, mInflater: LayoutInflater?) : super() {
        this.mContext = mContext
        this.mInflater = mInflater
        mJsonArray = ArrayList<BooksListModel>()
    }

    fun updateData(jsonArray: List<BooksListModel>) {

        // update the adapter's dataset
        mJsonArray=jsonArray
        notifyDataSetChanged()
    }
    override fun getItem(position: Int): BooksListModel? = mJsonArray?.get(position)

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = mJsonArray!!.size


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var convertView = convertView

        val holder: ViewHolder

        // check if the view already exists
        // if so, no need to inflate and findViewById again!
        if (convertView == null) {

            // Inflate the custom row layout from your XML.
            convertView = mInflater!!.inflate(R.layout.row_book, null)

            // create a new "Holder" with subviews
            holder = ViewHolder()
            holder.mThumbnailImageView = convertView
                    .findViewById(R.id.img_thumbnail) as ImageView
            holder.mTitleTextView = convertView
                    .findViewById(R.id.text_title) as TextView
            holder.mAuthorTextView = convertView
                    .findViewById(R.id.text_author) as TextView

            // hang onto this holder for future recyclage
            convertView.setTag(holder)
        } else {

            // skip all the expensive inflation/findViewById
            // and just get the holder you already made
            holder = convertView.tag as ViewHolder
        }

        // Get the current book's data in JSON form
        val jsonObject = getItem(position)

        // See if there is a cover ID in the Object
        if (jsonObject!!.coverI==0) {

            // If so, grab the Cover ID out from the object
            val imageID = jsonObject!!.coverI

            // Construct the image URL (specific to API)
            val imageURL = IMAGE_URL_BASE+imageID+"-S.jpg"

            // Use Picasso to load the image
            // Temporarily have a placeholder in case it's slow to load
            Picasso.with(mContext)
                    .load(imageURL)
                    .placeholder(R.drawable.ic_books)
                    .into(holder.mThumbnailImageView)
        } else {

            // If there is no cover ID in the object, use a placeholder
            holder.mThumbnailImageView!!
                    .setImageResource(R.drawable.ic_books)
        }

        // Grab the title and author from the JSON
        var bookTitle = ""
        var authorName = ""

            bookTitle = jsonObject!!.title!!


            authorName = jsonObject!!.authorName!!.get(0)

        // Send these Strings to the TextViews for display
        holder.mTitleTextView!!.text = bookTitle
        holder.mAuthorTextView!!.text = authorName

        return convertView!!
    }

    // this is used so you only ever have to do
    // inflation and finding by ID once ever per View
    private class ViewHolder {
        var mThumbnailImageView: ImageView? = null
        var mTitleTextView: TextView? = null
        var mAuthorTextView: TextView? = null
    }

}