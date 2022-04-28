package com.nartan.ba.resource.repository;

import com.nartan.ba.resource.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author evahhl
 */
@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {

//  List<UserLogin> findAll(Pageable pageable);

  @Query("select ul from #{#entityName} ul where ul.email = :email")
  UserLogin findbyEmail(@Param("email") String email);

  @Query("select ul from #{#entityName} ul where ul.email = :email and ul.password = :password")
  UserLogin login(@Param("email") String email, String password);

}
