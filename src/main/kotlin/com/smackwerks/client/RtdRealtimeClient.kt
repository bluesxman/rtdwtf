package com.smackwerks.client

import com.google.transit.realtime.GtfsRealtime
import com.smackwerks.service.Config
import io.ktor.client.HttpClient
import io.ktor.client.features.auth.Auth
import io.ktor.client.features.auth.providers.basic
import io.ktor.client.request.get

class RtdRealtimeClient(val httpClient: HttpClient = defaultClient()) {

    suspend fun fetchTrips(): GtfsRealtime.TripUpdate {
        val bytes = httpClient.get<ByteArray>("${Config.rtdRtUrl}/TripUpdate.pb")
        return GtfsRealtime.TripUpdate.parseFrom(bytes)
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