package br.com.ocpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ocpoint.model.Person;
import br.com.ocpoint.model.User;

public interface PersonRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT p FROM Person p where p.document = :document")
    public Person getPersonByDocument(@Param("document") String document);

}
