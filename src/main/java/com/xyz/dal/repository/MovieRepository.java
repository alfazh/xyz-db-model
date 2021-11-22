package com.xyz.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.dal.entity.movie.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, Long>{

}
