package com.technoelevate.resumebuilder.dto;

import static com.technoelevate.resumebuilder.constants.ResumeConstants.BIRTH_DATE_MUST_N_OT_BE_A_FUTURE_DATE;
import static com.technoelevate.resumebuilder.constants.ResumeConstants.EMAIL_MUST_NOT_BE_EMPTY;
import static com.technoelevate.resumebuilder.constants.ResumeConstants.EMAIL_VALIDATION;
import static com.technoelevate.resumebuilder.constants.ResumeConstants.EMAIL_VALIDATION1;
import static com.technoelevate.resumebuilder.constants.ResumeConstants.FIRST_NAME_SHOULD_HAVE_AT_LEAST_2_CHARACTERS;
import static com.technoelevate.resumebuilder.constants.ResumeConstants.MM_DD_YYYY_HH_MM_SS;
import static com.technoelevate.resumebuilder.constants.ResumeConstants.NAME_SHOULD_NOT_BE_EMPTY;
import static com.technoelevate.resumebuilder.constants.ResumeConstants.NAME_SHOULD_NOT_CONTAIN_SPACES_NUMBERS_AND_SPECIAL_CHARACTERS;
import static com.technoelevate.resumebuilder.constants.ResumeConstants.NAME_VALIDATION;
import static com.technoelevate.resumebuilder.constants.ResumeConstants.PHONE_NUMBER_MUST_CONTAIN_10_DIGITS;
import static com.technoelevate.resumebuilder.constants.ResumeConstants.PHONE_NUMBER_SHOULD_NOT_BE_NULL;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.technoelevate.resumebuilder.entity.Education;
import com.technoelevate.resumebuilder.entity.ProjectDetails;
import com.technoelevate.resumebuilder.entity.Skills;

import lombok.Data;

@Data
public class ResumeDto {

	private String resumeId;

	private String employeeId;

	@NotEmpty(message = EMAIL_MUST_NOT_BE_EMPTY)
	@Email(regexp = EMAIL_VALIDATION + EMAIL_VALIDATION1)
	private String email;

	@NotNull(message = PHONE_NUMBER_SHOULD_NOT_BE_NULL)
	@Min(value = 1000000000, message = PHONE_NUMBER_MUST_CONTAIN_10_DIGITS)
	@Max(value = 9999999999l, message = PHONE_NUMBER_MUST_CONTAIN_10_DIGITS)
	private long phoneNumber; // strung

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = MM_DD_YYYY_HH_MM_SS)
	@Past(message = BIRTH_DATE_MUST_N_OT_BE_A_FUTURE_DATE)
	private LocalDateTime dateOfBirth;

	@NotEmpty(message = NAME_SHOULD_NOT_BE_EMPTY)
	@Size(min = 2, max = 10, message = FIRST_NAME_SHOULD_HAVE_AT_LEAST_2_CHARACTERS)
	@Pattern(regexp = NAME_VALIDATION, message = NAME_SHOULD_NOT_CONTAIN_SPACES_NUMBERS_AND_SPECIAL_CHARACTERS)
	private String firstName;

	@NotEmpty(message = NAME_SHOULD_NOT_BE_EMPTY)
	@Pattern(regexp = NAME_VALIDATION, message = NAME_SHOULD_NOT_CONTAIN_SPACES_NUMBERS_AND_SPECIAL_CHARACTERS)
	private String lastName;

	@NotEmpty
	private String totalExperience;

	@NotEmpty
	private String relevantExperience;

	@NotEmpty
	private List<String> technologies;

	@NotEmpty
	private List<String> summary;

	@Valid
	private Skills skills;

	@Valid
	private Education educationDetails;

	@Valid
	private List<ProjectDetails> projectDetails;

}
