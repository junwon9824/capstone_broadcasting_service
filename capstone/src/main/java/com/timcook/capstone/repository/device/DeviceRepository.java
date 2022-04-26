package com.timcook.capstone.repository.device;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timcook.capstone.domain.Device;

public interface DeviceRepository extends JpaRepository<Device, Long>{

}
