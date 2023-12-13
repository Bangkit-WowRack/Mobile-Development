package com.wowrack.cloudrayaapps.data.dummy

import com.wowrack.cloudrayaapps.data.model.ArticleData
import com.wowrack.cloudrayaapps.data.model.ArticlesResponse
import com.wowrack.cloudrayaapps.data.model.Categories
import com.wowrack.cloudrayaapps.data.model.Creator

fun getDummyArticleResponse(): ArticlesResponse {
    val articleData = listOf(
        ArticleData(
            id = 24,
            type = "news",
            categoryId = 1,
            yearUpdate = null,
            quarterUpdate = null,
            title = "Important Notice: Managed Service Price Adjustment Starting September 1st, 2023",
            content = "We would like to inform you about a price adjustment for our 'Managed Service.' Starting September 1st, 2023, there will be adjustments to the pricing as follows:\n\n1. New Price: IDR 750K per hour (formerly IDR 650K per hour)\n2. Bundle of 3 hours: IDR 1950K (formerly IDR 1650K)\n\nWe are making this adjustment to ensure we continuously provide you with the best experience from our team of expert support professionals. Additionally, due to the rapid growth of our customer base, we have expanded our support team to ensure prompt responses and timely solutions for all your requests and needs.\n\nIf you wish to take advantage of the bundle offer at the current price, you still have the opportunity to do so before the effective date of the price adjustment.\n\nShould there be any questions or if you require assistance related to our services, please feel free to reach out to our support team at support@wowrack.co.id.\n\nThank you for your understanding and continued support. We remain dedicated to providing you with exceptional solutions and services for your business.\n\nWarm regards, Cloud Raya Team",
            creatorType = "admin",
            creator = Creator(
                id = 85,
                name = " "
            ),
            status = 1,
            statusMsg = "active",
            createdAt = "2023-07-31 03:21:29",
            updatedAt = "2023-07-31 09:49:52",
            categories = Categories(
                id = 1,
                name = "Feature & Product Updates",
                creatorId = 1
            )
        ),
        ArticleData(
            id = 23,
            type = "news",
            categoryId = 5,
            yearUpdate = null,
            quarterUpdate = null,
            title = "Quest Raya: Here's Where Your Cloud Adventure Begins",
            content = "Calling all Cloud Adventurers! \n\nYou are challenged to join and complete all quests on Quest Raya. \n\nIt is an adventurous competition held by Cloud Raya, where you should finish all quests by exploring Cloud Raya’s website (www.cloudraya.com). \nEach quest has a certain score. The more score you get, the more chances you have to win exciting rewards such as keyboard, wireless headset, TWS, and many more. \n\nEasy steps to join Quest Raya: \n1. Repost content about Quest Raya on Cloud Raya’s Instagram @cloudraya. \n2. Stay tuned to @cloudraya’s story updates to get your weekly quests. \n3. Explore www.cloudraya.com to complete all quests. \n4. Fill up the form we provided with the correct answer and the page URL where you find the answers. \n5. We’ll share leader board every Sunday each week, and the final score will be announced on August 13th 2023 by Instagram Post and E-mail. \n\nBefore you decided to join, we encourage you to learn the T&C for a better experience. \n\nTerms and Conditions \n\nSo, what are you waiting for? Start your quest today! \n\nI’M IN\n",
            creatorType = "admin",
            creator = Creator(
                id = 85,
                name = " "
            ),
            status = 1,
            statusMsg = "active",
            createdAt = "2023-07-12 22:19:13",
            updatedAt = "2023-07-12 22:53:18",
            categories = Categories(
                id = 5,
                name = "Event",
                creatorId = 1
            ),
        ),
        ArticleData(
            id = 22,
            type = "news",
            categoryId = 4,
            yearUpdate = null,
            quarterUpdate = null,
            title = "Promo KETUPAT! Get IDR 250K for First Top Up",
            content = "Eid Mubarak! \n\nTo celebrate this victorious event, Cloud Raya would love to give IDR 250.000 FREE credit for first toppers through promo KETUPAT: Kerja Tenang, Untung Berlipat. \n\nWith this promo, Cloud Raya wants you to have a warm quality time with your family while having more credits to support your projects. \n\nThe IDR 250.000 free credit can be used for all services and features in Cloud Raya, including:\n1. Deploying Virtual Machines\n2. Creating Buckets in Storage Raya\n3. Adding features, resources, licenses, and many more. \n\nThis promo period is 11 April - 31 Mei 2023, make sure you get this limited offer in time! \n \nCheck the promo details and how to claim it by clicking, here!",
            creatorType = "admin",
            creator = Creator(
                id = 85,
                name = " "
            ),
            status = 1,
            statusMsg = "active",
            createdAt = "2023-05-03 23:36:21",
            updatedAt = "2023-05-03 23:36:21",
            categories = Categories(
                id = 4,
                name = "Promo",
                creatorId = 1
            ),
        )
    )

    return ArticlesResponse(
        code = 200,
        data = articleData,
        message = "Successfully get active news list data with custom page."
    )
}