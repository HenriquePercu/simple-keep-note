package com.example.keep.model

import com.example.keep.entity.Note

data class NoteRequest(
    val title: String,
    val noteContent: String
) {

    fun toNoteEntity(userId: String): Note {
        val note = this
        return Note{
            this.title = note.title
            this.noteContent = note.noteContent
            this.userId = userId
        }
    }

}