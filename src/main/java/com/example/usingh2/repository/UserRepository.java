//package com.example.demoUsingDB.repository;
//
//public class UserRepository {
//

package com.example.usingh2.repository;

import com.example.usingh2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<User, Long> means:
// - User = entity type
// - Long = type of primary key
public interface UserRepository extends JpaRepository<User, Long> {
}
