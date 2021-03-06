package com.Itma.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Itma.model.UserInformation;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Integer> {
	
	
	UserInformation findByuserEmail(String email);
	List<UserInformation> findBybloodGroup(String bloodGroup);

}
