package com.technoelevate.resumebuilder.response;

import javax.persistence.Convert;

import com.technoelevate.resumebuilder.utils.StringListConverter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

	private boolean error;
	@Convert(converter = StringListConverter.class)
	private String messege;
	private Object data;

}
