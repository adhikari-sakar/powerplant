package com.proshore.powerplant.application.repository;

import com.proshore.powerplant.application.dto.Range;
import com.proshore.powerplant.application.mapper.BatteryMapper;
import com.proshore.powerplant.domain.contracts.BaseRepository;
import com.proshore.powerplant.domain.model.Battery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;

@Repository
@AllArgsConstructor
public class BatteryRepository implements BaseRepository<Battery> {

    private final BatteryJpaRepository jpaRepository;
    private final BatteryMapper mapper;

    @Override
    public List<Battery> findByRange(Range range) {
        return jpaRepository
                .findAllByPostcodeBetween(parseInt(range.getFrom()), parseInt(range.getTo()))
                .stream()
                .map(mapper::toModel)
                .collect(toList());
    }

    @Override
    public void saveAll(List<Battery> batteries) {
        jpaRepository.saveAll(mapper.toEntities(batteries));
    }
}
