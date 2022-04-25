package com.timcook.capstone.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@EntityListeners(EntityListeners.class)
public class File {

	@Id @GeneratedValue
	@Column(name = "FILE_ID")
	@NotNull
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	@NotNull
	private Admin admin;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VILLAGE_ID")
	@NotNull
	private Village village;
	
	@NotNull
	@Size(max = 100)
	@Column(length = 100)
	private String contents;
	
	@CreatedDate
	private LocalDateTime createdTime;
}
