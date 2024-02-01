package com.mariomanhique.khoevent.presentation.screens.home

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.cletosbambo.khodarevent.model.Community
import com.cletosbambo.khodarevent.presentation.screens.home.HomeViewModel
//import com.cletosbambo.khodarevent.model.CommunityItem
import com.cletosbambo.khodarevent.model.Event
import com.cletosbambo.khodarevent.model.Result
import com.cletosbambo.khodarevent.presentation.screens.home.HomeContent

@Composable
fun HomeScreen(
    onMenuClicked: () -> Unit = {},
    navigateToEventDetails: () -> Unit,
    homeViewModel: HomeViewModel<Any?, Any?> = hiltViewModel()
){



    val communities by homeViewModel.data.collectAsStateWithLifecycle()
    val events by homeViewModel.events.collectAsStateWithLifecycle()

    when(communities){
        is Result.Success -> {
            HomeContent(
                communities = (communities as Result.Success<List<Community>>).data,
                events = (events as Result.Success<List<Event>>).data
                ,
                onMenuClicked = onMenuClicked,
                searchValue = "",
                onSearchValueChange = {},
                navigateToEventDetails = navigateToEventDetails
            )
        }
        is Result.Error -> {

        }

        else -> {

        }
    }


}
