package com.smackwerks.service

object Config {
    val rtdRtUserName: String by lazy {
        System.getenv("RTD_RT_USER_NAME")
    }
    val rtdRtPassword:String by lazy {
        System.getenv("RTD_RT_PASSWORD")
    }
    const val rtdRtUrl =  "http://googlefeeder.rtd-denver.com/google_sync/"
}