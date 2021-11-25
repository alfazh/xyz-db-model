package com.xyz.dal.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xyz.dal.entity.theater.show.ShowScheduleEntity;

public interface ShowScheduleRepository extends JpaRepository<ShowScheduleEntity, Long>{
	
	@Query("select ss from ShowScheduleEntity ss \r\n"
			+ "JOIN TheaterMovieCatalogEntity ts ON ss.theaterCatalog.theater.theaterId=ts.theater.theaterId \r\n"
			+ "JOIN TheaterEntity t ON t.theaterId=ts.theater.theaterId\r\n"
			+ "WHERE \r\n"
			+ "ss.date=:date\r\n"
			+ "AND ts.movie.movieId=:movieId \r\n"
			+ "AND t.city=:city")
	public List<ShowScheduleEntity> getShowSchedule(@Param("movieId") Long movieId, @Param("date") LocalDate date, @Param("city") String city);
	
	
	@Query("select ss from ShowScheduleEntity ss \r\n"
			+ "where ss.theaterCatalog.theater.theaterId=:theaterId \r\n"
			+ "and ss.theaterCatalog.movie.movieId=:movieId\r\n"
			+ "and ss.date=:date")
	public List<ShowScheduleEntity> lookupShowSchedule(@Param("theaterId") Long theaterId, @Param("movieId") Long movieId, @Param("date") LocalDate date);
	
	@Query("select ss from ShowScheduleEntity ss \r\n"
			+ "where ss.theaterCatalog.theaterMovieCatalogId=:theaterMovieCatalogId \r\n"
			+ "and ss.date=:date")
	public List<ShowScheduleEntity> lookupShowSchedule(@Param("theaterMovieCatalogId") Long theaterMovieCatalogId, @Param("date") LocalDate date);
	
	@Query("select ss from ShowScheduleEntity ss \r\n"
			+ "where ss.showScheduleId=:scheduleId")
	public ShowScheduleEntity lookupShowSchedule(@Param("scheduleId") Long scheduleId);
	
}
