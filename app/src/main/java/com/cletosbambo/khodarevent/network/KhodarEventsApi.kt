package com.cletosbambo.khodarevent.network

import com.cletosbambo.khodarevent.model.AuthenticationRequest
import com.cletosbambo.khodarevent.model.Community
import com.cletosbambo.khodarevent.model.Event
import com.cletosbambo.khodarevent.model.EventRequest
import com.cletosbambo.khodarevent.model.ResponseStatus
import com.cletosbambo.khodarevent.model.TokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
//import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import javax.inject.Singleton

@Singleton
interface KhodarEventsApi {

    @GET("communities")
    suspend fun getCommunities(): List<Community>

    @GET("events")
    suspend fun getEvents():List<Event>

    @GET("events/{id}")
    suspend fun getEventById(
        @Path("id") eventId: String
    ):Event

    @POST("auth/authenticate")
    suspend fun authenticateUser(@Body request: AuthenticationRequest): Response<TokenResponse>

    @POST("events/{id}")
    suspend fun createEvent(
        @Header("Authorization") authorizationHeader: String,
        @Path(value = "id") communityId: Long,
        @Body request: EventRequest
    ): Response<ResponseStatus>

    @GET("events/community/{id}")
    suspend fun getEventsByCommunityId(
        @Path(value = "id") communityId: Int
    ):List<Event>
}
