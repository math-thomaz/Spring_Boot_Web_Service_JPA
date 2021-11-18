package com.maththomaz.webService.repositories;

import com.maththomaz.webService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
