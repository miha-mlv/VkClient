package com.example.vkclient.domain

import com.example.vkclient.R

data class FeedPost(
    val id: Int = 0,
    val communityName: String = "yvolen",
    val publicationData: String = "14:00",
    val avatarRedId: Int = R.drawable.post_content_image,
    val contentText: String = "Text Text Text Text Text Text Text Text Text Text\nText Text Text Text Text",
    val contentImageResId: Int = R.drawable.post_content_image,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(type = StatisticType.VIEWS, count = 1111),
        StatisticItem(type = StatisticType.COMMENTS, count = 111),
        StatisticItem(type = StatisticType.SHARES, count = 11),
        StatisticItem(type = StatisticType.LIKES, count = 999)
    )
)
