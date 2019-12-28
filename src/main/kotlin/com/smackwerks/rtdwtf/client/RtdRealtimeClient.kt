package com.smackwerks.rtdwtf.client

import com.google.transit.realtime.GtfsRealtime
import com.smackwerks.rtdwtf.service.Config
import io.ktor.client.HttpClient
import io.ktor.client.features.auth.Auth
import io.ktor.client.features.auth.providers.basic
import io.ktor.client.request.get

class RtdRealtimeClient(val httpClient: HttpClient = defaultClient()) {

    private suspend fun fetch(path: String): GtfsRealtime.FeedMessage {
        val bytes = httpClient.get<ByteArray>("${Config.rtdRtUrl}/${path}")
        return GtfsRealtime.FeedMessage.parseFrom(bytes)
    }

    suspend fun fetchTrips() = fetch("TripUpdate.pb")
    suspend fun fetchPositions() = fetch("VehiclePosition.pb")

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