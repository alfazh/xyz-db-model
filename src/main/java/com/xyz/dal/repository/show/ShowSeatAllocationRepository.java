package com.xyz.dal.repository.show;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.dal.entity.theater.show.ShowSeatAllocationEntity;

public interface ShowSeatAllocationRepository extends JpaRepository<ShowSeatAllocationEntity, Long>{

}
