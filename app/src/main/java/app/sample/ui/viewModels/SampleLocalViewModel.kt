package app.sample.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.sample.data.local_db.models.Sample
import app.sample.data.repository.SampleRemoteRepository
import app.sample.domain.repository.SampleRepository
import app.sample.ui.states.SampleState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SampleLocalViewModel @Inject constructor(
    private val localRepository: SampleRepository.Local,
    private val remoteRepository: SampleRepository.Remote
): ViewModel() {

    private val _state = MutableStateFlow(SampleState())
    @OptIn(ExperimentalCoroutinesApi::class)
    private val _samples: StateFlow<List<Sample>> = MutableStateFlow(emptyList<Sample>()).also { getAll() }.asStateFlow()

    val state = combine(_state, _samples){state, samples ->
        state.copy(
            samples = samples
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), SampleState())

    private fun getAll(){
        viewModelScope.launch(Dispatchers.IO) {
            _samples.collect{
                localRepository.getAll()
            }
        }
    }

}