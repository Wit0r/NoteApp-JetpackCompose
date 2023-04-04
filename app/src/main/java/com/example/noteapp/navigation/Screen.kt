package com.example.noteapp.navigation

import com.example.noteapp.core.Constants.HOME_SCREEN
import com.example.noteapp.core.Constants.NOTE_CONTENT_SCREEN
import com.example.noteapp.core.Constants.SPLASH_SCREEN

sealed class Screen(val route: String) {
    object Splash: Screen(SPLASH_SCREEN)
    object Home: Screen(HOME_SCREEN)
    object UpdateTask: Screen(NOTE_CONTENT_SCREEN)
}