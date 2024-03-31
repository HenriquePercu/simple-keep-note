package com.example.keep.repository

import com.example.keep.entity.Note
import jakarta.enterprise.context.ApplicationScoped
import org.ktorm.database.Database
import org.ktorm.entity.add
import org.ktorm.entity.sequenceOf

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

}