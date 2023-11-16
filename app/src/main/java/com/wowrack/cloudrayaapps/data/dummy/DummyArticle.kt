package com.wowrack.cloudrayaapps.data.dummy

import com.wowrack.cloudrayaapps.data.model.Article

fun getDummyArticle(): List<Article> {
    return listOf(
        Article(
            id = 1,
            image = "https://picsum.photos/180/90",
        ),
        Article(
            id = 2,
            image = "https://picsum.photos/180/90",
        ),
        Article(
            id = 3,
            image = "https://picsum.photos/180/90",
        ),
        Article(
            id = 4,
            image = "https://picsum.photos/180/90",
        )
    )
}