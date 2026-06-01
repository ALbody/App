package com.example.assistant

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

data class AssistantUiState(
    val isListening: Boolean = false,
    val transcription: String = "",
    val lastIntent: ParsedIntent? = null
)

data class ParsedIntent(
    val intentDescription: String,
    val action: String,
    val confidence: Double
)

class AssistantViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AssistantUiState())
    val uiState: StateFlow<AssistantUiState> = _uiState.asStateFlow()

    fun toggleListening() {
        if (_uiState.value.isListening) {
            _uiState.update { it.copy(isListening = false) }
        } else {
            _uiState.update { it.copy(isListening = true, transcription = "Listening...") }
            simulateProcessing()
        }
    }

    private fun simulateProcessing() {
        viewModelScope.launch {
            delay(1500)
            _uiState.update { it.copy(transcription = "Call John Doe") }
            delay(800)
            _uiState.update { 
                it.copy(
                    isListening = false,
                    lastIntent = ParsedIntent(
                        intentDescription = "User user requested to make a phone call to contact 'John Doe'.",
                        action = "PhoneCallTool",
                        confidence = 0.98
                    )
                ) 
            }
        }
    }
}
