package com.example.hw5

import android.os.Bundle
import android.text.Html
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class NewsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)


        var back: ImageButton = findViewById(R.id.back)
        var likeBtn: ImageView = findViewById(R.id.likeBtn)
        var saveBtn: ImageView = findViewById(R.id.saveBtn)
        var profilePhoto: ImageView = findViewById(R.id.profilePhoto)
        var author: TextView = findViewById(R.id.author)
        var postImage: ImageView = findViewById(R.id.postImage)
        var postText: TextView = findViewById(R.id.postText)
        var date: TextView = findViewById(R.id.date)
        var likesCnt: TextView = findViewById(R.id.likesCnt)

        val news: News = intent.getSerializableExtra("news") as News

        Glide.with(this).load(news.profilePhoto).into(profilePhoto)
        Glide.with(this).load(news.postImage).into(postImage)
        author.text = news.author
        var s: String = "<b>"+news.author+"</b>"+" "+news.postText
        postText.text = Html.fromHtml(s)
        date.text = news.date
        likesCnt.text = news.likesCnt.toString()+" likes"
        back.setOnClickListener{
            onBackPressed()
        }
    }
}
