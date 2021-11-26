package com.xyz.dal.repository.theater;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xyz.dal.entity.theater.TheaterMovieCatalogEntity;

public interface TheaterMovieCatalogRepository extends JpaRepository<TheaterMovieCatalogEntity, Long>{

	@Query("select t from TheaterMovieCatalogEntity t where t.theater.theaterId = :theaterId AND t.movie.movieId= :movieId")
	TheaterMovieCatalogEntity findByTheaterAndMovie(@Param("theaterId") Long theaterId, @Param("movieId") Long movieId);

	
}
