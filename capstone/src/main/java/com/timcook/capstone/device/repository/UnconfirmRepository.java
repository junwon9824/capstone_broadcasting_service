package com.timcook.capstone.device.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timcook.capstone.device.domain.Unconfirm;

public interface UnconfirmRepository extends JpaRepository<Unconfirm, Long>{

}
