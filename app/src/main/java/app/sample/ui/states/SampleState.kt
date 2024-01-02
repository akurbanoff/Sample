package app.sample.ui.states

import app.sample.data.local_db.models.Sample

data class SampleState(
    val samples: List<Sample> = emptyList(),
    val title: String = ""
)