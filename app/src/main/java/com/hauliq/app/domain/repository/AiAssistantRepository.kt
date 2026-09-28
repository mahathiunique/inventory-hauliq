package com.hauliq.app.domain.repository

import com.hauliq.app.domain.model.AiInsight
import com.hauliq.app.domain.model.ReorderSuggestion
import kotlinx.coroutines.flow.Flow

interface AiAssistantRepository {
    fun getAiInsights(): Flow<List<AiInsight>>
    fun getReorderSuggestions(): Flow<List<ReorderSuggestion>>
    suspend fun getChatResponse(message: String): String
}
