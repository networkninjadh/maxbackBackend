package com.maxback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxback.models.UserFiles;

@Repository
public interface UserFilesRepository extends JpaRepository<UserFiles, Long>{
	
}
