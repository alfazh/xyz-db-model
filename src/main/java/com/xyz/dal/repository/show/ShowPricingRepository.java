package com.xyz.dal.repository.show;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.dal.entity.theater.show.ShowPricingEntity;

public interface ShowPricingRepository extends JpaRepository<ShowPricingEntity, Long> {

}
