package com.bezkoder.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bezkoder.spring.datajpa.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	Client findByClientId(Integer clientId);

	Client findByMobileNumber(Long mobileNumber);

	List<Client> findByFirstName(String firstName);

}
