package com.nartan.ba.resource.repository;

import com.nartan.ba.resource.model.mappers.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author evahhl
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  Page<User> findAll(Pageable paging);

  @Query("select ul from #{#entityName} ul where ul.email = :email")
  User findbyEmail(@Param("email") String email);

}
