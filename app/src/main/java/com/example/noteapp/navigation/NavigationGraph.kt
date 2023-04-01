package com.example.noteapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.noteapp.core.Constants.HOME_SCREEN
import com.example.noteapp.core.Constants.NOTE_ID
import com.example.noteapp.core.Constants.NOTE_CONTENT_SCREEN
import com.example.noteapp.core.Constants.SPLASH_SCREEN
import com.example.noteapp.core.Constants.UPDATE_NOTE_SCREEN
import com.example.noteapp.presentation.home.HomeScreen
import com.example.noteapp.presentation.SplashScreen
import com.example.noteapp.presentation.note_content.NoteContentScreen
import com.example.noteapp.presentation.update_note.UpdateNoteScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {


        // Splash Screen
        composable(SPLASH_SCREEN) {
            SplashScreen(
                navigateToHomeScreen = {
                    navController.popBackStack()
                    navController.navigate(HOME_SCREEN)
                }
            )
        }


        // Home Screen
        composable(HOME_SCREEN) {
            HomeScreen(
                navigateToContentScreen = { taskId ->
                    navController.navigate(
                        route = "${NOTE_CONTENT_SCREEN}/${taskId}"
                    )
                }
            )
        }


        // Note Content Screen
        composable(
            route = "${NOTE_CONTENT_SCREEN}/{$NOTE_ID}",
            arguments = listOf(
                navArgument(NOTE_ID) {
                    type = NavType.IntType
                }
            )
        ) { navBackStackEntry ->
            val noteId = navBackStackEntry.arguments?.getInt(NOTE_ID) ?: 0
            NoteContentScreen(
                noteId = noteId,
                navigateBack = {
                    navController.popBackStack()
                },
                navigateToHomeScreen = {
                    navController.navigate(HOME_SCREEN)
                }
            )
        }


        // Update Note Screen
        composable(
            route = "${UPDATE_NOTE_SCREEN}/{$NOTE_ID}",
            arguments = listOf(
                navArgument(NOTE_ID) {
                    type = NavType.IntType
                }
            )
        ) { navBackStackEntry ->
            val noteId = navBackStackEntry.arguments?.getInt(NOTE_ID) ?: 0
            UpdateNoteScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

    }

}