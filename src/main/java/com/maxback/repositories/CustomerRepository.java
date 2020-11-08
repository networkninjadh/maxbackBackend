package com.maxback.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxback.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	Optional<Customer> findByUsername(String username);
}
