package com.xyz.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.dal.entity.show.ShowPricingEntity;

public interface ShowPricingRepository extends JpaRepository<ShowPricingEntity, Long> {

}
