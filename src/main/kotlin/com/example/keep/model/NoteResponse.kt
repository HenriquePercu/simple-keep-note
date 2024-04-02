package com.example.keep.model

import com.example.keep.entity.Note
import java.util.*

data class NoteResponse(

    val noteId: UUID,
    val title: String,
    val content: String

) {

    companion object {
        fun fromNoteEntity(note: Note): NoteResponse {
            return NoteResponse(
                noteId = note.noteId,
                title = note.title,
                content = note.noteContent
            )
        }
    }

}
