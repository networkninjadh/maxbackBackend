package com.maxback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.maxback.models.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>{
	Optional<Profile> findByUsername(String username);
}
