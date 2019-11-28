package com.smackwerks.client

import com.smackwerks.service.Config
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import java.nio.ByteBuffer
import java.nio.channels.FileChannel
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption

const val RTD_SCHEDULE_PREFIX = "rtd-schedule"
const val MAX_SCHEDULE_SIZE = 1024 * 1024 * 100 // 50 MB max

class RtdScheduleClient(val httpClient: HttpClient = HttpClient()) {
    suspend fun fetchSchedule(dst: FileChannel) {
        val src = httpClient.get<ByteArray>(Config.rtdScheduleUrl)
        val buffer = ByteBuffer.allocate(src.size)
        buffer.put(src)
        buffer.flip()

        dst.use {
            // TODO: switch to coroutine-based async file io.  blocking io here for now.
            // see:  https://atoulme.github.io/kotlinx.coroutines/kotlinx-coroutines-io/index.html

            // TODO: write fully; handle incomplete writes
            it.write(buffer)
        }
    }
}