package com.smackwerks.service

import com.smackwerks.client.RTD_SCHEDULE_PREFIX
import com.smackwerks.client.RtdRealtimeClient
import com.smackwerks.client.RtdScheduleClient
import com.smackwerks.rtdwtf.etl.RtdScheduleLoader
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.nio.channels.FileChannel
import java.nio.file.Files
import java.nio.file.StandardOpenOption

// trip updates every 20 seconds
// vehicle positions every 10 seconds

object GtfsRealtimeExample {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val loader = RtdScheduleLoader()
        loader.loadAll()

//        val tmpFile = Files.createTempFile(RTD_SCHEDULE_PREFIX, ".zip")
//        val dst = FileChannel.open(tmpFile, StandardOpenOption.APPEND)
//
//        val client = RtdScheduleClient()
//        runBlocking {
//            client.fetchSchedule(dst)
//            println(tmpFile.toString())
//        }

//        val client = RtdRealtimeClient()
//        runBlocking {
//            repeat(30) {
////                val tripUpdates = client.fetchTrips()
////                println("timestamp = ${tripUpdates.header.timestamp}")
//                val positions = client.fetchPositions()
//                println("timestamp = ${positions.header.timestamp}")
//                delay(1000)
//            }
//        }
    }
}