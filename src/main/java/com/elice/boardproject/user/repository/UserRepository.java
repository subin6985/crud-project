package com.elice.boardproject.user.repository;

import com.elice.boardproject.user.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsById(String id);
}
