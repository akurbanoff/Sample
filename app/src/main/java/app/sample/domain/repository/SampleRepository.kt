package app.sample.domain.repository

import app.sample.data.local_db.models.Sample
import kotlinx.coroutines.flow.Flow

interface SampleRepository{
    interface Remote {
        suspend fun doNetworkCall()
    }
    interface Local{
        suspend fun getAll() : Flow<List<Sample>>
    }
}
