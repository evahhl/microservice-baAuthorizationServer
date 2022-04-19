/**
 * 
 */
package com.nartan.ba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nartan.ba.model.VUserInfo;



/**
 * @author evahhl
 *
 */
@Repository
public interface VUserInfoRepository extends JpaRepository<VUserInfo, Integer> {

	  VUserInfo findByEmail(String email);	

}
