package com.example.music_info

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

open class CategoryAdapter(context: Context) : BaseAdapter() {

    private val rCategoryImage = mutableListOf<Int>(R.drawable.pop_music, R.drawable.house_music, R.drawable.jazz_music ,R.drawable.music_theatre)
    private val rCategoryName = mutableListOf<String>("POP MUSIC", "HOUSE HOUSE MUSIC", "JAZZ", "MUSIC THEATRE")
    private val rNumberOfArtists = mutableListOf<String>("3 Artists", "3 Artists", "3 Artists", "3 Artists")
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView = inflater.inflate(R.layout.music_category, parent, false)
        val categoryTitles = categoryView.findViewById<TextView>(R.id.category_name)
        val categoryAlbumCounts = categoryView.findViewById<TextView>(R.id.category_album_count)
        val categoryImages = categoryView.findViewById<ImageView>(R.id.category_image)

        categoryImages.setImageResource(rCategoryImage[position])
        categoryTitles.text = rCategoryName[position]
        categoryAlbumCounts.text = rNumberOfArtists[position]

        return categoryView
    }

    override fun getItem(position: Int): Any {
       return getView(position, null, null )
    }

    override fun getItemId(position: Int): Long {
        return rCategoryImage[position].toLong()
    }

    override fun getCount(): Int {
        return rCategoryName.size
    }


}