package com.cletosbambo.khodarevent.data.repository

import com.example.myevent.model.Community
import com.example.myevent.model.Event
import com.example.myevent.model.EventRequest

interface MyEventRepoInterface {

    suspend fun getCommunities(): List<Community>

    suspend fun getEvents(): List<Event>
    suspend fun getEventsByCommunityId(communityId: Int): List<Event>

    suspend fun authenticateUser(email: String, password: String): String?

    suspend fun createEvent(
        authorizationHeader: String,
        communityId: Long,
        eventRequest: EventRequest
    ): String

}