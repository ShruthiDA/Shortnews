package com.mlsg.shortnews.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlsg.shortnews.AppConstants.COUNTRY
import com.mlsg.shortnews.data.entity.NewsResponse
import com.mlsg.shortnews.ui.repository.ShortNewsRepository
import com.mlsg.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShortNewsViewModel @Inject constructor(
    private val newsRepository: ShortNewsRepository
) : ViewModel() {

    private val _shortNews : MutableStateFlow<ResourceState<NewsResponse>> = MutableStateFlow(ResourceState.Loading())
    val shortNews : StateFlow<ResourceState<NewsResponse>> = _shortNews

    init {
        getShortNews()
    }

    fun getShortNews() {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNewsHeadlines(COUNTRY)
                .collectLatest { newsResponse ->
                    _shortNews.value = newsResponse
                }
        }
    }

    companion object{
        const val TAG = "ShortNewsViewModel"
    }
}