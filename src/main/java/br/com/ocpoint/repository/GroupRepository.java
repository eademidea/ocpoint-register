package br.com.ocpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ocpoint.model.AccessGroup;
import br.com.ocpoint.model.User;

public interface GroupRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT g FROM AccessGroup g where g.id = :id")
    public AccessGroup getGroupById(@Param("id") Integer id);

}
