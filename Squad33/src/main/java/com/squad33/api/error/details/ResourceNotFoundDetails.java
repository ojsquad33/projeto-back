package com.squad33.api.error.details;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceNotFoundDetails {

	private String title;
	private int status;
	private String detail;
	private long timestamp;
	private String developerMessage;

}