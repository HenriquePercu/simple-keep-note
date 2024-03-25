package com.example.keep.controller

import com.example.keep.manager.KeepManager
import com.example.keep.model.Keep
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("/v1/keep")
class KeepResource(

    private val keepManager: KeepManager

) {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun createKeep(keep: Keep){

        println(keep)

    }

}