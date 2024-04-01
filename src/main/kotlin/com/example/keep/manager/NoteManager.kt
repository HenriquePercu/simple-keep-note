package com.example.keep.manager

import com.example.keep.model.NoteRequest
import com.example.keep.repository.NoteRepository
import jakarta.enterprise.context.ApplicationScoped
import java.util.*

@ApplicationScoped
class NoteManager(
    private val noteRepository: NoteRepository
) {

    fun storeNote(noteRequest: NoteRequest): UUID {
        return noteRepository.storeNote(noteRequest.toNoteEntity()).noteId
    }

}