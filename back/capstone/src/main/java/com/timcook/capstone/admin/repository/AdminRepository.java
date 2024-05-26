package com.timcook.capstone.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timcook.capstone.admin.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>, CustomAdminRepository{

}
