package com.example.keep.repository

import com.example.keep.entity.Note
import jakarta.enterprise.context.ApplicationScoped
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf

@ApplicationScoped
class NoteRepository(

) {
    val Database.notes get() = this.sequenceOf(Note.Notes)

    fun storeNote(): Unit{
        println("Storing in database")
    }

}