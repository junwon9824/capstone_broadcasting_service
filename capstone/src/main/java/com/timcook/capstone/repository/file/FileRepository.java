package com.timcook.capstone.repository.file;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timcook.capstone.domain.File;

public interface FileRepository extends JpaRepository<File, Long>{

}
