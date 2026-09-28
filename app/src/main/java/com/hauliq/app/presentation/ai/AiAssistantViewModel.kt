package com.hauliq.app.presentation.ai

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hauliq.app.domain.model.AiInsight
import com.hauliq.app.domain.model.ChatMessage
import com.hauliq.app.domain.model.ReorderSuggestion
import com.hauliq.app.domain.repository.AiAssistantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AiAssistantUiState(
    val insights: List<AiInsight> = emptyList(),
    val suggestions: List<ReorderSuggestion> = emptyList(),
    val messages: List<ChatMessage> = listOf(
        ChatMessage("init", "Hello! I am your HaulIQ Smart Assistant. How can I help you today?", true)
    ),
    val isLoading: Boolean = false,
    val currentInput: String = ""
)

@HiltViewModel
class AiAssistantViewModel @Inject constructor(
    private val aiAssistantRepository: AiAssistantRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AiAssistantUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadAiData()
    }

    private fun loadAiData() {
        viewModelScope.launch {
            combine(
                aiAssistantRepository.getAiInsights(),
                aiAssistantRepository.getReorderSuggestions()
            ) { insights, suggestions ->
                _uiState.update { it.copy(
                    insights = insights,
                    suggestions = suggestions
                ) }
            }.collect()
        }
    }

    fun onInputChange(input: String) {
        _uiState.update { it.copy(currentInput = input) }
    }

    fun sendMessage() {
        val text = _uiState.value.currentInput
        if (text.isBlank()) return

        val userMessage = ChatMessage(System.currentTimeMillis().toString(), text, false)
        
        _uiState.update { it.copy(
            messages = it.messages + userMessage,
            currentInput = "",
            isLoading = true
        ) }

        viewModelScope.launch {
            val response = aiAssistantRepository.getChatResponse(text)
            val aiMessage = ChatMessage((System.currentTimeMillis() + 1).toString(), response, true)
            
            _uiState.update { it.copy(
                messages = it.messages + aiMessage,
                isLoading = false
            ) }
        }
    }
}
