package com.smackwerks.service

import com.smackwerks.client.RtdRealtimeClient
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// trip updates every 20 seconds
// vehicle positions every 10 seconds

object GtfsRealtimeExample {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val client = RtdRealtimeClient()
        runBlocking {
            repeat(30) {
//                val tripUpdates = client.fetchTrips()
//                println("timestamp = ${tripUpdates.header.timestamp}")
                val positions = client.fetchPositions()
                println("timestamp = ${positions.header.timestamp}")
                delay(1000)
            }
        }
    }
}