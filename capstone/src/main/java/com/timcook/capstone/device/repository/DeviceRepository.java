package com.timcook.capstone.device.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.timcook.capstone.device.domain.Device;
import com.timcook.capstone.device.domain.Disabled;

public interface DeviceRepository extends JpaRepository<Device, Long>, CustomDeviceRepository{

	
}
