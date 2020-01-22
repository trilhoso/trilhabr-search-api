package br.com.trilhabr.api.repository;

import br.com.trilhabr.api.model.trilhabr.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
