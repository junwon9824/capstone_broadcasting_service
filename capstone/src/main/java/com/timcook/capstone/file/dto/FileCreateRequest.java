package com.timcook.capstone.file.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.timcook.capstone.file.domain.File;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FileCreateRequest {
		
	@NotNull
	private Long villageId;
	@NotNull
	@Size(max = 100)
	private String contents;
	
}
