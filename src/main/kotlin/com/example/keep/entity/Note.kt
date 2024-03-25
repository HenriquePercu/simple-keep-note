package com.example.keep.entity

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.uuid
import org.ktorm.schema.varchar
import java.util.UUID


interface Note : Entity<Note> {

    companion object: Entity.Factory<Note>()
    val noteId: UUID
    var title: String
    var noteContent: String
    var userId: String

    object Keeps: Table<Note>("NOTE"){
        val noteId = uuid("note_id").primaryKey().bindTo { it.noteId }
        val title = varchar("title").bindTo { it.title }
        val noteContent = varchar("note_content").bindTo { it.noteContent }
        val userId = varchar("userId").bindTo { it.userId }
    }

}

