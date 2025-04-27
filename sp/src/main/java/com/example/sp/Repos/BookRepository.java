//sb ques library management system
package com.example.sp.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sp.entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
