package br.com.trilhabr.api.repository;

import br.com.trilhabr.api.model.trilhabr.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findUserByEmailAndPassword(String email, String password);

    public boolean findUserByEmail(String email);
}
