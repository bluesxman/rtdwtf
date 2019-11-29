package com.smackwerks.rtdwtf.dto

import com.opencsv.bean.CsvBindByName
import com.opencsv.bean.CsvDate
import java.util.*

class FeedInfo {
    //    feed_publisher_name, feed_publisher_url, feed_lang, feed_start_date, feed_end_date, feed_version
    @CsvBindByName(column = "feed_publisher_name")
    var publisherName: String? = null

    @CsvBindByName(column = "feed_publisher_url")
    var publisherUrl: String? = null

    @CsvBindByName(column = "feed_lang")
    var language: String? = null

    @CsvBindByName(column = "feed_start_date")
    @CsvDate("yyyyMMdd")
    var startDate: Date? = null

    @CsvBindByName(column = "feed_end_date")
    @CsvDate("yyyyMMdd")
    var endDate: Date? = null

    @CsvBindByName(column = "feed_version")
    var version: String? = null

    override fun toString(): String {
        return "version=$version"
    }
}