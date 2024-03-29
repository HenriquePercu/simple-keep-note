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

    fun storeNote(): Unit{
        val note = Note{
            title = "Titulo"
            noteContent = "Content"
            userId = "userId"
        }

        val noteAdded = notes.add(note)
        println("Storing in database: $note")
    }

}