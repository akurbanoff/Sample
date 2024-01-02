package app.sample.data.repository

import app.sample.data.remote.SampleApi
import app.sample.domain.repository.SampleRepository

class SampleRemoteRepository(
    private val api: SampleApi
) : SampleRepository.Remote {
    override suspend fun doNetworkCall() {
        api.doNetworkCall()
    }
}