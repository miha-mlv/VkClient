package com.example.vkclient

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vkclient.domain.FeedPost
import com.example.vkclient.domain.StatisticItem

class MainViewModel: ViewModel() {

    private val _feedPost = MutableLiveData(FeedPost())
    val feedPost: LiveData<FeedPost> = _feedPost

    fun updateCount(item: StatisticItem){
        val oldStatistic = feedPost.value?.statistics ?: throw IllegalStateException()
        val newStatistics = oldStatistic.toMutableList().apply {
            replaceAll{ oldItem ->
                if(oldItem.type == item.type){
                    oldItem.copy(count = oldItem.count+1)
                }else{
                    oldItem
                }
            }
        }
        _feedPost.value = feedPost.value?.copy(statistics = newStatistics )
    }
}