package com.example.keep.repository

import com.example.keep.entity.Note
import jakarta.enterprise.context.ApplicationScoped
import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.entity.*
import java.util.UUID

@ApplicationScoped
class NoteRepository(
    private val db: Database
) {
    val notes get() = db.sequenceOf(Note.Notes)

    fun storeNote(note: Note): Note {
        notes.add(note)
        println("Store in database: $note")
        return note
    }

    fun getNote(noteId: UUID): Note? {
        return notes.find { it.noteId eq noteId }
    }

}