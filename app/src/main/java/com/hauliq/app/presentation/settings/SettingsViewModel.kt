package com.hauliq.app.presentation.settings

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor() : ViewModel() {

    private val _isDarkTheme = MutableStateFlow(false)
    val isDarkTheme: StateFlow<Boolean> = _isDarkTheme.asStateFlow()

    private val _selectedLanguage = MutableStateFlow("English")
    val selectedLanguage: StateFlow<String> = _selectedLanguage.asStateFlow()

    private val _isNotificationsEnabled = MutableStateFlow(true)
    val isNotificationsEnabled: StateFlow<Boolean> = _isNotificationsEnabled.asStateFlow()

    fun toggleDarkTheme(enabled: Boolean) {
        _isDarkTheme.value = enabled
    }

    fun toggleNotifications(enabled: Boolean) {
        _isNotificationsEnabled.value = enabled
    }

    fun setLanguage(lang: String) {
        _selectedLanguage.value = lang
    }
}
