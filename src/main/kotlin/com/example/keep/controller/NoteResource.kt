package com.example.keep.controller

import com.example.keep.manager.NoteManager
import com.example.keep.model.NoteRequest
import com.example.keep.model.NoteResponse
import io.quarkus.oidc.UserInfo

import jakarta.annotation.security.RolesAllowed
import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import org.jboss.resteasy.reactive.RestResponse
import java.util.*


@Path("/v1/keep")
class NoteResource(

    private val noteManager: NoteManager,
    @Inject
    private var userInfo: UserInfo
) {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    fun createNote(note: NoteRequest): RestResponse<UUID> {
        return RestResponse.accepted(noteManager.storeNote(note, userInfo.extractUserId()))
    }

    @GET
    @Path("/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getNote(@PathParam("key") key: UUID): RestResponse<NoteResponse> {
        return RestResponse.ok(noteManager.getNote(key, userInfo.extractUserId()))
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    fun getAllNotesFromUser(): RestResponse<List<NoteResponse>> {
        return RestResponse.ok(noteManager.getAllNotesByUserId(userInfo.extractUserId()))
    }

    fun UserInfo.extractUserId(): String =
        this.subject.split("|")[1]

}