package com.timcook.capstone.dto.file;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.timcook.capstone.domain.File;

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
