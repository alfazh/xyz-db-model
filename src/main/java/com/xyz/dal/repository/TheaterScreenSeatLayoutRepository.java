package com.xyz.dal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.dal.entity.theater.screen.TheaterScreenLayoutEntity;

public interface TheaterScreenSeatLayoutRepository extends JpaRepository<TheaterScreenLayoutEntity, Long> {

	public List<TheaterScreenLayoutEntity> findBySeatClass(String seatClass);
	
}
