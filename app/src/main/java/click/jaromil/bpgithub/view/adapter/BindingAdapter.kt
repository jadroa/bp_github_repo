package click.jaromil.bpgithub.view.adapter

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import click.jaromil.bpgithub.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("items")
fun <T>setItems(recyclerView: RecyclerView, items: MutableList<T>?) {
    items?.let {
        if (recyclerView.adapter != null) {
            (recyclerView.adapter as BaseAdapter<T>).setData(items)
        }
    }
}

@BindingAdapter("circleImageUrl")
fun setCircleImageUrl(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url)
        .apply(RequestOptions().placeholder(R.drawable.default_contributor))
        .apply(RequestOptions().error(R.drawable.default_contributor))
        .apply(RequestOptions.circleCropTransform())
        .into(imageView)
}