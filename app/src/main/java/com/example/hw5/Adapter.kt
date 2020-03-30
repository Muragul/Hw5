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


class Adapter(
    var mainList: List<News>,
    var fragmentLikeListener: FragmentLikeListener,
    var fragmentButtonListener: FragmentButtonListener
) : RecyclerView.Adapter<Adapter.NewsViewHolder>() {

    inner class NewsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(news: News?) {
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
            }
            view.setOnClickListener {
                val intent = Intent(view.context, NewsDetailActivity::class.java)
                intent.putExtra("news", news)
                view.context.startActivity(intent)
            }


            likeBtn.setOnClickListener {
                if (fragmentButtonListener != null) {
                    if (news!!.isLiked) {
                        Glide.with(view.context).load(R.drawable.like).into(likeBtn)
                        fragmentLikeListener.removeItemLike(news)
                        news.isLiked = false
                    } else {
                        Glide.with(view.context).load(R.drawable.liked).into(likeBtn)
                        fragmentButtonListener.myClick(news, 1)
                        news.isLiked = true
                    }
                }
            }
        }
    }

    interface FragmentButtonListener {
        fun myClick(news: News, option: Int)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
    interface ItemClickListener {
        fun itemClick(position: Int, item: News?)
    }

    interface FragmentLikeListener {
        fun removeItemLike(news: News)
    }

    public fun removeLike(news: News) {
        var n: Int = mainList.indexOf(news)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int = mainList.size

    override fun onBindViewHolder(holder: Adapter.NewsViewHolder, position: Int) {
        holder.bind(mainList[position])
    }

}
/*
class Adapter(var newsList: List<News>):RecyclerView.Adapter<Adapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(
            parent.context
        )
            .inflate(
                R.layout.item_news,
                parent,
                false
            )
        val params = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        view.layoutParams = params
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int = newsList?.size

    override fun onBindViewHolder(holder: Adapter.NewsViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    inner class NewsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(news: News?) {
            val author: TextView = view.findViewById(R.id.author)
            var likesCnt: TextView = view.findViewById(R.id.likesCnt)
            var postText: TextView = view.findViewById(R.id.postText)
            var date:TextView = view.findViewById(R.id.date)
            var postImage: ImageView = view.findViewById(R.id.postImage)
            var profilePhoto:ImageView = view.findViewById(R.id.profilePhoto)


            Glide.with(view.context).load(news?.profilePhoto).into(profilePhoto)
            Glide.with(view.context).load(news?.postImage).into(postImage)
            author.text = news?.author
            val s = "<b>" + news?.author + "</b>" + " " + news?.postText
            postText.text = Html.fromHtml(s)
            date.text = news?.date
            likesCnt.text = news?.likesCnt.toString() + " likes"

            view.setOnClickListener {
                val intent = Intent(view.context, NewsDetailActivity::class.java)
                intent.putExtra("news", news)
                intent.putExtra("index", newsList.indexOf(news))
                view.context.startActivity(intent)
            }

        }
    }
}
/*


 */