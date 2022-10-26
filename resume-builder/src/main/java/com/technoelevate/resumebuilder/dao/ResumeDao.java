package com.technoelevate.resumebuilder.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technoelevate.resumebuilder.entity.Resume;

@Repository
public interface ResumeDao extends JpaRepository<Resume, Integer> {

	List<Resume> findAllByEmployeeId(String employeeId);

	Optional<Resume> findByResumeId(String resumeId);
	
	Optional<Resume> findByResumeIdAndEmployeeId(String resumeId, String employeeId);

}
