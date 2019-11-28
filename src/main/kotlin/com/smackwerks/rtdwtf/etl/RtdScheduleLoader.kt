package com.smackwerks.rtdwtf.etl

import com.smackwerks.client.RTD_SCHEDULE_PREFIX
import com.smackwerks.client.RtdScheduleClient
import kotlinx.coroutines.runBlocking
import java.net.URI
import java.nio.channels.FileChannel
import java.nio.file.FileSystem
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.StandardOpenOption

class RtdScheduleLoader {
    fun loadAll() {
        fetchZip().use { zip ->
            val root = zip.getPath("/")
            for (files in Files.list(root)) {
                println(files)
            }
        }
    }

    private fun fetchZip(): FileSystem {
        val tmpFile = Files.createTempFile(RTD_SCHEDULE_PREFIX, ".zip")
        val dst = FileChannel.open(tmpFile, StandardOpenOption.APPEND)

        val client = RtdScheduleClient()
        runBlocking {
            client.fetchSchedule(dst)
        }

        val env = hashMapOf("create" to "false")
        return FileSystems.newFileSystem(URI("jar:file:" + tmpFile.toUri().path), env)
    }
}