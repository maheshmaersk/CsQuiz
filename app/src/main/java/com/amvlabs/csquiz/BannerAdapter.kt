package com.amvlabs.csquiz

import android.accounts.AccountManager.get
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

class BannerAdapter(val context: Context, val imagesds: ArrayList<String>,val imageList: ArrayList<Int>) : PagerAdapter() {
    override fun getCount(): Int {
        return imagesds.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as RelativeLayout
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val infl = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val item = infl.inflate(R.layout.banner_item_adapter,container,false)
        val image = item.findViewById<AppCompatImageView>(R.id.idIVImage)
//        image.setImageResource(imageList[position])

//        Picasso.with(context).load(imagesds[position]).into(image)
        Glide.with(context)
            .load(imagesds[position])
            .override(300, 200)
            .into(image);
        Objects.requireNonNull(container).addView(item)
        return item
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
       container.removeView(`object` as RelativeLayout)
    }

}