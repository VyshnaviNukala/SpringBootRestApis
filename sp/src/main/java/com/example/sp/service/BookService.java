//sb ques library management system
package com.example.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;  // Import this
import com.example.sp.Repos.BookRepository;
import com.example.sp.entity.Book;
import exception.UserNotFoundException;

@Service  // Add this annotation
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    public Book updateBook(Long id, Book book) {
        try {
            return bookRepository.findById(id)
                .map(existingBook -> {
                    existingBook.setTitle(book.getTitle());
                    existingBook.setAuthor(book.getauthor());
                    return bookRepository.save(existingBook);
                })
                .orElseThrow(() -> new UserNotFoundException("Book not found with ID: " + id));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
