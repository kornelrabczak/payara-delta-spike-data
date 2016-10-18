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
import java.util.List;
import java.util.Optional;

@Path("book")
public class BooksResource {

    @Inject
    private BooksRepository booksRepository;

    @GET
    @Path("/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getByTitle(@PathParam("title") String title) {
        return booksRepository.findByTitle(title);
    }

    @GET
    @Path("/{author}/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getByAuthorAndTitle(@PathParam("author") String author, @PathParam("title") String title) {
        return booksRepository.findByTitleAndAuthorOrderByCreatedDesc(title, author);
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getById(@PathParam("id") long id) {
        return booksRepository.findBy(id);
    }

    @GET
    @Path("/isbn/{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getByIsbn(@PathParam("isbn") String isbn) {
        Optional<Book> byISBNNumber = booksRepository.findByISBNNumber(isbn);
        if (byISBNNumber.isPresent())
            return byISBNNumber.get();

        return new Book();
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
        Book book = new Book();
        book.setIsbn(object.getString("isbn"));
        book.setTitle(object.getString("title"));
        book.setAuthor(object.getString("author"));
        booksRepository.save(book);
        return Response.ok().build();
    }

}
