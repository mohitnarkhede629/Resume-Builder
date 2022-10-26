package com.technoelevate.resumebuilder.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidationResponse {

	private boolean error;

	private List<String> message;
}
