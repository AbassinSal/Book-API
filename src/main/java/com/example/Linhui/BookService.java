package com.example.Linhui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class BookService {
   @Autowired
   private BookRepository bookRepository;
    public Book createBook(Book book){
        return bookRepository.save(book);
      //  return (String) "Book saved...";
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public List<Book> findByTitle(String title){
        return bookRepository.findAllByTitle(title);
    }
    public List<Book> getAllByTitle(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return bookRepository.findAllByTitle(input);
    }



    public Book findById(Long id){
       return bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);

    }



   public List <Book> findByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    public List <Book> findByPublicationDate(Integer publicationDate){
        return bookRepository.findByPublicationDate(publicationDate);
    }

    public List <Book> findByGenre(String genre){
        return bookRepository.findByGenre(genre);
    }

    public long getCount(){
        return bookRepository.count();
        }


    public Book save(Book book){
        return bookRepository.save(book);
    }

   public void deleteById(Long id){
        bookRepository.deleteById(id);
   }
}
