package com.example.noteapp.navigation

import com.example.noteapp.core.Constants.HOME_SCREEN
import com.example.noteapp.core.Constants.SPLASH_SCREEN
import com.example.noteapp.core.Constants.UPDATE_NOTE_SCREEN

sealed class Screen(val route: String) {
    object Splash: Screen(SPLASH_SCREEN)
    object Home: Screen(HOME_SCREEN)

    object UpdateTask: Screen(UPDATE_NOTE_SCREEN)
}