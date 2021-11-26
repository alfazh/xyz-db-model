package com.xyz.dal.repository.theater.screen;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xyz.dal.entity.theater.screen.ScreenSeatRowEntity;

public interface TheaterScreenSeatLayoutRepository extends JpaRepository<ScreenSeatRowEntity, Long> {

	public List<ScreenSeatRowEntity> findBySeatClass(String seatClass);

	@Query("select s from ScreenSeatRowEntity s \r\n"
			+ "where s.theaterScreen.screenId=:screenId")
	public List<ScreenSeatRowEntity> findByScreenId(@Param("screenId") Integer screenId);
	
}
