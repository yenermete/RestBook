package com.rest.methods;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.rest.entity.Book;
import com.rest.service.BookService;

@Path("books")
public class BookRestService {

	@Autowired
	private BookService bookService;
	
	@GET
    @Path("ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "Pinged!";
    }
	
	@GET
    @Path("/get/book/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBookListById(@PathParam("id") Long id) {
		return bookService.getBookById(id);
    }
	
	@GET
    @Path("/get/book/title")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBookListByTitle(@QueryParam("name") String title) {
		return bookService.getBooksByTitle(title);
    }
	
	@POST
    @Path("/insert/book/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookListById(Book book) {
		bookService.insertBook(book);
		return Response.status(Status.CREATED).entity(book).build();
    }
	
}
