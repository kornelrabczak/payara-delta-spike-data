package com.thecookiezen.deltaspike;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("book")
public class BooksResource {

    @GET
    @Path("{id}")
    public String getTitleById(@PathParam("id") int id) {
        return "test " + id;
    }

}
