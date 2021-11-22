package com.xyz.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.dal.entity.theater.TheaterEntity;

public interface TheaterRepository extends JpaRepository<TheaterEntity, Long>{

}
