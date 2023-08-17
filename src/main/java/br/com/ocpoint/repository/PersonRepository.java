package br.com.ocpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ocpoint.model.User;

@Repository
public interface PersonRepository extends JpaRepository<User, Integer> {

}