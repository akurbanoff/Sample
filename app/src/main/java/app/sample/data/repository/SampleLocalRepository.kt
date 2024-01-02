package app.sample.data.repository

import app.sample.data.local_db.dao.SampleDao
import app.sample.data.local_db.models.Sample
import app.sample.domain.repository.SampleRepository
import kotlinx.coroutines.flow.Flow

class SampleLocalRepository(
    private val dao: SampleDao
) : SampleRepository.Local {
    override suspend fun getAll() : Flow<List<Sample>> {
        return dao.getAll()
    }

}