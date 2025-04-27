//sb ques library management system
package com.example.sp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sp.Repos.BookRepository;
import com.example.sp.Repos.UserRepository;
import com.example.sp.entity.Book;
import com.example.sp.entity.User;
import com.example.sp.service.BookService;
import com.example.sp.service.UserService;

@RestController   //controller +requestbody
@RequestMapping("/api/v1")   //http://localhost:9090:/api/v1/user
public class LibraryController {

	@Autowired 
	private UserRepository userRepository;
    
	@Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private UserService userService;
 
    @Autowired
    private BookService bookService;
    
   
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
    	 List<User> users=userRepository.findAll();
    	 return ResponseEntity.ok(users);      
    }
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return ResponseEntity.ok(books);
    }
   
    @GetMapping("/getusers/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);  
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/getbooks/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) { 
        Optional<Book> book = bookRepository.findById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    
    @PostMapping("/createuser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }
   
    @PostMapping("/createbook")
    public ResponseEntity<Book>createbook(@RequestBody Book book){
    	Book savedBook= bookRepository.save(book);
    	return ResponseEntity.ok(savedBook);
    }

    
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
  
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id){
    	if(bookRepository.existsById(id)) {
    		bookRepository.deleteById(id);
    		return ResponseEntity.noContent().build();
    	}
    	return ResponseEntity.notFound().build();
    }
    
    @PutMapping("/updateusers/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }
    
    @DeleteMapping("/deleteall")
    public ResponseEntity<Void> deleteAllUser(){
    	userRepository.deleteAll();
    	return ResponseEntity.noContent().build();
    }
  
   @PutMapping("/updatebooks/{id}")
   public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
	   Book updatedBook=bookService.updateBook(id,book);
	   return ResponseEntity.ok(updatedBook);
			   
   }
   @DeleteMapping("/books")
   public ResponseEntity<Void> deleteAllBooks() {
       bookRepository.deleteAll();
       return ResponseEntity.noContent().build();
   }

    
}


