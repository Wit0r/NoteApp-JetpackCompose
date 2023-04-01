package com.example.noteapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

enum class DayPart {
    MORNING,
    AFTERNOON,
    NIGHT
}

@HiltViewModel
class GreetingViewModel @Inject constructor(): ViewModel() {
    private val _dayPart = MutableStateFlow(DayPart.MORNING)
    val dayPart: StateFlow<DayPart> = _dayPart.asStateFlow()

    private val _greeting = MutableStateFlow("Good Morning!")
    val greeting: StateFlow<String> = _greeting.asStateFlow()

    init {
        viewModelScope.launch {
            getTimeOfDay().collect { timeOfDay ->
                _dayPart.value = when (timeOfDay) {
                    in 6..11 -> DayPart.MORNING
                    in 12..17 -> DayPart.AFTERNOON
                    else -> DayPart.NIGHT
                }

                _greeting.value = when (_dayPart.value) {
                    DayPart.MORNING -> "Good Morning!"
                    DayPart.AFTERNOON -> "Good Afternoon"
                    DayPart.NIGHT -> "Good Night!"
                }
            }
        }
    }

    private fun getTimeOfDay() = flow {
        while (true) {
            emit(getCurrentHour())
            kotlinx.coroutines.delay(1000 * 6)
        }
    }

    private fun getCurrentHour(): Int {
        val calendar = Calendar.getInstance()
        return calendar.get(Calendar.HOUR_OF_DAY)
    }

}
