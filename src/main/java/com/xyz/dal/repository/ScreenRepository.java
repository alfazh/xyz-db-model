package com.xyz.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.dal.entity.theater.ScreenEntity;

public interface ScreenRepository extends JpaRepository<ScreenEntity, Long>{

}