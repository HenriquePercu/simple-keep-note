package com.example.keep.manager

import com.example.keep.model.NoteRequest
import com.example.keep.model.NoteResponse
import com.example.keep.repository.NoteRepository
import jakarta.enterprise.context.ApplicationScoped
import java.util.*
import kotlin.IllegalArgumentException

@ApplicationScoped
class NoteManager(
    private val noteRepository: NoteRepository
) {

    fun storeNote(noteRequest: NoteRequest, userId: String): UUID {
        return noteRepository.storeNote(noteRequest.toNoteEntity(userId)).noteId
    }

    fun getNote(noteId: UUID, userId: String): NoteResponse {
        return noteRepository.getNote(noteId)?.run {
            if (this.userId != userId) {
                throw IllegalArgumentException("This note does not belong to this user")
            }
            NoteResponse.fromNoteEntity(this)
        } ?: throw IllegalArgumentException("Note not found")

    }

    fun getAllNotesByUserId(userId: String): List<NoteResponse> {
        return noteRepository.getNotesFromUserId(userId).map { NoteResponse.fromNoteEntity(it) }
    }

}