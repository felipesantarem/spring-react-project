package com.codewithlipe.backendenviroment.repository;

import com.codewithlipe.backendenviroment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface de repositório que estende JpaRepository para realizar operações CRUD em entidades User
public interface UserRepository extends JpaRepository<User, Long> {
}
