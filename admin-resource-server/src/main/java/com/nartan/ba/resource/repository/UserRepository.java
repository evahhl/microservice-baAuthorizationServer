package com.nartan.ba.resource.repository;

import com.nartan.ba.resource.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author evahhl
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  Page<User> findAll(Pageable paging);

}
