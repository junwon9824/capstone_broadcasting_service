package com.timcook.capstone.file.dto;

import java.time.LocalDateTime;

import com.timcook.capstone.file.domain.File;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FileResponse {

	private String title;
	private String contents;
	private LocalDateTime createdTime;

	@Builder
	public FileResponse(String title, String contents, LocalDateTime createdTime) {
		this.title = title;
		this.contents = contents;
		this.createdTime = createdTime;
	}
	
	public static FileResponse from(File file) {
		return FileResponse.builder()
						.title(file.getTitle())
						.contents(file.getContents())
						.createdTime(file.getCreatedTime())
						.build();
	}
	
}
