package com.microservice.user.service.repositories;

import com.microservice.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String >  {
}
