package com.proshore.powerplant.application.repository;

import com.proshore.powerplant.application.entity.BatteryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatteryJpaRepository extends JpaRepository<BatteryEntity, Long> {
    List<BatteryEntity> findAllByPostcodeBetween(Integer from, Integer to);
}
