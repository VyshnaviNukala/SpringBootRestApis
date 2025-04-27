//sb ques library management system
package com.example.sp.Repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sp.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

//	User updateUser(Long id, User user);

}
