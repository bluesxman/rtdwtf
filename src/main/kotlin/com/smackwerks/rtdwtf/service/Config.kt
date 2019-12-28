package com.smackwerks.rtdwtf.service

object Config {
    val rtdRtUserName: String by lazy {
        System.getenv("RTD_RT_USER_NAME")
    }
    val rtdRtPassword:String by lazy {
        System.getenv("RTD_RT_PASSWORD")
    }
    const val rtdRtUrl =  "http://googlefeeder.rtd-denver.com/google_sync/"
    const val rtdScheduleUrl = "http://www.rtd-denver.com/GoogleFeeder/google_transit.zip"
    const val tripUpdateInterval = 20
    const val vehicleUpdateInterval = 10
}