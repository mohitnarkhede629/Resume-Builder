package com.technoelevate.resumebuilder.service;

import static com.technoelevate.resumebuilder.constants.ResumeConstants.RES;
import static com.technoelevate.resumebuilder.constants.ResumeConstants.RESUME_WITH_EMPLOYEE_ID;
import static com.technoelevate.resumebuilder.constants.ResumeConstants.RESUME_WITH_RESUME_ID;
import static com.technoelevate.resumebuilder.constants.ResumeConstants.WAS_NOT_FOUND;
import static com.technoelevate.resumebuilder.constants.ResumeConstants.AND_EMPLOYEE_ID;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technoelevate.resumebuilder.customexception.EmployeeIdNotFoundException;
import com.technoelevate.resumebuilder.dao.ResumeDao;
import com.technoelevate.resumebuilder.dto.ResumeDto;
import com.technoelevate.resumebuilder.entity.Resume;

@Service
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeDao resumeDao;


	@Override
	public Resume saveResume(ResumeDto dto) {
		try {
			Resume resume = new Resume();
			BeanUtils.copyProperties(dto, resume);
			List<Resume> list = resumeDao.findAllByEmployeeId(dto.getEmployeeId());
			resume.setResumeId(RES + "_" + resume.getRelevantExperience() + "_" + (list.size() + 1));
			resumeDao.save(resume);
			return resume;
		} catch (Exception e) {

			throw e;
		}

	}

	
	@Override
	public List<String> findByEmpId(String employeeId) {
		try {

			List<String> listOfResId = new ArrayList<>();
			for (Resume resume : resumeDao.findAllByEmployeeId(employeeId)) {
				listOfResId.add(resume.getResumeId());
			}

			if (listOfResId.isEmpty()) {
				throw new EmployeeIdNotFoundException(RESUME_WITH_EMPLOYEE_ID + employeeId + WAS_NOT_FOUND);
			}
			return listOfResId;

		} catch (EmployeeIdNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public Resume findByResumeIdAndEmpId(ResumeDto dto) {

		try {
			Optional<Resume> resume = resumeDao.findByResumeIdAndEmployeeId(dto.getResumeId(),
					dto.getEmployeeId());
			if (resume.isPresent()) {
				return resume.get();
			} else {
				throw new EmployeeIdNotFoundException(RESUME_WITH_RESUME_ID + dto.getResumeId()
						+ AND_EMPLOYEE_ID + dto.getEmployeeId() + WAS_NOT_FOUND);
			}
		} catch (EmployeeIdNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public Resume updateResume(ResumeDto dto) {
		try {
			Optional<Resume> resume = resumeDao.findByResumeIdAndEmployeeId(dto.getResumeId(),
					dto.getEmployeeId());
			if (resume.isPresent()) {
				Resume resume2 = resume.get();
				resume2.getResumeId().split(RES, 0);
				BeanUtils.copyProperties(dto, resume2);
				return resume.get();
			} 
			
		} catch (Exception e) {
		}
		return null;
	}

}
