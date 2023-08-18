package br.com.ocpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ocpoint.model.AccessGroup;
import br.com.ocpoint.model.User;

@Repository
public interface GroupRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT g FROM AccessGroup g where g.id = :id")
    public AccessGroup getGroupById(@Param("id") Integer id);

}
