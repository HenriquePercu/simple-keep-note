package com.example.keep.manager

import com.example.keep.model.NoteRequest
import com.example.keep.model.NoteResponse
import com.example.keep.repository.NoteRepository
import jakarta.enterprise.context.ApplicationScoped
import java.lang.IllegalArgumentException
import java.util.*

@ApplicationScoped
class NoteManager(
    private val noteRepository: NoteRepository
) {

    fun storeNote(noteRequest: NoteRequest): UUID {
        return noteRepository.storeNote(noteRequest.toNoteEntity()).noteId
    }

    fun getNote(noteId: UUID): NoteResponse {
        return noteRepository.getNote(noteId)?.run {
            NoteResponse.fromNoteEntity(this)
        } ?: throw IllegalArgumentException("Note not found")
    }

    fun getAllNotesByUserId(userId: String): List<NoteResponse> {
        return noteRepository.getNotesFromUserId(userId).map { NoteResponse.fromNoteEntity(it) }
    }

}