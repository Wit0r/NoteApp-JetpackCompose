package com.example.noteapp.core

import com.example.noteapp.R.string as R

object HomeConstants {

    const val APP_NAME = R.app_name

    // Home Alert Dialog
    const val TITLE_NEW_NOTE = R.title_new_note
    const val ADD_NOTE = R.add_note
    const val DISMISS_TEXT = R.dismiss_text
    const val PLACEHOLDER_TITLE = R.placeholder_title
    const val PLACEHOLDER_CONTENT = R.placeholder_content

    // Home Floating Button
    const val ADD = R.add

}

object NoteConstants {

    // Delete Alert Dialog
    const val DELETE_DIALOG_MESSAGE = R.delete_dialog_message
    const val YES_TEXT = R.yes_text
    const val CANCEL_TEXT = R.cancel_text
    const val SNACK_NOTE_DELETED = "Note deleted successfully!"

    // Note Content Top Bar
    const val BACK_BUTTON_CD = R.back_button_cd
    const val EDIT_NOTE_CD = R.edit_note_cd
    const val DELETE_NOTE_CD = R.delete_note_cd


}

object Constants {

    // Room
    const val TABLE_NAME = "notes"

    // Arguments
    const val NOTE_ID = "noteId"

    // Screens
    const val SPLASH_SCREEN = "SPLASH_SCREEN"
    const val HOME_SCREEN = "HOME_SCREEN"
    const val NOTE_CONTENT_SCREEN = "NOTE_CONTENT_SCREEN"
    const val UPDATE_NOTE_SCREEN = "UPDATE_NOTE_SCREEN"

}
