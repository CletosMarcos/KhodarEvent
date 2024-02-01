package com.cletosbambo.khodarevent.presentation.screens.home

import androidx.compose.runtime.Recomposer
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cletosbambo.khodarevent.data.repository.MyEventRepoImpl
import com.cletosbambo.khodarevent.model.Event
//import com.cletosbambo.khodarevent.data.repository.userDataRepository.UserDataRepository
//import com.mariomanhique.khoevent.model.Communities
//import com.mariomanhique.khoevent.model.Event
//import com.mariomanhique.khoevent.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel<KhodarEventsRepoImpl, Communities> @Inject constructor(
    private val repository: KhodarEventsRepoImpl,
):ViewModel() {

    private var _data: MutableStateFlow<Recomposer.State> = MutableStateFlow(Recomposer.State.Idle)
    private var _events: MutableStateFlow<Recomposer.State> = MutableStateFlow(Recomposer.State.Idle)
    val  events = _events.asStateFlow()
    val data = _data.asStateFlow()

    init {
        getCommunities()
        getEvents()
    }
    fun getCommunities(){
        viewModelScope.launch {
            _data.value = Result.Loading
            val result = repository.getCommunities()
            if (result.isNotEmpty()){
                _data.value = Result.Success(data = result)
            }else{
                _data.value = Result.Error()
            }

        }
    }

    fun getEvents(){
        viewModelScope.launch {
            _events.value = Result.Loading
            val result = repository.getEvents()
            if (result.isNotEmpty()){
                _events.value = Result.Success(data = result)
            }else{
                _events.value = Result.Error()
            }
        }
    }

}