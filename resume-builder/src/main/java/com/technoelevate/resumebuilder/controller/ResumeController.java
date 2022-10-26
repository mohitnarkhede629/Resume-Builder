package com.technoelevate.resumebuilder.controller;

import static com.technoelevate.resumebuilder.constants.ResumeConstants.DATA_SAVED_SUCCESSFULLY;
import static com.technoelevate.resumebuilder.constants.ResumeConstants.RECORD_FETCHED_SUCCESSFULLY;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.technoelevate.resumebuilder.dto.ResumeDto;
import com.technoelevate.resumebuilder.response.Response;
import com.technoelevate.resumebuilder.service.ResumeService;

@RestController
public class ResumeController {

	@Autowired
	private ResumeService resumeService;

	// Saving Data In Data Base

	@PostMapping("saveresumedata")
	public ResponseEntity<Response> saveResume(@Valid @RequestBody ResumeDto resumeDto ) {
		return new ResponseEntity<>(new Response(false, DATA_SAVED_SUCCESSFULLY, resumeService.saveResume(resumeDto)),
				HttpStatus.OK);
	}

	@GetMapping("getallbyempid")
	public ResponseEntity<Response> findByEmpId(@RequestParam String empid) {
		return new ResponseEntity<>(new Response(false, RECORD_FETCHED_SUCCESSFULLY, resumeService.findByEmpId(empid)),
				HttpStatus.OK);

	}

	/**
	 * Fetching Data Based On Resume Id
	 * 
	 * @author mohit
	 * @param resumeId
	 * @return
	 */
	@GetMapping("getbyresumeidandempid")
	public ResponseEntity<Response> findByResumId(@RequestBody ResumeDto empIdAndResId) {
		return new ResponseEntity<>(
				new Response(false, RECORD_FETCHED_SUCCESSFULLY, resumeService.findByResumeIdAndEmpId(empIdAndResId)),
				HttpStatus.OK);
	}

}
