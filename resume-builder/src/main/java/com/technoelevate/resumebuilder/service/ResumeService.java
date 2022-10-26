package com.technoelevate.resumebuilder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.technoelevate.resumebuilder.dto.ResumeDto;
import com.technoelevate.resumebuilder.entity.Resume;

@Service
public interface ResumeService {

	Resume saveResume(ResumeDto dto);
	List<String> findByEmpId(String employeeId);
	Resume findByResumeIdAndEmpId(ResumeDto empIdAndResId);
	Resume updateResume(ResumeDto dto);
	
	
}
