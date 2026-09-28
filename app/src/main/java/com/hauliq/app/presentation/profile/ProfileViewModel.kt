package com.hauliq.app.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class UserProfile(
    val name: String,
    val role: String,
    val email: String,
    val businessName: String,
    val warehouseLocation: String
)

@HiltViewModel
class ProfileViewModel @Inject constructor() : ViewModel() {

    private val _profile = MutableStateFlow(
        UserProfile(
            name = "Alex Mercer",
            role = "Senior Logistics Manager",
            email = "alex.mercer@hauliq.com",
            businessName = "Apex Logistics Warehouse #4",
            warehouseLocation = "120 Logistics Dr, San Jose, CA"
        )
    )
    val profile: StateFlow<UserProfile> = _profile.asStateFlow()

    fun updateProfile(name: String, email: String, businessName: String, location: String) {
        viewModelScope.launch {
            _profile.value = _profile.value.copy(
                name = name,
                email = email,
                businessName = businessName,
                warehouseLocation = location
            )
        }
    }
}
