package com.smackwerks.rtdwtf.dto

import com.opencsv.bean.CsvBindByName
import com.opencsv.bean.CsvDate
import java.util.*

class FeedInfo {
    //    feed_publisher_name, feed_publisher_url, feed_lang, feed_start_date, feed_end_date, feed_version
//    @CsvBindByName(column = "feed_publisher_name")
//    val publisherName: String,
//
//    @CsvBindByName(column = "feed_publisher_url")
//    val publisherUrl: String,
//
//    @CsvBindByName(column = "feed_lang")
//    val language: String,
//
//    @CsvBindByName(column = "feed_start_date")
//    @CsvDate("yyyyMMdd")
//    val startDate: Date,
//
//    @CsvBindByName(column = "feed_end_date")
//    @CsvDate("yyyyMMdd")
//    val endDate: Date,
//
    @CsvBindByName(column = "feed_version")
    var version: String? = null

    override fun toString(): String {
        return "version=$version"
    }
}