package com.xyz.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.dal.entity.theater.show.ShowEntity;

public interface ShowRepository extends JpaRepository<ShowEntity, Long>
{

}
