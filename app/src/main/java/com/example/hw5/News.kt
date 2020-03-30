package com.example.hw5

import java.io.Serializable
import java.util.*

class News(
    var id: Int,
    var author: String,
    var date: String,
    var profilePhoto: Int,
    var likesCnt: Int,
    var postImage: Int,
    var postText: String
) : Serializable {
    var newsList: List<News> = ArrayList()
    var likeBtn = 0
    var isLiked = false
}
