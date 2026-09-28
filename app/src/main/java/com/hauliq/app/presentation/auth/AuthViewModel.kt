package com.hauliq.app.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()
    data class Success(val email: String, val name: String, val businessName: String) : AuthState()
    data class Error(val message: String) : AuthState()
}

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    fun login(email: String, javaPassword: String) {
        if (email.isBlank() || javaPassword.isBlank()) {
            _authState.value = AuthState.Error("Email and Password cannot be empty.")
            return
        }
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            delay(1500) // Mock network delay
            if (email.contains("@") && javaPassword.length >= 6) {
                _authState.value = AuthState.Success(
                    email = email,
                    name = "Alex Mercer",
                    businessName = "Apex Logistics Inc."
                )
            } else {
                _authState.value = AuthState.Error("Invalid credentials. Try guest@hauliq.com / password")
            }
        }
    }

    fun register(email: String, name: String, javaPassword: String, businessName: String) {
        if (email.isBlank() || name.isBlank() || javaPassword.isBlank() || businessName.isBlank()) {
            _authState.value = AuthState.Error("Please fill out all fields.")
            return
        }
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            delay(1500)
            if (email.contains("@") && javaPassword.length >= 6) {
                _authState.value = AuthState.Success(
                    email = email,
                    name = name,
                    businessName = businessName
                )
            } else {
                _authState.value = AuthState.Error("Registration failed. Ensure email is valid and password >= 6 characters.")
            }
        }
    }

    fun forgotPassword(email: String, onEmailSent: () -> Unit) {
        if (email.isBlank() || !email.contains("@")) {
            _authState.value = AuthState.Error("Please enter a valid email address.")
            return
        }
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            delay(1000)
            _authState.value = AuthState.Idle
            onEmailSent()
        }
    }

    fun logout() {
        _authState.value = AuthState.Idle
    }

    fun clearError() {
        if (_authState.value is AuthState.Error) {
            _authState.value = AuthState.Idle
        }
    }
}
