package com.thecookiezen.deltaspike;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

@Path("book")
public class BooksResource {

    private final static Logger LOGGER = Logger.getLogger(BooksResource.class.getSimpleName());

    @Inject
    BooksRepository booksRepository;

    @GET
    @Path("{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getByTitle(@PathParam("title") String title) {
        return booksRepository.findByTitle(title);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAll() {
        return booksRepository.findAll();
    }

    @GET
    @Path("/count")
    public long count() {
        return booksRepository.count();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(JsonObject object) {
        LOGGER.info("create " + object);
        Book book = new Book();
        book.setTitle(object.getString("title"));
        booksRepository.save(book);
        return Response.created(URI.create("test")).build();
    }

}
