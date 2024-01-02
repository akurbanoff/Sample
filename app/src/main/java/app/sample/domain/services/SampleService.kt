package app.sample.domain.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import app.sample.data.repository.SampleRemoteRepository
import javax.inject.Inject

class SampleService: Service() {
    @Inject
    lateinit var remoteRepository: SampleRemoteRepository

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}