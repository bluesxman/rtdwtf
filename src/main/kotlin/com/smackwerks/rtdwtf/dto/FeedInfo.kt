package com.smackwerks.rtdwtf.dto

import com.opencsv.bean.CsvBindByName
import com.opencsv.bean.CsvDate
import java.util.Date

class FeedInfo {
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
        return "version=$version start=$startDate end=$endDate"
    }
}