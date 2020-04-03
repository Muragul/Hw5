package com.example.hw5

import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class SavesAdapter(
    var mainList: List<News>,
    var fragmentLikeListener: FragmentLikeListener
) : RecyclerView.Adapter<SavesAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(news: News) {
            val author: TextView = view.findViewById(R.id.author)
            var likesCnt: TextView = view.findViewById(R.id.likesCnt)
            var postText: TextView = view.findViewById(R.id.postText)
            var date: TextView = view.findViewById(R.id.date)
            var postImage: ImageView = view.findViewById(R.id.postImage)
            var profilePhoto: ImageView = view.findViewById(R.id.profilePhoto)
            var likeBtn: ImageView = view.findViewById(R.id.likeBtn)

            if (news != null) {
                Glide.with(view.context).load(news.profilePhoto).into(profilePhoto)
                Glide.with(view.context).load(news.postImage).into(postImage)
                author.text = news.author
                val s = "<b>" + news.author + "</b>" + " " + news.postText
                postText.text = Html.fromHtml(s)
                date.text = news.date
                likesCnt.text = news.likesCnt.toString() + " likes"
                Glide.with(view.context).load(R.drawable.liked).into(likeBtn)
            }
            view.setOnClickListener {
                val intent = Intent(view.context, NewsDetailActivity::class.java)
                intent.putExtra("news", news)
                view.context.startActivity(intent)
            }


            likeBtn.setOnClickListener {
                if (fragmentLikeListener != null) {
                    fragmentLikeListener.removeItemLike(news)
                }
            }

        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    interface FragmentLikeListener {
        fun removeItemLike(news: News)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int = mainList.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(mainList[position])
    }

}