package com.example.konrad.portfolio.utils

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.konrad.portfolio.R
import com.example.konrad.portfolio.utils.extensions.getParentActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.countries_item.view.*

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer { value -> view.visibility = value?: View.VISIBLE})
    }
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value?:""})
    }
}

@BindingAdapter("imageUrl")
fun setImageUrl(view: ImageView, url: String) {
    //hack for radius 0 from svg
    if(!url.equals("https://restcountries.eu/data/blz.svg") and !url.equals("https://restcountries.eu/data/gtm.svg") and !url.equals("https://restcountries.eu/data/shn.svg") and !url.equals("https://restcountries.eu/data/svn.svg") and !url.equals("https://restcountries.eu/data/som.svg") and !url.equals("https://restcountries.eu/data/spm.svg") and !url.equals("https://restcountries.eu/data/slb.svg"))
        Utils.fetchSvg(view.context, url, view)

}