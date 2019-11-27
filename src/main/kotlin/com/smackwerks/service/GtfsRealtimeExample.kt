package com.smackwerks.service

import com.smackwerks.client.RtdRealtimeClient
import kotlinx.coroutines.runBlocking

object GtfsRealtimeExample {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val client = RtdRealtimeClient()
        val trips = runBlocking {
            client.fetchTrips()
        }
        for (entity in trips.stopTimeUpdateList) {
            println(entity)
        }
    }
}