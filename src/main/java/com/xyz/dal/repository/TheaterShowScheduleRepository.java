package com.xyz.dal.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xyz.dal.entity.show.TheaterShowScheduleEntity;

public interface TheaterShowScheduleRepository extends JpaRepository<TheaterShowScheduleEntity, Long>{
	
	@Query("select tss from TheaterShowScheduleEntity tss \r\n"
			+ "JOIN TheaterMovieCatalogEntity ts ON tss.theaterCatalog.theater.theaterId=ts.theater.theaterId \r\n"
			+ "JOIN TheaterEntity t ON t.theaterId=ts.theater.theaterId\r\n"
			+ "WHERE \r\n"
			+ "tss.date=:date\r\n"
			+ "AND ts.movie.movieId=:movieId \r\n"
			+ "AND t.city=:city")
	public List<TheaterShowScheduleEntity> findShows(@Param("movieId") Long movieId, @Param("date") LocalDate date, @Param("city") String city);
	
}
