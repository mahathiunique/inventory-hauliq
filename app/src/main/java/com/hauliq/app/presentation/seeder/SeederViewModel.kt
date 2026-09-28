package com.hauliq.app.presentation.seeder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hauliq.app.data.remote.FirebaseSeeder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeederViewModel @Inject constructor(
    private val seeder: FirebaseSeeder
) : ViewModel() {

    val seedingStatus = seeder.uploadProgress

    init {
        viewModelScope.launch {
            seeder.seedDatabaseIfNeeded()
        }
    }
}
