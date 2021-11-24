package com.xyz.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.dal.entity.show.TheaterMovieCatalogEntity;

public interface TheaterShowRepository extends JpaRepository<TheaterMovieCatalogEntity, Long>{

}
