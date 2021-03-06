package com.smackwerks.rtdwtf.etl

//import com.github.doyaaaaaken.kotlincsv.dsl.csvReader

import com.opencsv.bean.CsvToBeanBuilder
import com.smackwerks.rtdwtf.client.RTD_SCHEDULE_PREFIX
import com.smackwerks.rtdwtf.client.RtdScheduleClient
import com.smackwerks.rtdwtf.dto.FeedInfo
import kotlinx.coroutines.runBlocking
import java.io.FileReader
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

            val reader = Files.newBufferedReader(zip.getPath("/feed_info.txt"))
            val beans = CsvToBeanBuilder<FeedInfo>(reader)
                .withType(FeedInfo::class.java)
                .build()
                .parse()

            beans.forEach { row ->
                println(row)
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

        return FileSystems.newFileSystem(tmpFile, null)
    }
}