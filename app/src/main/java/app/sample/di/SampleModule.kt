package app.sample.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import app.sample.data.local_db.AppDatabase
import app.sample.data.remote.SampleApi
import app.sample.data.repository.SampleLocalRepository
import app.sample.data.repository.SampleRemoteRepository
import app.sample.domain.repository.SampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SampleModule {

    @Provides
    @Singleton
    fun createDb(applicationContext: Application) : AppDatabase{
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "sample_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideSampleApi(): SampleApi{
        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .build()
            .create(SampleApi::class.java)
    }

    @Provides
    @Singleton
    fun provideSampleRemoteRepository(api: SampleApi) : SampleRepository.Remote {
        return SampleRemoteRepository(api)
    }

    @Provides
    @Singleton
    fun provideSampleLocalRepository(db: AppDatabase): SampleRepository.Local{
        return SampleLocalRepository(db.sampleDao)
    }
}