package com.technoelevate.resumebuilder.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.persistence.AttributeConverter;

public class StringListConverter implements AttributeConverter<List<String>, String>  {
	


	@Override
	public String convertToDatabaseColumn(List<String> attribute) {
		 return attribute == null ? null : String.join(",",attribute);
	}

	@Override
	public List<String> convertToEntityAttribute(String dbData) {
		  return dbData == null ? Collections.emptyList() : Arrays.asList(dbData.split(","));
	}

}
