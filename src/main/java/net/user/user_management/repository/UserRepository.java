package net.user.user_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.user.user_management.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    public boolean existsByEmail(String email);

    public User findByEmail(String email);
}
