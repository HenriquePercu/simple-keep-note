package com.example.keep.controller

import com.example.keep.manager.NoteManager
import com.example.keep.model.NoteRequest
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("/v1/keep")
class NoteResource(

    private val noteManager: NoteManager

) {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun createKeep(note: NoteRequest){

        noteManager.storeNote(note)

    }

}