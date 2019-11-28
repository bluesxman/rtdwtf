package com.smackwerks.client

import com.smackwerks.service.Config
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import java.nio.ByteBuffer
import java.nio.channels.FileChannel

const val RTD_SCHEDULE_PREFIX = "rtd-schedule"

class RtdScheduleClient(val httpClient: HttpClient = HttpClient()) {
    suspend fun fetchSchedule(dst: FileChannel) {
        val src = httpClient.get<ByteArray>(Config.rtdScheduleUrl)
        val buffer = ByteBuffer.wrap(src)

        dst.use {
            // TODO: switch to coroutine-based async file io.  blocking io here for now.
            // see:  https://atoulme.github.io/kotlinx.coroutines/kotlinx-coroutines-io/index.html

            // TODO: write fully; handle incomplete writes
            it.write(buffer)
        }
    }
}