package com.example.keep.controller

import com.example.keep.entity.Note
import com.example.keep.manager.NoteManager
import com.example.keep.model.NoteRequest
import com.example.keep.model.NoteResponse
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import org.jboss.resteasy.reactive.RestResponse
import java.util.UUID

@Path("/v1/keep")
class NoteResource(

    private val noteManager: NoteManager

) {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun createNote(note: NoteRequest): RestResponse<UUID> {
        return RestResponse.accepted(noteManager.storeNote(note))

    }


    @GET
    @Path("/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getNote(@PathParam("key") key: UUID): RestResponse<NoteResponse> {
        return RestResponse.ok(noteManager.getNote(key))
    }


}