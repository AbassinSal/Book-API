package com.example.Linhui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Creates a Bean that will be controlled by Spring and can be identified to forwards requests to.
@RestController

// Determines the path of a controller. This will determine the paths for all underlying endpoints.
@RequestMapping("/api/v1")
public class Controller {
    @Autowired
    private BookService bookService;
    //GetMapping declares that any incoming request with an HTTP-Method = GET
    //and Path = "/hello" will be forwarded to the method "helloWorld()"
    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World!";
    }

/*
    Book in Java:

    class Book {
        String author;
        String title;
        String ISBN;
    }
    new Book("Max Mustermann", "Das Rezepte Buch von Max Mustermann", "12389122389NA")
________________________________

    Book in JSON:
    {
        "author":"Max Mustermann",
        "title":"Das Rezepte Buch von Max Mustermann",
        "ISBN":"12389122389NA"
    }
________________________________
    Deserialization of Book-JSON to Book.java via @RequestBody
    */

    /*
    * Szenario:
    * Bibliothek fraegt dich nach allen Buechern in der Datenbank
    *
    * */


    //get-requests
   @GetMapping(path = "/request/getAllBooks")
   public List<Book> getBook(){
        return bookService.getAll();
    }

   @GetMapping(path = "/request/getBookBy/{title}")
    public List<Book> getBookByTitle(@PathVariable String title){
       return bookService.findByTitle(title);
    }

    @GetMapping("/request/findBy/{id}")
    public Book findById(@PathVariable Long id){
       return bookService.findById(id);
    }

  /*  @GetMapping("/request/input")
    public List<Book> getBooksByInput(){
       return bookService.getAllByTitle();
    }
*/
    @GetMapping("/request/findByAuthor/{author}")
    public List<Book> findByAuthor(@PathVariable String author){
       return bookService.findByAuthor(author);
    }

    @GetMapping("/request/findByDate/{publicationDate}")
    public List <Book> findByPublicationDate(@PathVariable Integer publicationDate){
        return bookService.findByPublicationDate(publicationDate);
        }

    @GetMapping("/request/findByGenre/{genre}")
    public List <Book> findByGenre(@PathVariable String genre){
        return bookService.findByGenre(genre);
        }

    @GetMapping("/request/getCount")
    public long getCount(@PathVariable Long count){
        return bookService.getCount();
        }



    @PostMapping(path = "/request/add")
    public Book createBook(@RequestBody Book book){
       return bookService.save(book);
    }

    @PutMapping("/request/update/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id){
        bookService.deleteById(id);
        return bookService.save(book);
    }


    @DeleteMapping("/request/deleteBy/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteById(id);
    }
}