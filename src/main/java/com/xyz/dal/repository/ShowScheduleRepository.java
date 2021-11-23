package com.xyz.dal.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xyz.dal.entity.show.ShowScheduleEntity;

public interface ShowScheduleRepository extends JpaRepository<ShowScheduleEntity, Long>
{
	@Query("select s from ShowScheduleEntity s \r\n"
			+ "JOIN TheaterShowEntity ts ON s.show.theaterShowId=ts.theaterShowId \r\n"
			+ "JOIN TheaterEntity t ON t.theaterId=ts.theater.theaterId\r\n"
			+ "WHERE \r\n"
			+ "s.date=:date\r\n"
			+ "AND ts.movie.movieId=:movieId AND s.date=:date\r\n"
			+ "AND t.city=:city")
	public List<ShowScheduleEntity> findShows(Long movieId, LocalDate date, String city);
	
}
