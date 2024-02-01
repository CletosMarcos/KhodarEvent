package com.cletosbambo.khodarevent.model

data class EventRequest(
    val title: String,
    val description: String,
    val date: String,
    val startTime: String,
    val endTime: String,
    val eventLimit: Int,
)