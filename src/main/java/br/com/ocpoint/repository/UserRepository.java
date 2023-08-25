package br.com.ocpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ocpoint.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByNameuser(String username);

}