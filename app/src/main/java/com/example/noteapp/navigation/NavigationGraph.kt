package com.example.noteapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.*
import com.example.noteapp.core.Constants.HOME_SCREEN
import com.example.noteapp.core.Constants.NOTE_CONTENT_SCREEN
import com.example.noteapp.core.Constants.NOTE_ID
import com.example.noteapp.core.Constants.SPLASH_SCREEN
import com.example.noteapp.core.Constants.UPDATE_NOTE_SCREEN
import com.example.noteapp.presentation.home.HomeScreen
import com.example.noteapp.presentation.note_content.NoteContentScreen
import com.example.noteapp.presentation.splash.SplashScreen
import com.example.noteapp.presentation.update_note.UpdateNoteScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationGraph(navController: NavHostController) {

    val enterTransition = fadeIn(tween(300, 50, FastOutSlowInEasing))
    val exitTransition =  fadeOut(tween(300, 50, FastOutSlowInEasing))

    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        enterTransition = { enterTransition },
        exitTransition = { exitTransition },
        popEnterTransition = { enterTransition },
        popExitTransition = { exitTransition }
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
                },
                navigateToUpdateNote = { noteId ->
                    navController.navigate(
                        route = "${UPDATE_NOTE_SCREEN}/${noteId}"
                    )
                }
            )
        }


        // Update Note Content
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
                noteId = noteId,
                navigateBack = {
                    navController.popBackStack()
                }
            )

        }
    }
}