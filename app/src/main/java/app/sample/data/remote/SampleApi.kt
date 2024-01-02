package app.sample.data.remote

import retrofit2.http.GET

interface SampleApi {

    @GET("sample")
    suspend fun doNetworkCall()
}