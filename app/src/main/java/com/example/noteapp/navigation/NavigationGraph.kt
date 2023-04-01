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
import com.example.noteapp.presentation.home.HomeScreen
import com.example.noteapp.presentation.SplashScreen
import com.example.noteapp.presentation.note_content.NoteContentScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(
                navigateToHomeScreen = {
                    navController.popBackStack()
                    navController.navigate(HOME_SCREEN)
                }
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(
                navigateToUpdateNoteScreen = { taskId ->
                    navController.navigate(
                        route = "${NOTE_CONTENT_SCREEN}/${taskId}"
                    )
                }
            )
        }
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

    }

}