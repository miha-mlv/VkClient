package com.example.vkclient.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.vkclient.domain.FeedPost
import com.example.vkclient.domain.StatisticItem
import com.example.vkclient.domain.StatisticType
import com.example.vkclient.R

@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    feedPost: FeedPost,
    onLikeClickListener: (StatisticItem) -> Unit,
    onShareClickListener: (StatisticItem) -> Unit,
    onViewsClickListener: (StatisticItem) -> Unit,
    onCommentsClickListener: (StatisticItem) -> Unit
) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            PostHeader(feedPost)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = feedPost.contentText)
            Spacer(modifier = Modifier.height(4.dp))
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(feedPost.contentImageResId),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(10.dp))
            StatisticsPost(
                statistics = feedPost.statistics,
                onLikeClickListener = onLikeClickListener,
                onViewsClickListener = onViewsClickListener,
                onCommentsClickListener = onCommentsClickListener,
                onShareClickListener = onShareClickListener
            )
        }
    }
}

@Composable
private fun PostHeader(
    feedPost: FeedPost
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            painter = painterResource(id = feedPost.avatarRedId),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = feedPost.communityName,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = feedPost.publicationData,
                color = MaterialTheme.colorScheme.primary
            )
        }
        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
private fun StatisticsPost(
    statistics: List<StatisticItem>,
    onLikeClickListener: (StatisticItem) -> Unit,
    onShareClickListener: (StatisticItem) -> Unit,
    onViewsClickListener: (StatisticItem) -> Unit,
    onCommentsClickListener: (StatisticItem) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            val viewItem = statistics.getItemType(StatisticType.VIEWS)
            IconWithText(
                iconRedId = R.drawable.ic_views_count,
                viewItem.count.toString(),
                onItemClickListener = {
                    onViewsClickListener(viewItem)
                }
            )
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val commentsItem = statistics.getItemType(StatisticType.COMMENTS)
            IconWithText(
                iconRedId = R.drawable.ic_comment,
                commentsItem.count.toString(),
                onItemClickListener = {
                    onCommentsClickListener(commentsItem)
                }
            )
            Spacer(modifier = Modifier.width(4.dp))
            val sharesItem = statistics.getItemType(StatisticType.SHARES)
            IconWithText(
                iconRedId = R.drawable.ic_share,
                sharesItem.count.toString(),
                onItemClickListener = {
                    onShareClickListener(sharesItem)
                }
            )
            Spacer(modifier = Modifier.width(4.dp))
            val likesItem = statistics.getItemType(StatisticType.LIKES)
            IconWithText(
                iconRedId = R.drawable.ic_like,
                likesItem.count.toString(),
                onItemClickListener = {
                    onLikeClickListener(likesItem)
                }
            )
        }

    }
}

private fun List<StatisticItem>.getItemType(type: StatisticType): StatisticItem {
    return this.find { it.type == type } ?: throw IllegalStateException()
}

@Composable
private fun IconWithText(
    iconRedId: Int,
    text: String,
    onItemClickListener: () -> Unit
) {
    Row(
        modifier = Modifier
            .clickable {
                onItemClickListener()
            },
    ) {
        Icon(
            painter = painterResource(iconRedId),
            contentDescription = "",
            tint = MaterialTheme.colorScheme.secondary
        )
        Text(text, color = MaterialTheme.colorScheme.primary)
    }
}