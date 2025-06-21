package com.example.vkclient.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkclient.MainViewModel
import com.example.vkclient.domain.FeedPost

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(viewModel: MainViewModel) {
    Scaffold(
        bottomBar = {
            NavigationBar {
                val selectedItemPosition = remember { mutableIntStateOf(0) }
                val items =
                    listOf(NavigationItem.Home, NavigationItem.Favourite, NavigationItem.Profile)
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemPosition.intValue == index,
                        onClick = { selectedItemPosition.intValue = index },
                        icon = { Icon(item.icon, contentDescription = "") },
                        label = { Text(text = item.titleResId) }
                    )
                }
            }
        }
    ) {
        val feedPost = viewModel.feedPost.observeAsState(FeedPost())
        PostCard(modifier = Modifier
            .padding(8.dp),
            feedPost = feedPost.value,
            onViewsClickListener = viewModel::updateCount,
            onShareClickListener = viewModel::updateCount,
            onCommentsClickListener = viewModel::updateCount,
            onLikeClickListener = viewModel::updateCount
        )
    }
}

@Preview
@Composable
fun Test(){
    MainScreen(MainViewModel())
}