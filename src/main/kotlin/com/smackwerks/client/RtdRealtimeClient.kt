package com.smackwerks.client

import com.google.transit.realtime.GtfsRealtime
import com.smackwerks.service.Config
import io.ktor.client.HttpClient
import io.ktor.client.features.auth.Auth
import io.ktor.client.features.auth.providers.basic
import io.ktor.client.request.get

class RtdRealtimeClient(val httpClient: HttpClient = defaultClient()) {

    suspend fun fetchTrips(): GtfsRealtime.FeedMessage {
        val bytes = httpClient.get<ByteArray>("${Config.rtdRtUrl}/TripUpdate.pb")
        val msg = GtfsRealtime.FeedMessage.parseFrom(bytes)
        return msg
    }

    companion object {
        private fun defaultClient(): HttpClient {
            return HttpClient() {
                install(Auth) {
                    basic {
                        username = Config.rtdRtUserName
                        password = Config.rtdRtPassword
                    }
                }
            }
        }
    }
}