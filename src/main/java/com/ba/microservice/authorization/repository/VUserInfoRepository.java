/**
 * 
 */
package com.ba.microservice.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ba.microservice.authorization.model.VUserInfo;



/**
 * @author evahhl
 *
 */
@Repository
public interface VUserInfoRepository extends JpaRepository<VUserInfo, Integer> {

	  VUserInfo findByEmail(String email);	

}
