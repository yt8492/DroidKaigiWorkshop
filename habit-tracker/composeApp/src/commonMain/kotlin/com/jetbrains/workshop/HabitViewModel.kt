package com.jetbrains.workshop

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HabitViewModel {
    private val _habits = MutableStateFlow(
        listOf(
            "Running",
            "Pull-ups",
            "Squats",
            "Plank",
            "Dumbbells",
            "Jogging",
            "Push-ups",
            "Lunges",
            "Sit-ups",
            "High knees",
            "Burpees",
        ).map {
            HabitBindingModel(
                exercise = it,
                count = 0,
            )
        }
    )
    val habits: StateFlow<List<HabitBindingModel>> = _habits.asStateFlow()

    fun countUp(habit: HabitBindingModel) {
        _habits.update { list ->
            list.map {
                if (it.exercise == habit.exercise) {
                    it.copy(
                        count = it.count + 1
                    )
                } else {
                    it
                }
            }
        }
    }

    fun countDown(habit: HabitBindingModel) {
        _habits.update { list ->
            list.map {
                if (it.exercise == habit.exercise) {
                    it.copy(
                        count = it.count - 1
                    )
                } else {
                    it
                }
            }
        }
    }
}
